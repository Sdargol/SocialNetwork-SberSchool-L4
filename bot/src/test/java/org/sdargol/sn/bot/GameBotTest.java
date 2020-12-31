package org.sdargol.sn.bot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sdargol.api.message.Message;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class GameBotTest {

    @Test
    void say() {
        String result = "\u001B[32m[GAME BOT]: Вы угадали.  Я загадал число в интервале от 1 до 6 что это за число ?\u001B[0m";
        Random randomMock = Mockito.mock(Random.class);
        Message message = Mockito.mock(Message.class);

        Mockito.when(randomMock.nextInt(6)).thenReturn(1);

        GameBot gameBot = new GameBot(randomMock, 6);

        Mockito.when(message.getBody()).thenReturn("2");

        assertEquals(result, gameBot.say(message));
    }
}