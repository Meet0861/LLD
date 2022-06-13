package practice.implementaions.stackOverflow.apis;

import practice.implementaions.stackOverflow.exceptions.MemberNotExists;
import practice.implementaions.stackOverflow.exceptions.NoQuestionFoundException;
import practice.implementaions.stackOverflow.exceptions.QuestionCreationException;
import practice.implementaions.stackOverflow.models.Question;

public interface MemberActivities {

    Question postQuestion(String title, String description, String tagTitle, int askedBy) throws QuestionCreationException, MemberNotExists;

    Boolean postAnswerToQuestion(int questionId, String answerTitle, String answerDescription, int userId) throws NoQuestionFoundException, QuestionCreationException, MemberNotExists;

    Boolean postCommentToQuestion(int questionId, String commentDescription, int userId);

    Boolean postCommentToAnswer(int answerId, String commentDescription, int userId);

    Boolean upvoteToQuestion(int questionId, int userId);

    Boolean upvoteToAnswer(int answerId, int userId);
}
