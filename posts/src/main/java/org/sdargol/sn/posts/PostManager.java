package org.sdargol.sn.posts;

import org.sdargol.api.service.IService;
import org.sdargol.api.service.post.APost;

import java.sql.*;
import java.util.ArrayList;

public class PostManager implements IService<APost> {
    static final String DATABASE_URL = "jdbc:postgresql://localhost/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "sdargol";

    private Connection connection;
    private Statement statement;

    public PostManager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<APost> getAll() {
        ArrayList<APost> posts = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.createStatement();
            String sql = "SELECT * FROM posts";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                posts.add(new Post(resultSet.getInt("id"),
                        resultSet.getInt("userId"),
                        resultSet.getString("content")
                ));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public ArrayList<APost> getById(int userId) {
        ArrayList<APost> posts = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.createStatement();
            String sql = "SELECT * FROM posts WHERE userId = " + userId;

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                posts.add(new Post(resultSet.getInt("id"),
                        resultSet.getInt("userId"),
                        resultSet.getString("content")
                ));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public void add(int userId, String content) {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.createStatement();
            String sql = "INSERT INTO posts(userId, content) VALUES(" + userId + " , '" + content + "')";

            statement.executeUpdate(sql);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
