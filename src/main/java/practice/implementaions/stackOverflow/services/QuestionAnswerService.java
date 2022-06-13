package practice.implementaions.stackOverflow.services;

import practice.implementaions.stackOverflow.Constants.ApplicationConstants;
import practice.implementaions.stackOverflow.enums.QuestionStatus;
import practice.implementaions.stackOverflow.exceptions.MemberNotExists;
import practice.implementaions.stackOverflow.exceptions.NoQuestionFoundException;
import practice.implementaions.stackOverflow.exceptions.QuestionCreationException;
import practice.implementaions.stackOverflow.models.Answer;
import practice.implementaions.stackOverflow.models.Member;
import practice.implementaions.stackOverflow.models.Question;
import practice.implementaions.stackOverflow.models.Tag;
import practice.implementaions.stackOverflow.repository.AnswersRepo;
import practice.implementaions.stackOverflow.repository.MembersRepo;
import practice.implementaions.stackOverflow.repository.QuestionRepo;

import java.sql.Timestamp;
import java.util.List;

public class QuestionAnswerService {

    private final QuestionRepo questionRepo;
    private final AnswersRepo answersRepo;
    private final MembersRepo membersRepo;

    private static int questionId = 1;
    private static int answwerId = 1;
    private static int tagId = 1;

    public QuestionAnswerService() {
        questionRepo = new QuestionRepo();
        answersRepo = new AnswersRepo();
        membersRepo = new MembersRepo();
    }

    public Tag createTag(String title) {
        return new Tag(tagId++, title);
    }

    public Question createAndPostQuestion(String title, String description, Tag tag, int askedBy) throws QuestionCreationException, MemberNotExists {
        if (membersRepo.isMember(askedBy)) {
            Member member = membersRepo.getMemberById(askedBy);
            Question question = new Question(questionId++, title, QuestionStatus.CREATED, tag, description, 0,
                    new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), member);
            if (postQuestion(question, member)) return question;
            else throw new QuestionCreationException(ApplicationConstants.QUESTION_CREATION_FAILED);
        } else throw new MemberNotExists(ApplicationConstants.MEMBER_NOT_EXISTS);
    }

    private boolean postQuestion(Question question, Member askedBy) {
        return questionRepo.addQuestion(question, askedBy);
    }

    public boolean createAndPostAnswer(String answerTitle, String answerDescription, int postedBy, Question question) throws QuestionCreationException, MemberNotExists {
        if (membersRepo.isMember(postedBy)) {
            Member member = membersRepo.getMemberById(postedBy);
            Answer answer = new Answer(answwerId++, answerTitle, answerDescription, 0,
                    new Timestamp(System.currentTimeMillis()), question, member);
            if (postAnswer(answer, member, question)) return true;
            else throw new QuestionCreationException(ApplicationConstants.QUESTION_CREATION_FAILED);
        } else throw new MemberNotExists(ApplicationConstants.MEMBER_NOT_EXISTS);
    }

    private boolean postAnswer(Answer answer, Member postedBy, Question question) {
        return answersRepo.addAnswer(question, answer);
    }

    public Question getQuestionById(int id) throws NoQuestionFoundException {
        return questionRepo.getQuestionsById(id);
    }

    public List<Question> questionByTitle(String title) throws NoQuestionFoundException {
        return questionRepo.getQuestionsByTitle(title);
    }
}
