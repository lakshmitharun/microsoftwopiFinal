package com.pega.microsoftwopi.constants;

public class WOPIConstants {
    public static final String DISCOVERY_XML_OBJECT = "DISCOVERY_XML_OBJECT";
    public static final String DISCOVERY_XML_MAP = "DISCOVERY_XML_MAP";

    public static final String EXCEPTION_WOPIDISCOVERYXML_GETDISCOVERYXML = "Exception in Class:WOPIDiscoveryXML Method:getDiscoveryXML Exception: ";
    public static final String EXCEPTION_WOPIDISCOVERYXML_PROCESSACTIONS = "Exception in Class:WOPIDiscoveryXML Method:processActions Exception: ";
    public static final String EXCEPTION_WOPIDISCOVERYXML_GETESSENTIALMAPFROMXMLOBJECT = "Exception in Class:WOPIDiscoveryXML Method:getEssentialMapFromXMLObject Exception: ";
    public static final String EXCEPTION_APPLICATIONSTARTER_ADDDISCOVERYMAPTOSERVLETCONTEXT = "Exception in Class:ApplicationStarter Method:addDiscoveryMapToServletContext Exception: ";
    public static final String EXCEPTION_MICROSOFTWOPIAPPLICATION_MAIN = "Exception in Class:MicrosoftwopiApplication Method:main Exception: ";
    public static final String EXCEPTION_WOPISERVICE_FILECONTENT = "Exception in Class:WOPIService Method:getFileContent Exception: ";
    public static final String EXCEPTION_WOPISERVICE_POSTFILE = "Exception in Class:WOPIService Method:postFile Exception: ";

    public static final String INFO_WOPIDISCOVERYXML_GETDISCOVERYXML = "WOPIDiscovery Object: ";
    public static final String INFO_WOPIDISCOVERYXML_PROCESSACTIONS = "ActionMap Object: ";
    public static final String INFO_WOPIDISCOVERYXML_GETESSENTIALMAPFROMXMLOBJECT = "Discovery Map: " ;
    public static final String INFO_WOPISERVICE_GETFILEINFO= "getFileInfo name :  " ;
    public static final String INFO_WOPISERVICE_GETFILEINFO_EXCEPTION= "getFileInfo exception :  " ;
    public static final String INFO_WOPISERVICE_FILECONTENT_NAME= "getFileContent name :  " ;
    public static final String INFO_WOPISERVICE_FILECONTENT_FILECONTENT= "getFileContent filecontent :  " ;
    public static final String INFO_WOPISERVICE_GETFILEINFO_CHECKFILEINFO= "getFileInfo checkfileinfo :  " ;
    public static final String INFO_WOPISERVICE_PUTFILE_NAME = "postFile name :  ";
    public static final String INFO_WOPISERVICE_PUTFILE_RECEIVEDBYTES = "postFile received bytes length:  ";
    public static final String INFO_WOPISERVICE_PUTFILE_PUTFILECONTENTREQ = "postFile PutFileContentReq:  ";
    public static final String INFO_WOPISERVICE_PUTFILE_PUTFILECONTENTREs = "postFile PutFileContentRes:  ";

    public static final String AUTHORIZATION = "Authorization" ;
    public static final String BASIC = "Basic " ;
    public static final String RESPONSE_STATUS = "Response Status  {} " ;
    public static final String REQUEST_DETAILS = "Request details: {} {}" ;
    public static final String HEADERS_LOG = "Name : {} , value : {}" ;
    public static final String ATTACHMENT_FILENAME = "attachment;filename=" ;



    public static final String REST_END_POINT_GET_FILE_INFO = "/files/{name}";
    public static final String REST_END_POINT_GET_FILE_CONTENT = "/files/{name}/contents";
    public static final String REST_END_POINT_PEGA_CHECK_FILE_INFO = "/checkFileInfo";
    public static final String REST_END_POINT_PEGA_FILE_CONTENT = "/fileContent";
    public static final String REST_END_POINT_PEGA_UPDATE_FILE_CONTENT = "/updateAttachment";
    public static final String REST_END_POINT_PUT_UPDATED_FILE = "/files/{name}/contents";


    public static final String API_FILE_METADATA = "Get file meta data";
    public static final String API_FILE_CHECKFILEINFO = "Successfully retrieved CheckFileInfo Response";
    public static final String API_FILE_OCTETSTREAM = "Get file OctetStream";
    public static final String API_FILE_UPDATE_CONTENT = "Receive updated file from Office 365 and upload it to Pega PRPC";
    public static final String API_FILE_DOWNLOADED = "Successfully downloaded file";
    public static final String API_FILE_UPLOADED = "Successfully uploaded file";






}
