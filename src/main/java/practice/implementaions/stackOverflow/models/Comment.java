package practice.implementaions.stackOverflow.models;

import java.sql.Timestamp;


public class Comment {
    private int id;
    private String description;
    private int voteCount;
    private Timestamp createdAt;
    private Answer answer;
    private Member postedBy;

    public Comment(int id, String description, int voteCount, Timestamp createdAt, Answer answer, Member postedBy) {
        this.id = id;
        this.description = description;
        this.voteCount = voteCount;
        this.createdAt = createdAt;
        this.answer = answer;
        this.postedBy = postedBy;
    }

    public void incrementVoteCount(){
        this.voteCount++;
    }

    public void decrementVoteCount(){
        this.voteCount--;
    }
}
