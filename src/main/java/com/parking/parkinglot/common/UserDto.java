package com.parking.parkinglot.common;

public class UserDto {
    private long userId;
    private String userName;

    public UserDto(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
}
