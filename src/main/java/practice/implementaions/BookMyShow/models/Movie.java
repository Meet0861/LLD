package practice.implementaions.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;
import practice.implementaions.BookMyShow.Enum.Genre;
import practice.implementaions.BookMyShow.Enum.Language;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Movie {
    private int id;
    private String title;
    private Genre genre;
    private Language language;
    private List<Person> actors;
    private String director;
    private String producer;
    private Float duration;
    private Date releaseDate;
    private Map<String, List<Show>> cityShowMap;
    private List<Cinema> cinemaList;

}
