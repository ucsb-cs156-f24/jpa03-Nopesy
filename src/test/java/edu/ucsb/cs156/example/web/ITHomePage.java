package edu.ucsb.cs156.example.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import edu.ucsb.cs156.example.helpers.StringSource;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("integration")
class ITHomePage {
    @LocalServerPort
    private int port;

    private Browser browser;
    private Page page;

    @BeforeEach
    public void setup() {
        browser = Playwright.create().chromium().launch();
        BrowserContext context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    public void teardown() {
        browser.close();
    }

    @Test
    public void testGreeting() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        page.navigate(url);
        String bodyHTML = page.innerHTML("body");
        String expectedHTML = StringSource.getIntegrationDefaultLocalhostContent();
        assertEquals(expectedHTML, bodyHTML);
    }

}