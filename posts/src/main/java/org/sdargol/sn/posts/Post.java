package org.sdargol.sn.posts;

import org.sdargol.api.service.post.APost;

public class Post extends APost {
    public Post(int id, int userId, String content) {
        super(id, userId, content);
    }
}
