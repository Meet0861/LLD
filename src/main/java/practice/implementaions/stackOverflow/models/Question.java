package practice.implementaions.stackOverflow.models;

import lombok.Getter;
import lombok.Setter;
import practice.implementaions.stackOverflow.enums.QuestionStatus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Question {
    private int id;
    private String title;
    private QuestionStatus questionStatus;
    private Tag tag;
    private String description;
    private int voteCount;
    private Timestamp creationTime;
    private Timestamp updationTime;
    private List<Comment> comments;
    private List<Answer> answers;
    private Member askedBy;

    public Question(int id, String title, QuestionStatus questionStatus, Tag tag, String description, int voteCount, Timestamp creationTime, Timestamp updationTime, Member askedBy) {
        this.id = id;
        this.title = title;
        this.questionStatus = questionStatus;
        this.tag = tag;
        this.description = description;
        this.voteCount = voteCount;
        this.creationTime = creationTime;
        this.updationTime = updationTime;
        this.askedBy = askedBy;
        this.comments = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    public void incrementVoteCount(){
        this.voteCount++;
    }

    public void decrementVoteCount(){
        this.voteCount--;
    }

}
