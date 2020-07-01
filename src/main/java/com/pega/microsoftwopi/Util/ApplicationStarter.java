package com.pega.microsoftwopi.Util;

import com.pega.microsoftwopi.WOPIXML.WOPIDiscoveryXML;
import com.pega.microsoftwopi.constants.WOPIConstants;
import com.pega.microsoftwopi.pegaconnector.PegaClient;
import com.pega.microsoftwopi.pojo.CheckFileInfo;
import com.pega.microsoftwopi.pojo.CheckFileInfoReq;
import com.pega.microsoftwopi.pojo.WOPIDiscovery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

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

            //test code
            PegaClient bean = BeanUtil.getBean(PegaClient.class);
            String basicAuthHeader =  WOPIConstants.BASIC + Base64Utils.encodeToString(("ponnl" + ":" + "rules").getBytes());
            CheckFileInfo checkFileInfo = bean.getCheckFileInfo("https://lab5367.lab.pega.com/prweb/api/wopi/1", basicAuthHeader, new CheckFileInfoReq("DATA-WORKATTACH-FILE OQW5SI-PERFTEST-WORK C-314!20200419T194330.312 GMT"));
            LOGGER.error(checkFileInfo.toString());
        } catch (Exception e) {
            LOGGER.error(WOPIConstants.EXCEPTION_APPLICATIONSTARTER_ADDDISCOVERYMAPTOSERVLETCONTEXT + e);
        }
    }
}
