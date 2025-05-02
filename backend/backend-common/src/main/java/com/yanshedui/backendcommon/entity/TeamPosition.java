package com.yanshedui.backendcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import static com.yanshedui.backendcommon.results.ResultMessage.*;

@TableName("team_position")
public class TeamPosition {

    @TableId(type = IdType.AUTO)
    private Integer positionId;

    @NotBlank(message = PositionNameEmpty)
    private String positionName;

    @NotBlank(message = PositionCodeEmpty)
    @Pattern(regexp = "^[a-z]+$", message = PositionCodeLowercaseLetters)
    private String positionCode;

    public TeamPosition() {
    }

    public TeamPosition(Integer positionId, String positionName, String positionCode) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.positionCode = positionCode;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    @Override
    public String toString() {
        return "TeamPosition{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", positionCode='" + positionCode + '\'' +
                '}';
    }

}
