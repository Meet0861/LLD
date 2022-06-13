package practice.implementaions.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;
import practice.implementaions.BookMyShow.Enum.Address;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Cinema {
    private int id;
    private String name;
    private Address address;
    private List<Audi> audis;
    private Map<Date, List<Movie>> moviesByDate;
    private Map<Date, List<Show>> showsByDate;

}
