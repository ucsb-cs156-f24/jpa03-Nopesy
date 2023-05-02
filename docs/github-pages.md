# Github Pages

This repo is setup to publish documentation to a `gh-pages`
branch that forms the basis of a GitHub pages site.

This file explains how to set up GitHub pages to publish
that documentation.

You might get a red X on the GitHub actions that
work with GitHub pages when you first push the starter
code for this repo to a new repo; the instructions below
explain how to take care of that.

# Steps

1. Enable Github Pages on the repo settings as shown below.
   * Select `Settings`, then `Pages`, then change `Source` to `Github Actions`
   
   ![enable-gh-pages-workflow](https://user-images.githubusercontent.com/1119017/235544870-58cc4dfe-b23e-4718-a23a-ef335f4fce2a.gif)


2. Go to the `Actions` menu, and launch workflow `02-gh-pages-rebuild` as shown. This may take a few minutes to run.
   It will create the Github Pages site for the repo, with links to documentation for both the backend (javadoc) and
   frontend (storybook).
   
   ![run-workflow-02](https://user-images.githubusercontent.com/1119017/235545108-e6da1791-5a29-44e9-a8f8-ff4e7a6b889b.gif)

  
3. Return to the main page for the repo,  click on the gear at right, and click the box for Github Pages, as shown below
   
   ![add-gh-pages-link](https://user-images.githubusercontent.com/1119017/235330985-1d181d00-c775-4c93-aec1-87414467e0ed.gif)

4. Check that the link loads the Github Pages site.  It should look something like this, but with your repo name in place
   of the one shown.

   <img width="910" alt="image" src="https://user-images.githubusercontent.com/1119017/235750584-2e66dc07-12b3-4593-a289-7e2f2b2060c2.png">

As you add pull requests, the javadoc and storybook will be generated for those as well by GitHub Actions scripts.  

If at any point, you want to rebuild the entire documentation site, you can run the GitHub Action `02-gh-pages-rebuild`
again.

   
