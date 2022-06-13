package practice.implementaions.stackOverflow.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Answer {
    private int id;
    private String title;
    private String description;
    private int voteCount;
    private Timestamp createdAt;
    private Question question;
    private Member postedBy;
    List<Comment> comments;

    public Answer(int id, String title, String description, int voteCount, Timestamp createdAt, Question question, Member postedBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.voteCount = voteCount;
        this.createdAt = createdAt;
        this.question = question;
        this.postedBy = postedBy;
        this.comments = new ArrayList<>();
    }

    public void incrementVoteCount(){
        this.voteCount++;
    }

    public void decrementVoteCount(){
        this.voteCount--;
    }
}
