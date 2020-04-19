package com.pega.microsoftwopi.WOPIClient;

import com.pega.microsoftwopi.pojo.WOPIDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class DiscoveryClient {

    @Autowired
    Environment env;

    public void getDiscoveryXML() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            final String baseUrl = env.getProperty("wopiDiscoveryURL");
            URI uri = new URI(baseUrl);
            ResponseEntity<WOPIDiscovery> result = restTemplate.getForEntity(uri, WOPIDiscovery.class);
            result.getBody();
        } catch (Exception e) {
            System.out.print("Exception getting  Discovery XML" + e);
        }
    }

}
