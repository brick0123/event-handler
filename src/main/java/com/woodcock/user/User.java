package com.woodcock.user;

import lombok.Getter;

@Getter
public class User {

    private Long id;
    private String email;

    public User(final String email) {
        this.email = email;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
