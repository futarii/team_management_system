package com.yanshedui.backendcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@TableName("player_profile")
public class PlayerProfile {

    @TableId(type = IdType.AUTO)
    private Integer profileId;

    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    @NotBlank(message = "真实姓名不能为空")
    private String realName;

    @Min(value = 0, message = "球衣号必须为正数或0")
    private Integer jerseyNumber;

    @Pattern(
            regexp = "^(forward|guard|center)$",
            message = "球场位置必须是 forward、guard 或 center 之一"
    )
    private String position;

    @Digits(integer = 1, fraction = 2, message = "身高格式不正确")
    private Float height;

    @Digits(integer = 3, fraction = 2, message = "体重格式不正确")
    private Float weight;

    @NotNull(message = "入队日期不能为空")
    private LocalDate joinDate;

    public PlayerProfile() {
    }

    public PlayerProfile(Integer profileId, Integer userId, String realName, Integer jerseyNumber, String position, Float height, Float weight, LocalDate joinDate) {
        this.profileId = profileId;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "Player{" +
                "profileId=" + profileId +
                ", userId=" + userId +
                ", realName='" + realName + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", position='" + position + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", joinDate=" + joinDate +
                '}';
    }
}
