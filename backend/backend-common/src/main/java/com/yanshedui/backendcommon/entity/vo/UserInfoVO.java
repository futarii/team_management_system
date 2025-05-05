package com.yanshedui.backendcommon.entity.vo;

import java.time.LocalDate;

public class UserInfoVO {

    private String username;
    private String realName;
    private Integer jerseyNumber;
    private String position;
    private Float height;
    private Float weight;
    private LocalDate joinDate;

    public UserInfoVO() {
    }

    public UserInfoVO(String username, String realName, Integer jerseyNumber, String position, Float height, Float weight, LocalDate joinDate) {
        this.username = username;
        this.realName = realName;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.joinDate = joinDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", position='" + position + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", joinDate=" + joinDate +
                '}';
    }
}
