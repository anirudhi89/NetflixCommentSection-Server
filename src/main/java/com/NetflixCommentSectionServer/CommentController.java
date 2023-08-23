package com.NetflixCommentSectionServer;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {
    @QueryMapping
    public User getUsers(@Argument String fName) {

        if (User.getByFirstName(fName) != null) {
            System.out.println(User.getByFirstName(fName));
            // return new User(2L, "ERR", "ERR", "err", "err", "err");
            return User.getByFirstName(fName);
        } else {
            return new User(2L, "ERR", "ERR", "err", "err", "err");
        }
    }
    @QueryMapping
    public Comment getComments(@Argument String msg) {
        return Comment.getByMessage(msg);
    }
    @QueryMapping
    public Comment commentByID(@Argument Long id) {
        return Comment.getById(id);
    }
    @SchemaMapping
    public User user(Comment comment) {
        return User.getById(comment.getId());
    }
}
