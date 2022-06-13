package practice.implementaions.stackOverflow.apis.impl;

import practice.implementaions.stackOverflow.apis.Search;
import practice.implementaions.stackOverflow.exceptions.NoQuestionFoundException;
import practice.implementaions.stackOverflow.models.Question;
import practice.implementaions.stackOverflow.models.Tag;
import practice.implementaions.stackOverflow.services.QuestionAnswerService;

import java.util.List;

public class SearchImpl implements Search {

    private final QuestionAnswerService questionAnswerService;

    public SearchImpl() {
        this.questionAnswerService = new QuestionAnswerService();
    }

    @Override
    public List<Question> searchByTag(Tag tag) {
        return null;
    }

    @Override
    public List<Question> searchByQuestionTitle(String title, int userId) throws NoQuestionFoundException {
        return questionAnswerService.questionByTitle(title);
    }
}
