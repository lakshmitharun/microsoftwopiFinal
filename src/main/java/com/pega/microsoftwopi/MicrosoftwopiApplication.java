package com.pega.microsoftwopi;

import com.pega.microsoftwopi.Util.ApplicationStarter;
import com.pega.microsoftwopi.constants.WOPIConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicrosoftwopiApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MicrosoftwopiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MicrosoftwopiApplication.class, args);
        try {
            ApplicationStarter.addDiscoveryMapToServletContext();
        } catch (Exception e) {
            LOGGER.error(WOPIConstants.EXCEPTION_MICROSOFTWOPIAPPLICATION_MAIN + e);

        }
    }


}
