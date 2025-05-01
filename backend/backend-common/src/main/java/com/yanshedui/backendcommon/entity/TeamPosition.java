package com.yanshedui.backendcommon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@TableName("team_position")
public class TeamPosition {

    @TableId
    private Integer positionId;

    @NotBlank(message = "角色名称不能为空")
    private String positionName;

    @NotBlank(message = "角色代码不能为空")
    @Pattern(regexp = "^[a-z]+$", message = "角色代码必须为小写字母")
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
