package practice.implementaions.BookMyShow.service;

import practice.implementaions.BookMyShow.models.Account;
import practice.implementaions.BookMyShow.models.Booking;
import practice.implementaions.BookMyShow.models.Show;
import practice.implementaions.BookMyShow.models.Ticket;

import java.util.Date;
import java.util.List;

public interface BookMyShow {
    Ticket bookShow(Show show);
    List<Booking> getBookings();
    List<Booking> getBookings(Date fromDate, Date toDate);
}
