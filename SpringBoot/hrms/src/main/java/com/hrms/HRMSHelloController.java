package com.hrms;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HRMSHelloController {

    @GetMapping(value  = "/hrms", produces = MediaType.TEXT_PLAIN_VALUE)
    public String welcome() {
        return "Name : R Sri Rengasarathy\nCompany : Agnie Consulting\nLocation : Chennai";
    }
}


