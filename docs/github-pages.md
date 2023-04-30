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

1. Check whether the `gh-pages` branch exists.  This shows what it looks like when the branch exists:

   ![gh-pages-exists](https://user-images.githubusercontent.com/1119017/235330875-bf0d1be7-7884-4bc0-839e-76f02836d7a9.gif)


   If you don't see a branch called `gh-pages`, manually trigger the workflow `01-create-or-reset-gh-pages-branch` as shown here, and it will
   create the branch:
   
   ![run-action-to-estabilsh-gh-pages-branch](https://user-images.githubusercontent.com/1119017/235330809-fb80472c-44a7-4f5a-a6dd-bee2978de8f9.gif)

2. Once the `gh-pages` branch exists, go to the `Settings` for the repo, and enable GitHub pages as shown below:

   * Navigate to `Pages` from the left nav
   * Select the `gh-pages` branch, and the Root directory, and save the settings:
   
   ![enable-gh-pages](https://user-images.githubusercontent.com/1119017/235330927-d39ca5a4-dfaf-4763-b442-d71cd9badc54.gif)

3. Return to the main page for the repo,  click on the gear at right, and click the box for Github Pages, as shown below
   
   ![add-gh-pages-link](https://user-images.githubusercontent.com/1119017/235330985-1d181d00-c775-4c93-aec1-87414467e0ed.gif)

4. Check that the link loads the Github Pages site:

   
