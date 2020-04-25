package com.pega.microsoftwopi.WOPIController;

import com.pega.microsoftwopi.constants.WOPIConstants;
import com.pega.microsoftwopi.pojo.CheckFileInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WOPIService {

    @GetMapping(WOPIConstants.REST_END_POINT_GETFILEINFO)
    public Mono<CheckFileInfo> getFileInfo(){
        return Mono.just(null);
    }
}
