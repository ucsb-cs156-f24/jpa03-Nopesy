package edu.ucsb.cs156.example.helpers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class StringSourceTests  {

    /**
     * This is just for jacoco test coverage
     */

  @Test
  void test_defaultConstructor() {
    StringSource stringSource = new StringSource();
    assertTrue(stringSource instanceof StringSource);
  }

  /**
     * This is for pitest coverage
     */

     @Test
     void test_nonBlank() {
       assertTrue(StringSource.getDevelopmentDefaultLocalhostContent().length() > 0);
       assertTrue(StringSource.getIntegrationDefaultLocalhostContent().length() > 0);
     }

}
