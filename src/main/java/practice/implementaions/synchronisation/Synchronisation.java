package practice.implementaions.synchronisation;


class TicketBooking implements Runnable{
    private int availableTickets = 1;

    @Override
    public void run() {
        synchronized(this){
            if(availableTickets>0){
                System.out.println("booking ticket for : "+Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                availableTickets--;
                System.out.println("Ticket booked for : "+Thread.currentThread().getName());
            }
            else {
                System.out.println("ticket not booked for : "+Thread.currentThread().getName());
            }
        }
    }
}
public class Synchronisation {

    public static void main(String[] args){
        TicketBooking ticketBooking = new TicketBooking();
        Thread object1 = new Thread(ticketBooking, "passenger1");
        Thread object2 = new Thread(ticketBooking, "passenger2");
        object1.start();
        object2.start();
    }



}
