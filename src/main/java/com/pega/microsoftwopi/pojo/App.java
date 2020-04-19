package com.pega.microsoftwopi.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;


public class App implements Serializable
{
    @JacksonXmlProperty(localName = "staticResourceOrigin", isAttribute = true)
    private String staticResourceOrigin;

    @JacksonXmlProperty(localName = "applicationBaseUrl", isAttribute = true)
    private String applicationBaseUrl;

    @JacksonXmlProperty(localName = "bootstrapperUrl", isAttribute = true)
    private String bootstrapperUrl;

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;

    @JacksonXmlElementWrapper(localName = "action", useWrapping = false)
    private Action[] action;

    @JacksonXmlProperty(localName = "favIconUrl", isAttribute = true)
    private String favIconUrl;

    @JacksonXmlProperty(localName = "checkLicense", isAttribute = true)
    private String checkLicense;


    public String getStaticResourceOrigin ()
    {
        return staticResourceOrigin;
    }

    public void setStaticResourceOrigin (String staticResourceOrigin)
    {
        this.staticResourceOrigin = staticResourceOrigin;
    }

    public String getApplicationBaseUrl ()
    {
        return applicationBaseUrl;
    }

    public void setApplicationBaseUrl (String applicationBaseUrl)
    {
        this.applicationBaseUrl = applicationBaseUrl;
    }

    public String getBootstrapperUrl ()
    {
        return bootstrapperUrl;
    }

    public void setBootstrapperUrl (String bootstrapperUrl)
    {
        this.bootstrapperUrl = bootstrapperUrl;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Action[] getAction ()
    {
        return action;
    }

    public void setAction (Action[] action)
    {
        this.action = action;
    }

    public String getFavIconUrl ()
    {
        return favIconUrl;
    }

    public void setFavIconUrl (String favIconUrl)
    {
        this.favIconUrl = favIconUrl;
    }

    public String getCheckLicense ()
    {
        return checkLicense;
    }

    public void setCheckLicense (String checkLicense)
    {
        this.checkLicense = checkLicense;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [staticResourceOrigin = "+staticResourceOrigin+", applicationBaseUrl = "+applicationBaseUrl+", bootstrapperUrl = "+bootstrapperUrl+", name = "+name+", action = "+action+", favIconUrl = "+favIconUrl+", checkLicense = "+checkLicense+"]";
    }
}

