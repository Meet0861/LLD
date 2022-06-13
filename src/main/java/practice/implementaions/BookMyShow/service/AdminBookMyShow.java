package practice.implementaions.BookMyShow.service;

import practice.implementaions.BookMyShow.models.*;

import java.util.Date;
import java.util.List;

public interface AdminBookMyShow {
    boolean addShow(Show show);
    boolean addMovie(Movie movie);
    boolean addCinema(Cinema cinema);
}
