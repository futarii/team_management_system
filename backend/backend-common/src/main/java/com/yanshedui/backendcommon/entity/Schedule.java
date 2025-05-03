package com.yanshedui.backendcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import static com.yanshedui.backendcommon.results.ResultMessage.*;

@TableName("schedule")
public class Schedule {

    @TableId(type = IdType.AUTO)
    private Integer scheduleId;

    @NotBlank(message = MatchNameEmpty)
    private String matchName;

    @NotNull(message = MatchTimeEmpty)
    private LocalDateTime matchTime;

    @NotBlank(message = MatchLocationEmpty)
    private String location;

    @NotBlank(message = OpponentEmpty)
    private String opponent;

    private Byte status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Schedule() {
    }

    public Schedule(Integer scheduleId, String matchName, LocalDateTime matchTime, String location, String opponent, Byte status, LocalDateTime createTime, LocalDateTime updateTime) {
        this.scheduleId = scheduleId;
        this.matchName = matchName;
        this.matchTime = matchTime;
        this.location = location;
        this.opponent = opponent;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", matchName='" + matchName + '\'' +
                ", matchTime=" + matchTime +
                ", location='" + location + '\'' +
                ", opponent='" + opponent + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
