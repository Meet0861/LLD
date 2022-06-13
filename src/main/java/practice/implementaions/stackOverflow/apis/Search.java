package practice.implementaions.stackOverflow.apis;

import practice.implementaions.stackOverflow.exceptions.NoQuestionFoundException;
import practice.implementaions.stackOverflow.models.Question;
import practice.implementaions.stackOverflow.models.Tag;
import practice.implementaions.stackOverflow.models.User;

import java.util.List;

public interface Search {
    List<Question> searchByTag(Tag tag);
    List<Question> searchByQuestionTitle(String title, int userId) throws NoQuestionFoundException;
}
