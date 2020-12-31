package org.sdargol.api.bot;

import org.sdargol.api.message.IMessage;

public interface IBot {
    String say(IMessage message);
}
