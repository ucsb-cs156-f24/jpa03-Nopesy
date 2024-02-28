package edu.ucsb.cs156.example.web;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This is an example of an integration test 
 * that doesn't test anything, but allows us to see the minimum 
 * boilerplate needed to create an integration test.
 * 
 * It is recommended to NOT included this in any project other than
 * jpa03, where it serves as a teaching example.
 * 
 * It can also be used to test whether the maven tooling for integration
 * tests is working, independent of other code.
 */

@SpringBootTest
public class ITExample {
    @Test
    public void testTest() throws Exception {
        assertTrue(true);
    }
}
