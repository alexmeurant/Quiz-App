package com.example.android.quizapp.model;


public class User {

    private String mUserName;

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUserName='" + mUserName + '\'' +
                '}';
    }
}
