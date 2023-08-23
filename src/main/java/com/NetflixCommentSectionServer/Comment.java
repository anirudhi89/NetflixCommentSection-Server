package com.NetflixCommentSectionServer;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Comment {
    private Long id;
    private String userName;
    private Long userID;
    private String message;
    private Date createdDate;
    private Date startTime;
    private Date endTime;

    //Before creating a Comment, the createdDate, StartTime, and EndTime must all be converted to Date objects.
    public Comment(Long id, String userName, Long userID, String message, Date createdDate, Date startTime, Date endTime) {
        this.id = id;
        this.userName = userName;
        this.userID = userID;
        this.message = message;
        this.createdDate = createdDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //Placeholder for DB
    private static List<Comment> comments = Arrays.asList(
        new Comment(1L, "john", 45L, "First comment", new Date(2L), new Date(2L), new Date(2L)),
        new Comment(2L, "george", 48L, "Second comment", new Date(435545678L), new Date(435545678L), new Date(435545678L)),
        new Comment(3L, "thomas", 23L, "Third comment", new Date(2235436547746352453L), new Date(2235436547746352453L), new Date(2235436547746352453L))
    );

    public static Comment getById(Long id) {
        return comments.stream().filter(comment -> comment.getId().equals(id)).findFirst().orElse(null);
    }
    public static Comment getByMessage(String msg) {
        return comments.stream().filter(comment -> comment.getMessage().equals(msg)).findFirst().orElse(comments.get(0));
    }

    public Long getId() {
        return id;
    }
    public Long getUserID() {
        return userID;
    }
    public String getMessage() {
        return message;
    }
}
