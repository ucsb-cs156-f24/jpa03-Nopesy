package edu.ucsb.cs156.example.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import edu.ucsb.cs156.example.services.wiremock.WiremockServiceImpl;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("integration")
class ITOauth {
    @LocalServerPort
    private int port;

    private Browser browser;
    private Page page;

    @RegisterExtension
    static WireMockExtension wme = WireMockExtension.newInstance()
            .options(wireMockConfig()
                    .port(8090)
                    .extensions(new ResponseTemplateTransformer(true)))
            .build();

    @BeforeEach
    public void setup() {

        WiremockServiceImpl.setupOauthMocks(wme);

        // Launch playwright browser headless
        browser = Playwright.create().chromium().launch();

        // Launch playwright browser with visual
        // browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    public void teardown() {
        browser.close();
    }

    @Test
    public void tryLogin() throws Exception {
        // Navigate straight to authorization url, since login button doesn't change href inside integration test
        String url = String.format("http://localhost:%d/oauth2/authorization/my-oauth-provider", port);
        page.navigate(url);

        page.locator("#username").fill("cgaucho@ucsb.edu");
        page.locator("#password").fill("password");

        page.locator("#submit").click();

        assertThat(page.getByText("Log Out")).isVisible();
        assertThat(page.getByText("Welcome, cgaucho@ucsb.edu")).isVisible();
    }

}