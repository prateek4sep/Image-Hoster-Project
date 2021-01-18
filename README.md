# Image-Hoster-Project
A basic Image Hosting application

## Setup Pre-requisites:
Use following configuration in pgAdmin:

pgAdmin server URL: jdbc:postgresql://localhost:5432/imageHoster

port: 5432

Username: postgres

Password: postgres

Add Database named: imageHoster

OR: adjust in the source code (JpaConfig.java and persitence.xml) according to your existing configuration. 


-------------------------------

## Details of Bug Fixes - branch 'bugFixes':

1. FIX for Image upload issue - Images with Same Title - https://github.com/prateek4sep/Image-Hoster-Project/commit/91b41a77630ad765b5bb8d3f355300cffe03a280 - If you upload an image with the same exact title as of a previously uploaded image, it will get uploaded. But then, if you try to navigate to one of the images with the same title, the image uploader will display an error. This issue is fixed by introducing imageID.

2. BUG FIX: Image Deletion Issue - Non-owners can no longer delete an image - https://github.com/prateek4sep/Image-Hoster-Project/commit/7bbcb1289f6e92f051256df5e66f97ff919675cd - After logging into the application, it is possible to edit/delete the image which is posted by some other user. This issue is fixed by validating the user fetched from the session data.

3. BUG FIX: Image Editing Issue - Non-owners can no longer edit an image - https://github.com/prateek4sep/Image-Hoster-Project/commit/dfc242903591b88eeb52981bd84ca5ed0141319a - After logging into the application, it is possible to edit/delete the image which is posted by some other user. This issue is fixed by validating the user fetched from the session data.

## Details of New Features - branch 'newFeatures':

1. NEW FEATURE: Added password validation - https://github.com/prateek4sep/Image-Hoster-Project/commit/9a787a38e81a13e58e40e3e68bba1a4b176aa08f - The password entered by the user must contain at least 1 alphabet (a-z or A-Z), 1 number (0-9) and 1 special character (any character other than a-z, A-Z and 0-9).

2. NEW FEATURE: Added User Comments support - https://github.com/prateek4sep/Image-Hoster-Project/commit/154ce93de3d10197c7829a4d78ab2eec87f0e981 - User can add a comment to any image in the application after he is logged in the application.

## Details of Additional Bugs (not explicitly stated in the Problem Statement) - branch 'additionalBugFixes':

1. BUG FIX: Image Edit - Duplicate title issue - https://github.com/prateek4sep/Image-Hoster-Project/commit/16dfc5108ee5e193b4279e71e25cd1638b1a7246 - Images with duplicate title throws an error while editing. Fixed the issue by introducing imageID.

2. BUG FIX: Deleting an image with comments - Removing the dependency - https://github.com/prateek4sep/Image-Hoster-Project/commit/01f52962f212448f35fffd733e4dd92d69dd6324 - An image with added comments can't be deleted because of Foreign Key dependency with Comments. Fixed the same by deleting the dependent comments first.
