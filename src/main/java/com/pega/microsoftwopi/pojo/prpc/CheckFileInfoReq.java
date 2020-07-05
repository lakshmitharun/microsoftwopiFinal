package com.pega.microsoftwopi.pojo.prpc;

@SuppressWarnings("SpellCheckingInspection")
public class CheckFileInfoReq {

    private String inskey;

    public CheckFileInfoReq(String inskey) {
        this.inskey = inskey;
    }

    public String getInskey() {
        return inskey;
    }

    public void setInskey(String inskey) {
        this.inskey = inskey;
    }

    @Override
    public String toString() {
        return "CheckFileInfoReq{" +
                "inskey='" + inskey + '\'' +
                '}';
    }
}
