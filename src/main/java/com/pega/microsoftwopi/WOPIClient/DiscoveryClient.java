package com.pega.microsoftwopi.WOPIClient;

import com.pega.microsoftwopi.pojo.WOPIDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Objects;

@Service
public class DiscoveryClient {

    private final Environment env;

    @Autowired
    public DiscoveryClient(Environment env) {
        this.env = env;
    }

    private void getDiscoveryXML() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            final String baseUrl = env.getProperty("wopiDiscoveryURL");
            URI uri = new URI(Objects.requireNonNull(baseUrl));
            ResponseEntity<WOPIDiscovery> result = restTemplate.getForEntity(uri, WOPIDiscovery.class);
            WOPIDiscovery wopiDiscovery = result.getBody();
        } catch (Exception e) {
            System.out.print("Exception getting  Discovery XML" + e);
        }
    }

}
