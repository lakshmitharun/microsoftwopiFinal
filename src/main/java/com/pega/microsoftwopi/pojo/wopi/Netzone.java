package com.pega.microsoftwopi.pojo.wopi;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;


public class Netzone implements Serializable {

    @JacksonXmlElementWrapper(localName = "app", useWrapping = false)
    private App[] app;

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;

    public App[] getApp() {
        return app;
    }

    public void setApp(App[] app) {
        this.app = app;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassPojo [app = " + app + ", name = " + name + "]";
    }
}
