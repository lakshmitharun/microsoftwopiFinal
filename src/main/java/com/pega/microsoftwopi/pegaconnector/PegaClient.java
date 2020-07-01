package com.pega.microsoftwopi.pegaconnector;

import com.pega.microsoftwopi.constants.WOPIConstants;
import com.pega.microsoftwopi.pojo.CheckFileInfo;
import com.pega.microsoftwopi.pojo.CheckFileInfoReq;
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


        WebClient webClient = WebClient.builder()
                .baseUrl(pegaBaseURL)
                .clientConnector(clientHttpConnector)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(logRequest())
                .filter(logResponse())
                .build();

        ResponseEntity<CheckFileInfo> authorization = webClient.post()
                .uri(WOPIConstants.REST_END_POINT_PEGA_CHECK_FILE_INFO)
                .body(Mono.just(checkFileInfoReq), CheckFileInfoReq.class)
                .header(WOPIConstants.AUTHORIZATION, authenticationHeader)
                .exchange()
                .flatMap(response -> response.toEntity(CheckFileInfo.class)).block();

        return Objects.requireNonNull(authorization).getBody();
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
