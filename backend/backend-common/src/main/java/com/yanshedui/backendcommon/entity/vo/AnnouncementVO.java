package com.yanshedui.backendcommon.entity.vo;

import java.time.LocalDateTime;

public class AnnouncementVO {

    private Integer announceId;

    private String title;

    private String content;

    private String username;

    private LocalDateTime publishTime;

    private LocalDateTime updateTime;

    public AnnouncementVO() {
    }

    public AnnouncementVO(Integer announceId, String title, String content, String username, LocalDateTime publishTime, LocalDateTime updateTime) {
        this.announceId = announceId;
        this.title = title;
        this.content = content;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "AnnouncementVO{" +
                "announceId=" + announceId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", publishTime=" + publishTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
