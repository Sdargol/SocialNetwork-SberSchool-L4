package org.sdargol.sn.bot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sdargol.api.message.IMessage;

import static org.junit.jupiter.api.Assertions.*;

class MessageBotTest {

    @Test
    void say() {
        String result = "\u001B[34m[MESSAGE BOT]: test \u001B[0m";

        StorageAnswers sa = new StorageAnswers("/test.json");
        MessageBot bot = new MessageBot(sa);

        IMessage messageMock = Mockito.mock(IMessage.class);
        Mockito.when(messageMock.getBody()).thenReturn("test");

        assertEquals(result,bot.say(messageMock));
    }
}