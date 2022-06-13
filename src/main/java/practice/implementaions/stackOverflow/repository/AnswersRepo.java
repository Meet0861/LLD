package practice.implementaions.stackOverflow.repository;

import lombok.Getter;
import practice.implementaions.stackOverflow.Constants.ApplicationConstants;
import practice.implementaions.stackOverflow.exceptions.NoQuestionFoundException;
import practice.implementaions.stackOverflow.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class AnswersRepo {
    private static Map<Member, List<Answer>> userAnswerMap;
    private static Map<Question, List<Answer>> answersByQuestionMap;
    private static Map<Answer, List<Comment>> commentsListByAnswer;

    public AnswersRepo() {
        userAnswerMap = new HashMap<>();
        answersByQuestionMap = new HashMap<>();
        commentsListByAnswer = new HashMap<>();
    }

    public List<Answer> getAnswersByQuestion(Question question) {
        return answersByQuestionMap.getOrDefault(question, new ArrayList<>());
    }

    public Boolean addAnswer(Question question, Answer answer){
        List<Answer> answers = answersByQuestionMap.getOrDefault(question, new ArrayList<>());
        answersByQuestionMap.put(question, answers);
        return true;
    }

}
