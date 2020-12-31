package org.sdargol.sn.server;

import org.junit.jupiter.api.Test;
import org.sdargol.api.message.IMessage;
import org.sdargol.api.message.Message;

import static org.junit.jupiter.api.Assertions.*;

class ParseMessageTest {

    @Test
    void getResponseDefault() {
        IMessage message = new Message();
        message.setHeader("test");
        message.setBody("test");

        ParseMessage parseMessage = new ParseMessage();

        assertEquals("Неизвестная команда.", parseMessage.getResponse(message));
    }
}