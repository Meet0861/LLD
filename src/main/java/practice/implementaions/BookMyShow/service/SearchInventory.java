package practice.implementaions.BookMyShow.service;

import practice.implementaions.BookMyShow.models.Audi;
import practice.implementaions.BookMyShow.models.Cinema;
import practice.implementaions.BookMyShow.Enum.Genre;
import practice.implementaions.BookMyShow.Enum.Language;
import practice.implementaions.BookMyShow.models.Movie;
import practice.implementaions.BookMyShow.models.Seat;

import java.util.List;

public interface SearchInventory {
    List<Movie> getMoviesList(String city);
    List<Movie> getMoviesList(Genre genre, String city);
    List<Movie> getMoviesList(String title, String city);
    List<Movie> getMoviesList(Language language, String city);
    List<Cinema> getCinemaList(String city, Movie movie);
    List<Seat> getSeats(Cinema cinema, Audi audi);
}
