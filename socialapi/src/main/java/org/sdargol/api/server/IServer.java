package org.sdargol.api.server;

import org.sdargol.api.message.IMessage;

public interface IServer {
    void send(IMessage message);
    String response();
}
