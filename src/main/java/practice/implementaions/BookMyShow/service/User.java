package practice.implementaions.BookMyShow.service;

import practice.implementaions.BookMyShow.Enum.Genre;
import practice.implementaions.BookMyShow.models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends Account implements BookMyShow {
    private static List<Movie> movieList = new ArrayList<>();

    private List<Movie> getWatchedMovies() {
        return movieList;
    }


    @Override
    public Ticket bookShow(Show show) {
        return null;
    }

    @Override
    public List<Booking> getBookings() {
        return null;
    }

    @Override
    public List<Booking> getBookings(Date fromDate, Date toDate) {
        return null;
    }
}
