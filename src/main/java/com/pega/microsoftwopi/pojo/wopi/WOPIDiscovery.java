package com.pega.microsoftwopi.pojo.wopi;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;


@JacksonXmlRootElement(localName = "wopi-discovery")
public class WOPIDiscovery implements Serializable {

    @JacksonXmlProperty(localName = "net-zone")
    private Netzone netzone;

    @JacksonXmlProperty(localName = "proof-key")
    private Proofkey proofkey;

    public Netzone getNetzone() {
        return netzone;
    }

    public void setNetzone(Netzone netzone) {
        this.netzone = netzone;
    }

    public Proofkey getProofkey() {
        return proofkey;
    }

    public void setProofkey(Proofkey proofkey) {
        this.proofkey = proofkey;
    }

    @Override
    public String toString() {
        return "ClassPojo [net-zone = " + netzone + ", proof-key = " + proofkey + "]";
    }
}
