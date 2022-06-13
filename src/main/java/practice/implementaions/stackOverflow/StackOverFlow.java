package practice.implementaions.stackOverflow;

import practice.implementaions.stackOverflow.exceptions.MemberAlreadyExists;
import practice.implementaions.stackOverflow.exceptions.MemberNotExists;
import practice.implementaions.stackOverflow.exceptions.NoQuestionFoundException;
import practice.implementaions.stackOverflow.exceptions.QuestionCreationException;
import practice.implementaions.stackOverflow.services.ClientFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class StackOverFlow {

    private static ClientFactory clientFactory;

    public static void main(String[] args) throws NoQuestionFoundException, QuestionCreationException, MemberNotExists, MemberAlreadyExists {
        try {
            clientFactory = new ClientFactory();
            List<String> commands = Files.readAllLines(new File("/Users/manmeetkaur/IdeaProjects/Sample/src/main/java/practice/implementaions/stackOverflow/commands.txt").toPath(), Charset.defaultCharset());
            if(!commands.isEmpty()) clientFactory.processCommands(commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
