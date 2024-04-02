package edu.ucsb.cs156.example.helpers;

/**
 * A helper class to provide hardcoded strings that can be used both in
 * implementation
 * and in tests
 */

public class StringSource {
  /**
   * 
   * @return a string with instructions on how to run the frontend server.
   *          This is used in development on
   *          localhost when the frontend server is not running.
   */

  public static String getDevelopmentDefaultLocalhostContent() {
    return """
        <p>Failed to connect to the frontend server...</p>
        <p>On Heroku or Dokku, be sure that <code>PRODUCTION</code> is defined.</p>
        <p>On localhost, open a second terminal window, cd into <code>frontend</code> and type: <code>nvm use 16.20.0; npm install; npm start</code></p>
        <p>Or, you may click to access: </p>
        <ul>
          <li><a href="/swagger-ui/index.html">/swagger-ui/index.html</a></li>
          <li><a href="/h2-console">/h2-console</a></li>
        </ul>""";
  }

  /**
   * 
   * @return a string with the contents of the application's home page
   *          for use during integration tests. It is identical to the
   *          production homepage.
   */
  public static String getIntegrationDefaultLocalhostContent() {
    return """
      <noscript>You need to enable JavaScript to run this app.</noscript><div id="root"><div class="Toastify"></div><div class="d-flex flex-column min-vh-100"><nav data-testid="AppNavbar" class="navbar navbar-expand-xl navbar-dark bg-dark sticky-top"><div class="container"><a class="navbar-brand" href="/">JPA03</a><button type="button" aria-label="Toggle navigation" class="navbar-toggler collapsed"><span class="navbar-toggler-icon"></span></button><div class="me-auto navbar-nav"></div><div class="justify-content-between navbar-collapse collapse"><div class="mr-auto navbar-nav"></div><div class="ml-auto navbar-nav"><a role="button" tabindex="0" href="/oauth2/authorization/google" class="btn btn-primary">Log In</a></div></div></div></nav><div expand="xl" class="pt-4 flex-grow-1 container"><div class="pt-2"><h1>jpa03</h1><p>This is a webapp containing a bunch of different Spring Boot/React examples.</p></div></div><footer class="bg-light pt-3 pt-md-4 pb-4 pb-md-5"><div class="container"><p>This is a sample webapp using React with a Spring Boot backend.</p></div></footer></div></div>""";
  }
}
