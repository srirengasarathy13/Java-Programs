package com.jpa.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(LeaveNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLeaveNotFound(LeaveNotFoundException exception)
    {
        logger.warn("Leave not found exception: {}", exception.getMessage());
        ErrorResponse error = new ErrorResponse(exception.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    // NEW: Handle business rule violations
    @ExceptionHandler(LeaveRuleException.class)
    public ResponseEntity<ErrorResponse> handleLeaveRuleException(LeaveRuleException exception)
    {
        logger.warn("Leave rule violation: {}", exception.getMessage());
        ErrorResponse error = new ErrorResponse(exception.getMessage(), 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException exception) {
        logger.warn("Request validation failed: {}", exception.getMessage());
        ErrorResponse error = new ErrorResponse("Invalid request data", 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception exception)
    {
        logger.error("Unexpected error while processing the request", exception);
        ErrorResponse error = new ErrorResponse("An unexpected error occurred", 500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}