package com.pega.microsoftwopi.WOPIController;

import com.pega.microsoftwopi.constants.WOPIConstants;
import com.pega.microsoftwopi.pegaconnector.PegaClient;
import com.pega.microsoftwopi.pojo.prpc.CheckFileInfoReq;
import com.pega.microsoftwopi.pojo.prpc.FilecontentRes;
import com.pega.microsoftwopi.pojo.prpc.PutFileContentReq;
import com.pega.microsoftwopi.pojo.prpc.PutFileContentRes;
import com.pega.microsoftwopi.pojo.wopi.CheckFileInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

@RestController
@Api(value = "WOPI Services", description = "Rest API's exposed to Microsoft offcie 365")
public class WOPIService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WOPIService.class);
    // TODO: 02-07-2020 replace all the below constants by reading them Headers from Microsoft call directly
    private static final String basicAuthHeader = WOPIConstants.BASIC + Base64Utils.encodeToString(("ponnl" + ":" + "rules").getBytes());
    private static final String baseURL = "https://lab5367.lab.pega.com/prweb/api/wopi/1";
    private static final String insKey = "DATA-WORKATTACH-FILE PEGASOCIAL-DOCUMENT DOC-13!20200704T120311.522 GMT";
    private static final String data = "DATA";

    private final PegaClient pegaClient;

    @Autowired
    public WOPIService(PegaClient pegaClient) {
        this.pegaClient = pegaClient;
    }

    @ApiOperation(value = WOPIConstants.API_FILE_METADATA, response = CheckFileInfo.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = WOPIConstants.API_FILE_CHECKFILEINFO)
    }
    )
    @GetMapping(value = WOPIConstants.REST_END_POINT_GET_FILE_INFO, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<CheckFileInfo> getFileInfo(@PathVariable final String name, final HttpServletResponse response) {
        LOGGER.info(WOPIConstants.INFO_WOPISERVICE_GETFILEINFO + name);
        CheckFileInfo checkFileInfo = null;
        try {
            CheckFileInfoReq checkFileInfoReq;
            if (!name.contains(data)) {
                checkFileInfoReq = new CheckFileInfoReq(insKey);
            } else {
                checkFileInfoReq = new CheckFileInfoReq(name.replaceAll("@", " "));
            }
            checkFileInfo = pegaClient.getCheckFileInfo(baseURL, basicAuthHeader, checkFileInfoReq);
            //response.addHeader(HttpHeaders.CONTENT_DISPOSITION, WOPIConstants.ATTACHMENT_INLINE + new String("sample.txt".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            LOGGER.info(WOPIConstants.INFO_WOPISERVICE_GETFILEINFO_CHECKFILEINFO + checkFileInfo.toString());
        } catch (Exception e) {
            LOGGER.error(WOPIConstants.INFO_WOPISERVICE_GETFILEINFO_EXCEPTION + e);
        }
        return Mono.just(Objects.requireNonNull(checkFileInfo));
    }


    @ApiOperation(value = WOPIConstants.API_FILE_OCTETSTREAM, response = File.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = WOPIConstants.API_FILE_DOWNLOADED)
    }
    )
    @GetMapping(WOPIConstants.REST_END_POINT_GET_FILE_CONTENT)
    public void getFileContent(@PathVariable final String name, final HttpServletResponse response) {

        try {
            CheckFileInfoReq checkFileInfoReq;
            if (!name.contains(data)) {
                checkFileInfoReq = new CheckFileInfoReq(insKey);
            } else {
                checkFileInfoReq = new CheckFileInfoReq(name.replaceAll("@", " "));
            }

            LOGGER.info(WOPIConstants.INFO_WOPISERVICE_FILECONTENT_NAME + name);
            FilecontentRes fileContent = pegaClient.getFileContent(baseURL, basicAuthHeader, checkFileInfoReq);
            LOGGER.info(WOPIConstants.INFO_WOPISERVICE_FILECONTENT_FILECONTENT + fileContent.toString());
            String fileName = fileContent.getBaseFileName();
            byte[] decodedData = Base64.getDecoder().decode(fileContent.getFileContent());
            InputStream is = new ByteArrayInputStream(decodedData);

            response.addHeader(HttpHeaders.CONTENT_DISPOSITION, WOPIConstants.ATTACHMENT_FILENAME + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(is.available()));
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();

        } catch (Exception e) {
            LOGGER.error(WOPIConstants.EXCEPTION_WOPISERVICE_FILECONTENT + e);
        }
    }


    @ApiOperation(value = WOPIConstants.API_FILE_UPDATE_CONTENT, response = boolean.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = WOPIConstants.API_FILE_UPLOADED)
    }
    )
    @PostMapping(value = WOPIConstants.REST_END_POINT_PUT_UPDATED_FILE)
    public boolean postFile(@RequestBody final byte[] content, @PathVariable final String name) {
        boolean isSuccessful = false;
        try {
            LOGGER.info(WOPIConstants.INFO_WOPISERVICE_PUTFILE_NAME + name);
            byte[] encoded = Base64.getEncoder().encode(content);
            final String encodedData = new String(encoded, StandardCharsets.UTF_8);
            PutFileContentReq putFileContentReq;
            if (!name.contains(data)) {
                putFileContentReq = new PutFileContentReq(insKey, encodedData);
            } else {
                putFileContentReq = new PutFileContentReq(name.replaceAll("@", " "), encodedData);
            }
            LOGGER.info(WOPIConstants.INFO_WOPISERVICE_PUTFILE_PUTFILECONTENTREQ + putFileContentReq.toString());
            PutFileContentRes putFileContentRes = pegaClient.putUpdatedFileContent(baseURL, basicAuthHeader, putFileContentReq);
            LOGGER.info(WOPIConstants.INFO_WOPISERVICE_PUTFILE_PUTFILECONTENTREs + putFileContentRes.toString());
            isSuccessful = putFileContentRes.isSuccessful();
        } catch (Exception e) {
            LOGGER.error(WOPIConstants.EXCEPTION_WOPISERVICE_POSTFILE + e);
        }
        return isSuccessful;
    }


    @ApiOperation(value = WOPIConstants.API_FILE_LOGFILE, response = File.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = WOPIConstants.API_LOG_FILE_DOWNLOADED)
    }
    )
    @GetMapping(WOPIConstants.REST_END_POINT_GET_LOG_FILE)
    public void getLogFile(final HttpServletResponse response) {
        try {
            File logFile = new File(WOPIConstants.LOG_FILE_PATH);
            InputStream is = new FileInputStream(logFile);
            response.addHeader(HttpHeaders.CONTENT_DISPOSITION, WOPIConstants.ATTACHMENT_FILENAME + new String(logFile.getName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(is.available()));
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();

        } catch (Exception e) {
            LOGGER.error(WOPIConstants.EXCEPTION_WOPISERVICE_GETLOGFILE + e);
        }
    }
}
