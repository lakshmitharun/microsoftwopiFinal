package com.pega.microsoftwopi.pojo.wopi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckFileInfo {

    @JsonProperty("BaseFileName")
    private String baseFileName;


    @JsonProperty("OwnerId")
    private String ownerId;

    @JsonProperty("UserId")
    private String UserId;

    @JsonProperty("Size")
    private long size;


    @JsonProperty("SHA256")
    private String sha256;


    @JsonProperty("Version")
    private long version;

    @JsonProperty("BreadcrumbFolderName")
    private String breadcrumbFolderName;

    @JsonProperty("BreadcrumbBrandName")
    private String breadcrumbBrandName;

    @JsonProperty("AllowExternalMarketplace")
    private boolean allowExternalMarketplace = true;


    @JsonProperty("UserCanWrite")
    private boolean userCanWrite = true;


    @JsonProperty("SupportsUpdate")
    private boolean supportsUpdate = false;


    @JsonProperty("SupportsLocks")
    private boolean supportsLocks = false;

    @JsonProperty("UserFriendlyName")
    private String userFriendlyName;


    public String getBaseFileName() {
        return baseFileName;
    }

    public void setBaseFileName(String baseFileName) {
        this.baseFileName = baseFileName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public boolean isAllowExternalMarketplace() {
        return allowExternalMarketplace;
    }

    public void setAllowExternalMarketplace(boolean allowExternalMarketplace) {
        this.allowExternalMarketplace = allowExternalMarketplace;
    }

    public boolean isUserCanWrite() {
        return userCanWrite;
    }

    public void setUserCanWrite(boolean userCanWrite) {
        this.userCanWrite = userCanWrite;
    }

    public boolean isSupportsUpdate() {
        return supportsUpdate;
    }

    public void setSupportsUpdate(boolean supportsUpdate) {
        this.supportsUpdate = supportsUpdate;
    }

    public boolean isSupportsLocks() {
        return supportsLocks;
    }

    public void setSupportsLocks(boolean supportsLocks) {
        this.supportsLocks = supportsLocks;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getBreadcrumbFolderName() {
        return breadcrumbFolderName;
    }

    public void setBreadcrumbFolderName(String breadcrumbFolderName) {
        this.breadcrumbFolderName = breadcrumbFolderName;
    }

    public String getBreadcrumbBrandName() {
        return breadcrumbBrandName;
    }

    public void setBreadcrumbBrandName(String breadcrumbBrandName) {
        this.breadcrumbBrandName = breadcrumbBrandName;
    }

    public String getUserFriendlyName() {
        return userFriendlyName;
    }

    public void setUserFriendlyName(String userFriendlyName) {
        this.userFriendlyName = userFriendlyName;
    }

    @Override
    public String toString() {
        return "CheckFileInfo{" +
                "baseFileName='" + baseFileName + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", UserId='" + UserId + '\'' +
                ", size=" + size +
                ", sha256='" + sha256 + '\'' +
                ", version=" + version +
                ", breadcrumbFolderName='" + breadcrumbFolderName + '\'' +
                ", breadcrumbBrandName='" + breadcrumbBrandName + '\'' +
                ", allowExternalMarketplace=" + allowExternalMarketplace +
                ", userCanWrite=" + userCanWrite +
                ", supportsUpdate=" + supportsUpdate +
                ", supportsLocks=" + supportsLocks +
                ", userFriendlyName='" + userFriendlyName + '\'' +
                '}';
    }
}

