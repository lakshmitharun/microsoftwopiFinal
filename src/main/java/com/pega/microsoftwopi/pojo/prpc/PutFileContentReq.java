package com.pega.microsoftwopi.pojo.prpc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PutFileContentReq {

    @JsonProperty("inskey")
    private String inskey;

    @JsonProperty("filecontent")
    private String filecontent;

    public PutFileContentReq(String inskey, String filecontent) {
        this.inskey = inskey;
        this.filecontent = filecontent;
    }

    public String getInskey() {
        return inskey;
    }

    public void setInskey(String inskey) {
        this.inskey = inskey;
    }

    public String getFilecontent() {
        return filecontent;
    }

    public void setFilecontent(String filecontent) {
        this.filecontent = filecontent;
    }

    @Override
    public String toString() {
        return "PutFileContentReq{" +
                "inskey='" + inskey + '\'' +
                ", filecontent='" + filecontent + '\'' +
                '}';
    }
}
