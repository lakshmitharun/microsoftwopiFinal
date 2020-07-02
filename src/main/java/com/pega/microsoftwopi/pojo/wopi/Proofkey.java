package com.pega.microsoftwopi.pojo.wopi;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;


public class Proofkey implements Serializable {

    @JacksonXmlProperty(localName = "oldmodulus", isAttribute = true)
    private String oldmodulus;

    @JacksonXmlProperty(localName = "oldexponent", isAttribute = true)
    private String oldexponent;

    @JacksonXmlProperty(localName = "value", isAttribute = true)
    private String value;

    @JacksonXmlProperty(localName = "oldvalue", isAttribute = true)
    private String oldvalue;

    @JacksonXmlProperty(localName = "modulus", isAttribute = true)
    private String modulus;

    @JacksonXmlProperty(localName = "exponent", isAttribute = true)
    private String exponent;

    public String getOldmodulus() {
        return oldmodulus;
    }

    public void setOldmodulus(String oldmodulus) {
        this.oldmodulus = oldmodulus;
    }

    public String getOldexponent() {
        return oldexponent;
    }

    public void setOldexponent(String oldexponent) {
        this.oldexponent = oldexponent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        return "ClassPojo [oldmodulus = " + oldmodulus + ", oldexponent = " + oldexponent + ", value = " + value + ", oldvalue = " + oldvalue + ", modulus = " + modulus + ", exponent = " + exponent + "]";
    }
}
