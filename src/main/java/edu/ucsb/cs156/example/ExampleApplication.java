package edu.ucsb.cs156.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import edu.ucsb.cs156.example.services.WiremockService;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ExampleApplication {

  @Autowired
  WiremockService wiremockService;

  @Profile("wiremock")
  @Bean
  public ApplicationRunner wiremockApplicationRunner() {
    return arg -> {
      log.info("wiremock mode");
      wiremockService.init();
      log.info("wiremockApplicationRunner completed");
    };
  }

  @Profile("development")
  @Bean
  public ApplicationRunner developmentApplicationRunner() {
    return arg -> {
      log.info("development mode");
      log.info("developmentApplicationRunner completed");
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(ExampleApplication.class, args);
  }
}