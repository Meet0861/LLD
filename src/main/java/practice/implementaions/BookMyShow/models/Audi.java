package practice.implementaions.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Audi {
    private int id;
    private String name;
    private int size;
    private List<Seat> seats;
    private List<Show> shows;
    private Cinema cinema;
}
