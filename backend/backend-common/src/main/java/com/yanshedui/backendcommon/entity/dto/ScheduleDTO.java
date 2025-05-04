package com.yanshedui.backendcommon.entity.dto;
import java.time.LocalDateTime;

public class ScheduleDTO {

    private Integer scheduleId;
    private String matchName;
    private LocalDateTime matchTime;
    private String location;
    private String opponent;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Integer scheduleId, String matchName, LocalDateTime matchTime, String location, String opponent) {
        this.scheduleId = scheduleId;
        this.matchName = matchName;
        this.matchTime = matchTime;
        this.location = location;
        this.opponent = opponent;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public LocalDateTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalDateTime matchTime) {
        this.matchTime = matchTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "scheduleId=" + scheduleId +
                ", matchName='" + matchName + '\'' +
                ", matchTime=" + matchTime +
                ", location='" + location + '\'' +
                ", opponent='" + opponent + '\'' +
                '}';
    }
}
