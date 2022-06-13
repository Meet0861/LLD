package practice.implementaions.stackOverflow.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tag {
    private int id;
    private String topic;

    public Tag(int id, String topic) {
        this.id = id;
        this.topic = topic;
    }
}
