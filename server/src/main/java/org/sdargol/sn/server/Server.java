package org.sdargol.sn.server;

import org.sdargol.api.message.IMessage;
import org.sdargol.api.server.IServer;

public class Server implements IServer {
    private IMessage message;

    private final ParseMessage parseMessage;

    public Server() {
        parseMessage = new ParseMessage();
    }

    @Override
    public void send(IMessage message) {
        this.message = message;
    }

    @Override
    public String response() {
        return parseMessage.getResponse(message);
    }
}