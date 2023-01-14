package com.driver.models;

public class User{

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany( mappedby = "blog", cascade = CascadeType.ALL )
    private List<Blog> blogs;
}