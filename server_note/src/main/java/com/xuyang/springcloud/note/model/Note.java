package com.xuyang.springcloud.note.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/4/24 14:47
 * @Description:
 */
@Data
@Slf4j
@ToString
public class Note implements Serializable {

    private static final long serialVersionUID = 4753354632865452755L;

    @JsonProperty(value = "noteId")
    private String noteId;

    @JsonProperty(value = "userId")
    private String userId;

    @JsonProperty(value = "noteName")
    private String noteName;

    @JsonProperty(value = "noteContent")
    private String noteContent;

    @JsonProperty(value = "noteType")
    private String noteType;

    @JsonProperty(value = "noteUrl")
    private String noteUrl;

    @JsonProperty(value = "createNoteUrl")
    private String createNoteUrl;

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public String getNoteUrl() {
        return noteUrl;
    }

    public void setNoteUrl(String noteUrl) {
        this.noteUrl = noteUrl;
    }

    public String getCreateNoteUrl() {
        return createNoteUrl;
    }

    public void setCreateNoteUrl(String createNoteUrl) {
        this.createNoteUrl = createNoteUrl;
    }
}
