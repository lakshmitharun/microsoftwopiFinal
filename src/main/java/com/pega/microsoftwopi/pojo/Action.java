package com.pega.microsoftwopi.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;


public class Action implements Serializable {

    @JacksonXmlProperty(localName = "ext", isAttribute = true)
    private String ext;

    @JacksonXmlProperty(localName = "default", isAttribute = true)
    private String defaultProp;

    @JacksonXmlProperty(localName = "requires", isAttribute = true)
    private String requires;

    @JacksonXmlProperty(localName = "urlsrc", isAttribute = true)
    private String urlsrc;

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getDefaultProp() {
        return defaultProp;
    }

    public void setDefaultProp(String defaultProp) {
        this.defaultProp = defaultProp;
    }

    public String getUrlsrc() {
        return urlsrc;
    }

    public void setUrlsrc(String urlsrc) {
        this.urlsrc = urlsrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequires() {
        return requires;
    }

    public void setRequires(String requires) {
        this.requires = requires;
    }

    @Override
    public String toString() {
        return "ClassPojo [ext = " + ext + ", default = " + defaultProp + ", urlsrc = " + urlsrc + ", name = " + name + "]";
    }
}
