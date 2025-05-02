package com.yanshedui.backendcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

import static com.yanshedui.backendcommon.results.ResultMessage.*;

@TableName("player_profile")
public class PlayerProfile {

    @TableId(type = IdType.AUTO)
    private Integer profileId;

    private Integer userId;

    @NotBlank(message = RealNameEmpty)
    private String realName;

    @Min(value = 0, message = JerseyNumberBeNegative)
    private Integer jerseyNumber;

    @Pattern(
            regexp = "^(forward|guard|center)$",
            message = PositionSelectionIncorrect
    )
    private String position;

    @Digits(integer = 1, fraction = 2, message = HeightFormatIncorrect)
    private Float height;

    @Digits(integer = 3, fraction = 2, message = WeightFormatIncorrect)
    private Float weight;

    @NotNull(message = JoinDateEmpty)
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
