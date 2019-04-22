package com.xuyang.springcloud.server_file.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/4/21 02:08
 * @Description:
 */
@Data
@Slf4j
@ToString
public class Files implements Serializable {

    private static final long serialVersionUID = 2893220513676677948L;

    @JsonProperty(value = "fileID")
    private String fileID;

    @JsonProperty(value = "userID")
    private String userID;

    @JsonProperty(value = "fileName")
    private String fileName;

    @JsonProperty(value = "filePath")
    private String filePath;

    @JsonProperty(value = "fileDesc")
    private String fileDesc;

    @JsonProperty(value = "fileContext")
    private String fileContext;

    @JsonProperty(value = "fileType")
    private String fileType;

    @JsonProperty(value = "fileUpdateTime")
    private String fileUpdateTime;

    public String getFileID() {
        return fileID;
    }

    public void setFileID(String fileID) {
        this.fileID = fileID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileDesc() {
        return fileDesc;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUpdateTime() {
        return fileUpdateTime;
    }

    public void setFileUpdateTime(String fileUpdateTime) {
        this.fileUpdateTime = fileUpdateTime;
    }

    public String getFileContext() {
        return fileContext;
    }

    public void setFileContext(String fileContext) {
        this.fileContext = fileContext;
    }
}
