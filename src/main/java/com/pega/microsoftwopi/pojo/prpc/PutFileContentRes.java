package com.pega.microsoftwopi.pojo.prpc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PutFileContentRes {

    @JsonProperty("isSuccessful")
    private boolean isSuccessful;

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    @Override
    public String toString() {
        return "PutFileContentRes{" +
                "isSuccessful=" + isSuccessful +
                '}';
    }
}
