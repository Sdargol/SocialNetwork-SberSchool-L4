package org.sdargol.sn.client;

import org.sdargol.api.message.IMessage;
import org.sdargol.api.server.IServer;

public class Client {

    public void render(IServer server){
        System.out.println(server.response());
    }

    public void sendMessage(IServer server, IMessage message){
        server.send(message);
    }
}
