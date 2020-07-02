package com.pega.microsoftwopi.pegaconnector;

import com.pega.microsoftwopi.constants.WOPIConstants;
import com.pega.microsoftwopi.pojo.prpc.CheckFileInfoReq;
import com.pega.microsoftwopi.pojo.prpc.FilecontentRes;
import com.pega.microsoftwopi.pojo.prpc.PutFileContentReq;
import com.pega.microsoftwopi.pojo.prpc.PutFileContentRes;
import com.pega.microsoftwopi.pojo.wopi.CheckFileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class PegaClient {

    private final ClientHttpConnector clientHttpConnector;
    private static final Logger LOGGER = LoggerFactory.getLogger(PegaClient.class);

    @Autowired
    public PegaClient(@Qualifier("webclientConfig") ClientHttpConnector clientHttpConnector) {
        this.clientHttpConnector = clientHttpConnector;
    }

    public CheckFileInfo getCheckFileInfo(String pegaBaseURL, String authenticationHeader, CheckFileInfoReq checkFileInfoReq) {


        WebClient webClient = getWebClient(pegaBaseURL);


        ResponseEntity<CheckFileInfo> responseEntity = webClient.post()
                .uri(WOPIConstants.REST_END_POINT_PEGA_CHECK_FILE_INFO)
                .body(Mono.just(checkFileInfoReq), CheckFileInfoReq.class)
                .header(WOPIConstants.AUTHORIZATION, authenticationHeader)
                .exchange()
                .flatMap(response -> response.toEntity(CheckFileInfo.class)).block();

        return Objects.requireNonNull(responseEntity).getBody();
    }

    public FilecontentRes getFileContent(String pegaBaseURL, String authenticationHeader, CheckFileInfoReq checkFileInfoReq) {

        WebClient webClient = getWebClient(pegaBaseURL);

        ResponseEntity<FilecontentRes> responseEntity = webClient.post()
                .uri(WOPIConstants.REST_END_POINT_PEGA_FILE_CONTENT)
                .body(Mono.just(checkFileInfoReq), CheckFileInfoReq.class)
                .header(WOPIConstants.AUTHORIZATION, authenticationHeader)
                .exchange()
                .flatMap(response -> response.toEntity(FilecontentRes.class)).block();

        return Objects.requireNonNull(responseEntity).getBody();

    }

    public PutFileContentRes putUpdatedFileContent(String pegaBaseURL, String authenticationHeader, PutFileContentReq putFileContentReq) {
        WebClient webClient = getWebClient(pegaBaseURL);
        ResponseEntity<PutFileContentRes> responseEntity = webClient.post()
                .uri(WOPIConstants.REST_END_POINT_PEGA_UPDATE_FILE_CONTENT)
                .body(Mono.just(putFileContentReq), PutFileContentReq.class)
                .header(WOPIConstants.AUTHORIZATION, authenticationHeader)
                .exchange()
                .flatMap(response -> response.toEntity(PutFileContentRes.class)).block();

        return Objects.requireNonNull(responseEntity).getBody();

    }

    private WebClient getWebClient(String pegaBaseURL) {
        return WebClient.builder()
                .baseUrl(pegaBaseURL)
                .clientConnector(clientHttpConnector)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return PegaClient::filter;
    }

    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(PegaClient::apply);
    }

    private static Mono<ClientResponse> apply(ClientResponse clientResponse) {
        LOGGER.info(WOPIConstants.RESPONSE_STATUS, clientResponse.statusCode());
        return Mono.just(clientResponse);
    }

    private static Mono<ClientResponse> filter(ClientRequest clientRequest, ExchangeFunction next) {
        LOGGER.info(WOPIConstants.REQUEST_DETAILS, clientRequest.method(), clientRequest.url());
        clientRequest.headers()
                .forEach((name, values) -> values.forEach(value -> LOGGER.info(WOPIConstants.HEADERS_LOG, name, value)));
        return next.exchange(clientRequest);
    }


}
