package com.yanshedui.backendcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@TableName("announcement")
public class Announcement {

    @TableId(type = IdType.AUTO)
    private Integer announceId;

    @NotBlank(message = "未填写标题")
    private String title;

    @NotBlank(message = "未填写内容")
    private String content;

    private Integer publisherId;
    private LocalDateTime publishTime;
    private LocalDateTime updateTime;

    public Announcement() {
    }

    public Announcement(Integer announceId, String title, String content, Integer publisherId, LocalDateTime publishTime, LocalDateTime updateTime) {
        this.announceId = announceId;
        this.title = title;
        this.content = content;
        this.publisherId = publisherId;
        this.publishTime = publishTime;
        this.updateTime = updateTime;
    }

    public Integer getAnnounceId() {
        return announceId;
    }

    public void setAnnounceId(Integer announceId) {
        this.announceId = announceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announceId=" + announceId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publisherId=" + publisherId +
                ", publishTime=" + publishTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
