package com.pega.microsoftwopi.pojo.prpc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilecontentRes {

    @JsonProperty("fileContent")
    private String fileContent;

    @JsonProperty("BaseFileName")
    private String baseFileName;

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getBaseFileName() {
        return baseFileName;
    }

    public void setBaseFileName(String baseFileName) {
        this.baseFileName = baseFileName;
    }

    @Override
    public String toString() {
        return "FilecontentRes{" +
                "fileContent='" + fileContent + '\'' +
                ", baseFileName='" + baseFileName + '\'' +
                '}';
    }
}
