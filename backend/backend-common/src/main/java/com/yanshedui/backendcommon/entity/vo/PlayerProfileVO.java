package com.yanshedui.backendcommon.entity.vo;

import java.time.LocalDate;

public class PlayerProfileVO {

    private Integer profileId;
    private String realName;
    private Integer jerseyNumber;
    private String position;
    private Float height;
    private Float weight;
    private LocalDate joinDate;

    public PlayerProfileVO() {
    }

    public PlayerProfileVO(Integer profileId, String realName, Integer jerseyNumber, String position, Float height, Float weight, LocalDate joinDate) {
        this.profileId = profileId;
        this.realName = realName;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.joinDate = joinDate;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
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
        return "PlayerVO{" +
                "profileId=" + profileId +
                ", realName='" + realName + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", position='" + position + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", joinDate=" + joinDate +
                '}';
    }
}
