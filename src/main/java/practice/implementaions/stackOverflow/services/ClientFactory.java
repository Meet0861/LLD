package practice.implementaions.stackOverflow.services;

import practice.implementaions.stackOverflow.apis.GuestActivities;
import practice.implementaions.stackOverflow.apis.MemberActivities;
import practice.implementaions.stackOverflow.apis.Search;
import practice.implementaions.stackOverflow.apis.impl.GuestActivitiesImpl;
import practice.implementaions.stackOverflow.apis.impl.MemberActivitiesImpl;
import practice.implementaions.stackOverflow.apis.impl.SearchImpl;
import practice.implementaions.stackOverflow.enums.Command;
import practice.implementaions.stackOverflow.exceptions.MemberAlreadyExists;
import practice.implementaions.stackOverflow.exceptions.MemberNotExists;
import practice.implementaions.stackOverflow.exceptions.NoQuestionFoundException;
import practice.implementaions.stackOverflow.exceptions.QuestionCreationException;

import java.util.Arrays;
import java.util.List;

public class ClientFactory {

    private final MemberActivities memberActivities = new MemberActivitiesImpl();
    private final GuestActivities guestActivities = new GuestActivitiesImpl();
    private final Search search = new SearchImpl();

    public void processCommands(List<String> commands) throws MemberAlreadyExists, QuestionCreationException, MemberNotExists, NoQuestionFoundException {
        for(String command : commands){
            List<String> values = Arrays.asList(command.split(" "));
            Command com = Command.valueOf(values.get(0));
            switch(com){
                case CREATE_MEMBER:
                    guestActivities.signup(values.get(1), values.get(2), values.get(3) , values.get(4));
                    break;
                case POST_QUESTION:
                    memberActivities.postQuestion(values.get(1), values.get(2), values.get(3) , Integer.parseInt(values.get(4)));
                    break;
                case POST_ANSWER:
                    memberActivities.postAnswerToQuestion(Integer.parseInt(values.get(1)), values.get(2), values.get(3) , Integer.parseInt(values.get(4)));
                    break;
                case POST_COMMENT_TO_QUESTION:
                    break;
                case POST_COMMENT_TO_ANSWER:
                    break;
                case GET_QUESTIONS:
                    search.searchByQuestionTitle(values.get(1), Integer.parseInt(values.get(2)));
                    break;
            }
        }

    }
}
