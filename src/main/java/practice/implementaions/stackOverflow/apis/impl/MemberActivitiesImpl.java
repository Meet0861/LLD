package practice.implementaions.stackOverflow.apis.impl;

import practice.implementaions.stackOverflow.Constants.ApplicationConstants;
import practice.implementaions.stackOverflow.apis.MemberActivities;
import practice.implementaions.stackOverflow.exceptions.MemberNotExists;
import practice.implementaions.stackOverflow.exceptions.NoQuestionFoundException;
import practice.implementaions.stackOverflow.exceptions.QuestionCreationException;
import practice.implementaions.stackOverflow.models.*;
import practice.implementaions.stackOverflow.services.QuestionAnswerService;

import java.util.Objects;

public class MemberActivitiesImpl implements MemberActivities {

    private final QuestionAnswerService questionService;

    public MemberActivitiesImpl() {
        this.questionService = new QuestionAnswerService();
    }

    @Override
    public Question postQuestion(String title, String description, String tagTitle, int askedBy) throws QuestionCreationException, MemberNotExists {
        Tag tag = questionService.createTag(tagTitle);
        Question question = questionService.createAndPostQuestion(title, description, tag, askedBy);
        if(Objects.isNull(question))
            throw new QuestionCreationException(ApplicationConstants.QUESTION_CREATION_FAILED);
        return question;
    }


    @Override
    public Boolean postAnswerToQuestion(int questionId, String answerTitle, String answerDescription, int userId) throws NoQuestionFoundException, QuestionCreationException, MemberNotExists {
        Question question = questionService.getQuestionById(questionId);
        return questionService.createAndPostAnswer(answerTitle, answerDescription, userId, question);
    }

    @Override
    public Boolean postCommentToQuestion(int questionId, String commentDescription, int user) {
        return null;
    }

    @Override
    public Boolean postCommentToAnswer(int answerId, String commentDescription, int userId) {
        return null;
    }

    @Override
    public Boolean upvoteToQuestion(int questionId, int member) {
        return null;
    }

    @Override
    public Boolean upvoteToAnswer(int answerId, int userId) {
        return null;
    }
}
