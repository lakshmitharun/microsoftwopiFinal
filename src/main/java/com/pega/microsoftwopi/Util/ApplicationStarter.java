package com.pega.microsoftwopi.Util;

import com.pega.microsoftwopi.WOPIXML.WOPIDiscoveryXML;
import com.pega.microsoftwopi.constants.WOPIConstants;
import com.pega.microsoftwopi.pojo.WOPIDiscovery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.util.Map;

public class ApplicationStarter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStarter.class);

    public static void addDiscoveryMapToServletContext() {
        try {
            WOPIDiscoveryXML wopiDiscoveryXML = BeanUtil.getBean(WOPIDiscoveryXML.class);
            WOPIDiscovery discoveryXML = wopiDiscoveryXML.getDiscoveryXML();
            ServletContext servletContext = BeanUtil.getBean(ServletContext.class);
            servletContext.setAttribute(WOPIConstants.DISCOVERY_XML_OBJECT, discoveryXML);
            Map<String, Map> essentialMapFromXMLObject = wopiDiscoveryXML.getEssentialMapFromXMLObject(discoveryXML);
            servletContext.setAttribute(WOPIConstants.DISCOVERY_XML_MAP, essentialMapFromXMLObject);

        } catch (Exception e) {
            LOGGER.error(WOPIConstants.EXCEPTION_APPLICATIONSTARTER_ADDDISCOVERYMAPTOSERVLETCONTEXT + e);
        }
    }
}
