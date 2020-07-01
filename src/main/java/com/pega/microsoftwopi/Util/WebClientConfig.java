package com.pega.microsoftwopi.Util;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {

    @Value("${timeouts.connectionTimeout}")
    private int connectionTimeout;

    @Value("${timeouts.readTimeout}")
    private int readTimeout;

    @Value("${timeouts.writeTimeout}")
    private int writeTimeout;

    @Bean(name = "webclientConfig")
    public ClientHttpConnector getWebClient()
    {
        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(client ->
                        client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeout)
                                .doOnConnected(conn -> conn
                                        .addHandlerLast(new ReadTimeoutHandler(readTimeout))
                                        .addHandlerLast(new WriteTimeoutHandler(writeTimeout))));

        return new ReactorClientHttpConnector(httpClient);

    }

}
