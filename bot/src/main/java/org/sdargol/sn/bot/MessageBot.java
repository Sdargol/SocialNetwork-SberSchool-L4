package org.sdargol.sn.bot;

import org.sdargol.api.bot.IBot;
import org.sdargol.api.message.IMessage;

import java.util.Map;
import java.util.Set;

public class MessageBot implements IBot {
    Map<String, String> answers;

    private static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";

    public MessageBot(StorageAnswers sa) {
        answers = sa.getAnswersMap();
    }

    @Override
    public String say(IMessage message) {
        Set<String> answersKey = answers.keySet();
        StringBuilder answer = new StringBuilder();

        for (String a : answersKey) {
            if (message.getBody().contains(a)) {
                answer.append(answers.get(a)).append(" ");
            }
        }

        if (answer.length() == 0) {
            return BLUE + "[MESSAGE BOT]: Надо подумать..." + RESET; //"\u001B[35m"
        }

        return BLUE + "[MESSAGE BOT]: " + answer.toString() + RESET;
    }
}
