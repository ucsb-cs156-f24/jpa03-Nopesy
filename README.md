# STARTER-jpa03

```
TODO: Change link below from the example running app to your own running app
For example, you might change it to:

Running at: <https://jpa03-cgaucho.dokku-13.cs.ucsb.edu>

Then remove this TODO item.
```

Running at: <https://starter-jpa03.dokku-00.cs.ucsb.edu>

# Configuring GitHub Pages for the documentation

This repo contains Github Actions scripts that automatically create and publish documentation for the code:
* javadoc for the backend Java code
* Storybook for the frontend React code

To set this up, follow the instructions here: [`docs/github-pages.md`](docs/github-pages.md)

# Getting Started on localhost

Before running the application for the first time on localhost, you must: 

* Set up Google OAuth as documented in [`docs/oauth.md`](docs/oauth.md) 

Otherwise, when you try to login for the first time, you 
will likely see an error such as:

<img src="https://user-images.githubusercontent.com/1119017/149858436-c9baa238-a4f7-4c52-b995-0ed8bee97487.png" alt="Authorization Error; Error 401: invalid_client; The OAuth client was not found." width="400"/>

Then:

* Open *two separate terminal windows*  
* In the first window, start up the backend with:
  ``` 
  mvn spring-boot:run
  ```
* In the second window:
  ```
  cd frontend
  npm install  # only on first run or when dependencies change
  npm start
  ```
  
  
  ```

The app should be available on <http://localhost:8080>

### Note: <http://localhost:8080> not <http://localhost:3000> 

The `npm start` command may open up a web browser with the app running on port <http://localhost:3000>.

* You should *close this window* and work in one where you put in the url <http://localhost:8080>.  
* The <http://localhost:3000> window has a frontend that is *not connected to the backend* and most
  functions in that window will fail to work.
* If you want to avoid this useless browser window opening up, <br />
  instead of `npm start`, type this:

  ```
  BROWSER=none npm start
  ```
  
### What if it doesn't work?

If it doesn't work at first, e.g. you have a blank page on  <http://localhost:8080>, give it a minute and a few page refreshes.  Sometimes it takes a moment for everything to settle in.

If you see the following on localhost, make sure that you also have the frontend code running in a separate window.

```
Failed to connect to the frontend server... 

On Dokku, be sure that PRODUCTION is defined. 

On localhost, open a second terminal window, 
cd into frontend and type: npm install; npm start";
```

# Getting Started on Dokku

* Follow the steps here: <https://ucsb-cs156.github.io/topics/dokku/getting_started.html>
* Set up Google OAuth as documented in [`docs/oauth.md`](docs/oauth.md) 
* Set up Postgres, as documented in  <https://ucsb-cs156.github.io/topics/dokku/postgres_database.html>
* Set the config variable `PRODUCTION=true`

# Accessing swagger

Swagger is a tool that allows you to work directly with the RESTful API endpoints of the backend.
It is similar to the tool Postman, but more convenient because it is built directly into the application.

To access the Swagger API endpoints, use:

* <http://localhost:8080/swagger-ui/index.html>

You can also append `/swagger-ui/index.html` to the URL manually when running on Dokku.

# To run React Storybook locally (for development)

* cd into frontend
* use: `npm run storybook`
* This should put the storybook on http://localhost:6006
* Additional stories are added under frontend/src/stories

You can also see the storybook for the main branch and all open pull requests on the 
github pages site associated with the repo; see [/docs/github-pages.md](/docs/github-pages.md) for more info.

* For documentation on React Storybook, see: <https://storybook.js.org/>

# To generate javadoc (locally, for development)

* cd to top level of repo
* use: `mvn javadoc:javadoc`
* open in a web browser: `target/site/apidocs/index.html`

You can also see the javadoc for the main branch and all open pull requests on the 
github pages site associated with the repo; see [/docs/github-pages.md](/docs/github-pages.md) for more info.

* For documentation on Javadoc, see: <https://www.oracle.com/java/technologies/javase/javadoc-tool.html>

# SQL Database access

On localhost:
* The SQL database is an H2 database and the data is stored in a file under `target`
* Each time you do `mvn clean` the database is completely rebuilt from scratch
* You can access the database console via a special route, <http://localhost:8080/h2-console>
* For more info, see [docs/h2-database.md](/docs/h2-database.md)

On Dokku:
* The SQL database is a postgres database provisioned automatically by Dokku
* More info and instructions for accessing the SQL prompt are at [docs/postgres-database.md](/docs/postgres-database.md)

# Testing

* To run unit tests, use: `mvn test`
  - Unit tests are any methods labelled with the `@Test` annotation that are under the `/src/test/java` hierarchy, and have file names that end in `Test` or `Tests`
* To run only the integration tests, use: `INTEGRATION=true mvn test-compile failsafe:integration-test`
  - Integration tests are any methods labelled with `@Test` annotation, that are under the `/src/test/java` hierarchy, and have names starting with `IT` (specifically capital I, capital T).
  - By convention, we are putting Integration tests (the ones that run with Playwright) under the package `src/test/java/edu/ucsb/cs156/example/web`
  - Unless you want a particular integration test to *also* be run when you type `mvn test`, do *not*
  use the suffixes `Test` or `Tests` for the filename.
  - Note that while `mvn test` is typically sufficient to run tests, we have found that if you haven't compiled the test code yet, running `mvn failsafe:integration-test` may not actually run any of the tests.