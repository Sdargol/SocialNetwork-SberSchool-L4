package org.sdargol.sn.posts;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostManagerTest {

    @Test
    void getById() {
        //в тестовой бд должна быть запись с id = 8 (SERIAL), userId = 0, content = "Пост из Java"
        List<Post> expPost = new ArrayList<>(Collections.singletonList(new Post(8, 0, "Пост из Java")));
        PostManager postManager = new PostManager();

        assertEquals(expPost.get(0).toString(), postManager.getById(0).get(0).toString());
    }
}