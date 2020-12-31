package org.sdargol.api.service.post;

public abstract class APost {
    int id,userId;
    String content;

    public APost(int id,int userId, String content){
        this.id = id;
        this.userId = userId;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post {" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                '}' + "\n";
    }
}
