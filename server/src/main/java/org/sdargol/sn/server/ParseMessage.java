package org.sdargol.sn.server;

import org.sdargol.api.message.IMessage;
import org.sdargol.api.service.IService;
import org.sdargol.api.service.post.APost;
import org.sdargol.sn.posts.PostManager;

import java.util.ArrayList;

public class ParseMessage {
    private final BotManager botManager;
    private final IService<APost> postManager;

    public ParseMessage() {
        botManager = new BotManager();
        botManager.addMessageBot("Weather", "/weather.json");

        postManager = new PostManager();
    }

    public String getResponse(IMessage message) {

        if (message.getHeader().contains("MessageBot")) {
            return getMessageBot(message);
        }

        if (message.getHeader().contains("AddPost")) {
            addPost(message);
            return "Пост добавлен!";
        }

        switch (message.getHeader()) {
            case "GameBot":
                return botManager.getGameBot().say(message);

            case "GetAllPosts":
                return getPosts();

            case "GetPost":
                return getPost(message);

            default:
                return "Неизвестная команда.";
        }
    }

    private String getMessageBot(IMessage message) {
        String[] argHeader = message.getHeader().split("\\s");

        if (argHeader.length > 1) {
            String nameBot = argHeader[1];
            return botManager.getMessageBot(nameBot).say(message);
        }

        return botManager.getMessageBot("default").say(message);
    }

    private String getPosts() {
        ArrayList<APost> posts = postManager.getAll();
        StringBuilder result = new StringBuilder();

        for (APost p : posts) {
            result.append(p);
        }

        return result.toString();
    }

    private String getPost(IMessage message) {
        ArrayList<APost> posts;
        StringBuilder result = new StringBuilder();

        posts = postManager.getById(Integer.parseInt(message.getBody()));

        for (APost p : posts) {
            result.append(p);
        }

        return result.toString();
    }

    private void addPost(IMessage message) {
        String[] argHeader = message.getHeader().split("\\s");
        int userId;

        if (argHeader.length > 1) {
            userId = Integer.parseInt(argHeader[1]);
            postManager.add(userId, message.getBody());
        }
    }
}
