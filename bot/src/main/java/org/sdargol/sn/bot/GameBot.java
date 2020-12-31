package org.sdargol.sn.bot;

import org.sdargol.api.bot.IBot;
import org.sdargol.api.message.IMessage;

import java.util.Random;

public class GameBot implements IBot {
    private final Random random;
    private int answer;
    private final int max;

    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";

    public GameBot(Random random, int max){
        this.random = random;
        this.max = max;
        answer = this.random.nextInt(max) + 1;
    }

    @Override
    public String say(IMessage message) {
        String tmpEnd = " Я загадал число в интервале от 1 до " + max + " что это за число ?" ;
        String tmpStart = "[GAME BOT]: Вы не угадали. Правильный ответ: " + answer + ".";

        if(Integer.parseInt(message.getBody()) == answer){
            tmpStart = "[GAME BOT]: Вы угадали. ";
        }

        answer = random.nextInt(max) + 1;

        //return  GREEN + tmpStart + tmpEnd + " ответ " + answer + RESET;
        return  GREEN + tmpStart + tmpEnd + RESET;
    }
}
