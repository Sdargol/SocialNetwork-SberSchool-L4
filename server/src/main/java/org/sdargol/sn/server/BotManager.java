package org.sdargol.sn.server;

import org.sdargol.api.bot.IBot;
import org.sdargol.sn.bot.GameBot;
import org.sdargol.sn.bot.MessageBot;
import org.sdargol.sn.bot.StorageAnswers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BotManager {
    private final Map<String, MessageBot> messageBotMap;
    private final GameBot gameBot;

    public BotManager(){
        messageBotMap = new HashMap<>();
        messageBotMap.put("default", new MessageBot(new StorageAnswers("/answer.json")));
        gameBot = new GameBot(new Random(), 7);
    }

    public void addMessageBot(String nameBot, String pathFileAnswers){
        messageBotMap.put(nameBot, new MessageBot(new StorageAnswers(pathFileAnswers)));
    }

    public IBot getMessageBot(String nameBot){
        if(messageBotMap.containsKey(nameBot)){
            return messageBotMap.get(nameBot);
        }
        return messageBotMap.get("default");
    }

    public IBot getGameBot(){
        return gameBot;
    }
}
