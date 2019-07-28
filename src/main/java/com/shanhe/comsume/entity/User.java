package com.shanhe.comsume.entity;

public class User {

    private String name ;

    private String age ;

    private String userId ;

    public User() {
    }

    public User(String name, String age, String userId) {
        this.name = name;
        this.age = age;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
