package edu.ucsb.cs156.example.web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import edu.ucsb.cs156.example.services.wiremock.WiremockServiceImpl;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("integration")
public class OauthWebIT {
    @LocalServerPort
    private int port;

    @Value("${app.playwright.headless:true}")
    private boolean runHeadless;

    private Browser browser;
    private Page page;

    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void setupWireMock() {
        wireMockServer = new WireMockServer(options()
            .port(8090)
            .extensions(new ResponseTemplateTransformer(true)));

        WiremockServiceImpl.setupOauthMocks(wireMockServer, false);

        wireMockServer.start();
    }

    @AfterAll
    public static void teardownWiremock() {
        wireMockServer.stop();
    }
    
    @BeforeEach
    public void setup() {
        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(runHeadless));

        BrowserContext context = browser.newContext();
        page = context.newPage();

    }

    @AfterEach
    public void teardown() {
        browser.close();
    }

    @Test
    public void tryLoginLogout() throws Exception {
        String url = String.format("http://localhost:%d/oauth2/authorization/my-oauth-provider", port);
        page.navigate(url);

        page.locator("#username").fill("cgaucho@ucsb.edu");
        page.locator("#password").fill("password");

        page.locator("#submit").click();

        assertThat(page.getByText("Log Out")).isVisible();
        assertThat(page.getByText("Welcome, cgaucho@ucsb.edu")).isVisible();

        page.getByText("Log Out").click();

        assertThat(page.getByText("Log In")).isVisible();
        assertThat(page.getByText("Log Out")).not().isVisible();
    }
}