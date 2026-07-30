package RailwayReservationSystem;

class TicketBookingThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Ticket Booking Started...");
            Thread.sleep(2000);
            System.out.println("Passenger Details Saved.");
            System.out.println("Ticket Booking Completed.\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class PaymentThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Payment Started...");
            Thread.sleep(2000);
            System.out.println("Payment Successful.\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class SeatAllocationThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Seat Allocation Started...");
            Thread.sleep(2000);
            System.out.println("Seat Allocated.\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class TicketGenerationThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Ticket Generation Started...");
            Thread.sleep(2000);

            System.out.println("------------------------------");
            System.out.println(" Railway Reservation Ticket");
            System.out.println("------------------------------");
            System.out.println("Passenger : Sri");
            System.out.println("Train No  : 12636");
            System.out.println("Seat No   : B2-36");
            System.out.println("Status    : Confirmed");
            System.out.println("------------------------------");
            System.out.println("Ticket Generated Successfully.\n");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


public class RailwayReservationSystem {
     public static void main(String[] args) throws InterruptedException {

        TicketBookingThread booking = new TicketBookingThread();
        PaymentThread payment = new PaymentThread();
        SeatAllocationThread seat = new SeatAllocationThread();
        TicketGenerationThread ticket = new TicketGenerationThread();

        booking.start();
        booking.join();

        payment.start();
        payment.join();

        seat.start();
        seat.join();

        ticket.start();
        ticket.join();

        System.out.println("Reservation Completed Successfully.");
    }
}
