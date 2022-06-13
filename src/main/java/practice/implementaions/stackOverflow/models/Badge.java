package practice.implementaions.stackOverflow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Badge {
    private int id;
    private String name;
    private String description;

    public Badge(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
