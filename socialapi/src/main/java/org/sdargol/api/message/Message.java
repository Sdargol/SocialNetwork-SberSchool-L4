package org.sdargol.api.message;

public class Message implements IMessage {
    private String header;
    private String body;

    public Message() {
        header = "test";
        body = "test";
    }

    @Override
    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public String getBody() {
        return body;
    }
}
