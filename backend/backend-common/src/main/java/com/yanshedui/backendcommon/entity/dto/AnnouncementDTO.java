package com.yanshedui.backendcommon.entity.dto;

public class AnnouncementDTO {

    private Integer announceId;
    private String title;
    private String content;

    public AnnouncementDTO() {
    }

    public AnnouncementDTO(Integer announceId, String title, String content) {
        this.announceId = announceId;
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return "AnnouncementDTO{" +
                "announceId=" + announceId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
