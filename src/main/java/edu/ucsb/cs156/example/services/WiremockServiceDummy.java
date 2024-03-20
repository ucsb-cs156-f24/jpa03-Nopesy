package edu.ucsb.cs156.example.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.github.tomakehurst.wiremock.WireMockServer;


@Slf4j
@Service("wiremockService")
@Profile("!wiremock")
@ConfigurationProperties
public class WiremockServiceDummy extends WiremockService {
  
    public WireMockServer getWiremockServer() {
      return null;
    }

    public void init() {
      log.info("WiremockServiceDummy.init() called");
      log.info("WiremockServiceDummy.init() completed");
    }

}