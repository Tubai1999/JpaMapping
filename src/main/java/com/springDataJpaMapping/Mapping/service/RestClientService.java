package com.springDataJpaMapping.Mapping.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class RestClientService {

    Logger log = LoggerFactory.getLogger(RestClientService.class);


    private final RestClient restClient;

    public RestClientService(RestClient restClient) {
        this.restClient = restClient;
    }


    public String getPostFromThirdPartyAPI(){
        log.error("error occured");
        log.warn("warning");
        log.info("info");
        log.debug("debugging");
        log.trace("tracing");
        String returnedData = restClient.get()
                .uri("posts/1")
                .retrieve()
                .body(String.class);
        return returnedData;
    }



    public String createPostToThirdPartyAPI(){
        Map<String,Object> dummyData = new HashMap<>();
        dummyData.put("userId", 10);
        dummyData.put("id",1);
        dummyData.put("titile","hi! tridib here from java backend community");
        dummyData.put("body","inisde body");
        String createdPost = restClient.post()
                .uri("posts")
                .body(dummyData)
                .retrieve()
                .body(String.class);
        return createdPost;
    }
}
