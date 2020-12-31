package org.sdargol.api.message;

public interface IMessage {
    void setHeader(String header);
    void setBody(String body);
    String getHeader();
    String getBody();
}
