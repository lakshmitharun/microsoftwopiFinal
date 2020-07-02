package com.pega.microsoftwopi.WOPIXML;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pega.microsoftwopi.constants.WOPIConstants;
import com.pega.microsoftwopi.pojo.wopi.Action;
import com.pega.microsoftwopi.pojo.wopi.App;
import com.pega.microsoftwopi.pojo.wopi.Netzone;
import com.pega.microsoftwopi.pojo.wopi.WOPIDiscovery;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class WOPIDiscoveryXML {

    private static final Logger LOGGER = LoggerFactory.getLogger(WOPIDiscoveryXML.class);

    private final Environment env;

    @Autowired
    public WOPIDiscoveryXML(Environment env) {
        this.env = env;
    }

    public WOPIDiscovery getDiscoveryXML() {
        WOPIDiscovery WOPIDiscovery = null;
        try {
            final String xmlPath = env.getProperty("wopiDiscoveryXMLPath");
            ObjectMapper objectMapper = new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            WOPIDiscovery = objectMapper.readValue(
                    StringUtils.toEncodedString(Files.readAllBytes(Paths.get(Objects.requireNonNull(xmlPath))), StandardCharsets.UTF_8),
                    WOPIDiscovery.class);
            LOGGER.info(WOPIConstants.INFO_WOPIDISCOVERYXML_GETDISCOVERYXML + WOPIDiscovery.toString());
        } catch (Exception e) {
            LOGGER.error(WOPIConstants.EXCEPTION_WOPIDISCOVERYXML_GETDISCOVERYXML + e);
        }
        return WOPIDiscovery;
    }

    public Map<String, Map> getEssentialMapFromXMLObject(WOPIDiscovery wopiDiscovery) {
        Map<String, Map> discoveryMap = null;
        try {
            Netzone netzone = wopiDiscovery.getNetzone();
            discoveryMap = new HashMap<>();
            App[] app = netzone.getApp();
            for (App application : app) {
                Action[] action = application.getAction();
                Map actionMap = processActions(action);
                discoveryMap.put(application.getName(), actionMap);
            }
            LOGGER.info(WOPIConstants.INFO_WOPIDISCOVERYXML_GETESSENTIALMAPFROMXMLOBJECT + discoveryMap);
        } catch (Exception e) {
            LOGGER.error(WOPIConstants.EXCEPTION_WOPIDISCOVERYXML_GETESSENTIALMAPFROMXMLOBJECT + e);
        }
        return discoveryMap;
    }

    private Map processActions(Action[] actions) {
        Map<String, String> actionMap = new HashMap<>();
        try {
            for (Action action : actions) {
                actionMap.put(action.getExt() + "_" + action.getName(), action.getUrlsrc());
            }
            LOGGER.info(WOPIConstants.INFO_WOPIDISCOVERYXML_PROCESSACTIONS + actionMap);
        } catch (Exception e) {
            LOGGER.error(WOPIConstants.EXCEPTION_WOPIDISCOVERYXML_PROCESSACTIONS + e);
        }
        return actionMap;
    }


}
