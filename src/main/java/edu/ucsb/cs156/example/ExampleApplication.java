package edu.ucsb.cs156.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The ExampleApplication class is the main entry point for the application.
 */
@SpringBootApplication
public class ExampleApplication {

  /**
   * The main method is the entry point for the application.
   * @param args command line arguments, typically unused for Spring Boot applications
   */
  public static void main(String[] args) {
    SpringApplication.run(ExampleApplication.class, args);
  }

}
