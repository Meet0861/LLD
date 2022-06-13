package practice.implementaions.BookMyShow.models;

import practice.implementaions.BookMyShow.Enum.BookingStatus;

import java.util.Date;
import java.util.List;

public class Booking {
    private int BookingId;
    private Date bookingDateAndTime;
    private List<Seat> seats;
    private BookingStatus bookingStatus;
    //payment
    private double amount;

    public boolean makePayment(Payment payment){
        return false;
    }

}
