package edu.ucsb.cs156.example.helpers;

/**
 * A helper class to provide hardcoded strings that can be used both in
 * implementation
 * and in tests
 */

public class StringSource {
  /**
   * 
   * @returns a string with instructions on how to run the frontend server.
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
}
