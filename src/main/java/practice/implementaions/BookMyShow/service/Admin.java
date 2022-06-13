package practice.implementaions.BookMyShow.service;

import practice.implementaions.BookMyShow.models.Account;
import practice.implementaions.BookMyShow.models.Cinema;
import practice.implementaions.BookMyShow.models.Movie;
import practice.implementaions.BookMyShow.models.Show;

public class Admin extends Account implements AdminBookMyShow {

    @Override
    public boolean addShow(Show show) {
        return false;
    }

    @Override
    public boolean addMovie(Movie movie) {
        return false;
    }

    @Override
    public boolean addCinema(Cinema cinema) {
        return false;
    }
}
