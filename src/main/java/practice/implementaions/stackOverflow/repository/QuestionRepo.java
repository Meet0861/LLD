package practice.implementaions.stackOverflow.repository;

import lombok.Getter;
import practice.implementaions.stackOverflow.Constants.ApplicationConstants;
import practice.implementaions.stackOverflow.exceptions.NoQuestionFoundException;
import practice.implementaions.stackOverflow.models.Member;
import practice.implementaions.stackOverflow.models.Question;
import practice.implementaions.stackOverflow.models.Tag;

import java.util.*;

@Getter
public class QuestionRepo {
    private static Map<Member, List<Question>> userQuestionMap;
    private static Map<Tag, List<Question>> questionByTagMap;
    private static Map<String, List<Question>> questionsByTitle;
    private static Map<Integer, Question> questionById;

    public QuestionRepo() {
        userQuestionMap = new HashMap<>();
        questionByTagMap = new HashMap<>();
        questionsByTitle = new HashMap<>();
        questionById = new HashMap<>();
    }

    public List<Question> getQuestionsByTitle(String title) throws NoQuestionFoundException {
        List<Question> questions = QuestionRepo.questionsByTitle.getOrDefault(title, new ArrayList<>());
        if (questions.isEmpty())
            throw new NoQuestionFoundException(ApplicationConstants.NO_QUESTION_FOUND + title);
        return questions;
    }

    public List<Question> getQuestionsByTag(Tag tag) throws NoQuestionFoundException {
        List<Question> questions = questionByTagMap.get(tag);
        if (questions.isEmpty())
            throw new NoQuestionFoundException(ApplicationConstants.NO_QUESTION_FOUND + tag.toString());
        return questions;
    }

    public Question getQuestionsById(int id) throws NoQuestionFoundException {
        Question question = questionById.get(id);
        if (Objects.isNull(question))
            throw new NoQuestionFoundException(ApplicationConstants.NO_QUESTION_FOUND + id);
        return question;
    }

    public Boolean addQuestion(Question question, Member member){
        List<Question> questions = userQuestionMap.getOrDefault(member, new ArrayList<>());
        questions.add(question);
        userQuestionMap.put(member, questions);
        questionById.put(question.getId(), question);
        questionsByTitle.put(question.getTitle(), questions);
        return true;
    }

}
