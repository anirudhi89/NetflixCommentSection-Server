package com.NetflixCommentSectionServer;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User {

    private Long userID;
    private String firstName;
    private String lastName;
    private String userEmail; //Validate email
    private String userPassword; //Hash password
    // private Date createdDate;
    private String profilePictureURL;

    public User(Long userID, String firstName, String lastName, String userEmail, String userPassword, /*Date createdDate,*/ String profilePictureURL) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        // this.createdDate = createdDate;
        this.profilePictureURL = profilePictureURL;
    }

    private static List<User> users = Arrays.asList(
            new User(null, "Jack", null, null, null, null),
            new User(null, "Sam", null, null, null, null),
            new User(null, "Bob", null, null, null, null)
    );

    public static User getById(Long id) {
        return users.stream().filter(user -> user.getUserId().equals(id)).findFirst().orElse(null);
    }

    public static User getByFirstName(String fName) {
        return users.stream().filter(user -> user.getFirstName().equals(fName)).findFirst().orElse(users.get(0));
    }

    private String getFirstName() {
        return firstName;
    }

    public Long getUserId() {
        return this.userID;
    }
}
