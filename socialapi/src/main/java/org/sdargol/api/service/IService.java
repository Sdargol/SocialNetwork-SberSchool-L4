package org.sdargol.api.service;

import org.sdargol.api.service.post.APost;

import java.util.ArrayList;

public interface IService<T> {
    ArrayList<T> getAll();
    ArrayList<T> getById(int userId);
    void add(int userId, String content);
}
