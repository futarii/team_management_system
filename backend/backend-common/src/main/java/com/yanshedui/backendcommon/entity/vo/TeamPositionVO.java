package com.yanshedui.backendcommon.entity.vo;

public class TeamPositionVO {

    private Integer positionId;

    private String positionName;

    public TeamPositionVO() {
    }

    public TeamPositionVO(Integer positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
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

    @Override
    public String toString() {
        return "TeamPosition{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                '}';
    }

}
