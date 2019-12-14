# Label Lens
The purpose of Label Lens is to simplify the image-labeling process for computer vision (CV) and machine learning (ML) applications. Image-labeling is the process of recognizing different entities, or regions of interest (ROI), in an image. Label Lens provides the user a platform to capture images and label regions of interest in the captured image. The captured images and ROI’s are stored as an image and a text document, respectively. The text document contains the square coordinate location where the ROI is located in the captured images. The files are stored on device and in an Amazon Web Service (AWS) Simple Storage Service (S3) Bucket database for easy retrieval. 
  1. Take pictures at the click of a button
  2. View and select images
  3. Crop and label images
  
  ![Preview_Image](https://github.com/dannypadilla/label-lens/blob/gallery/P.jpg)

## Features
- Image taking
- Image storing
- Image processing
- Image uploading
- Supports various android versions

## Usages
Dependancy: This project runs on CameraX which can be found here: https://github.com/android/camera-samples

## How-to-Use
  1. Take a picture with camera (via app)
  2. View and edit picture as necessary
  3. Output / uploading the image

## Accessing Labelled Images
  1. Install the [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2-linux-mac.html#cliv2-linux--mac-prereq)
  2. Navigate to your desired location in the terminal
  3. `aws s3 sync s3://labellens-userfiles-mobilehub-866544857/public/* <your_folder>`
  4. Examine the results 👍
  ![Preview_Image](https://labellens-userfiles-mobilehub-866544857.s3-us-west-2.amazonaws.com/public/Screen+Shot+2019-12-13+at+4.32.39+PM.png)

## Fragments
  1. Main Menu Fragment
    * Display App name (Label Lens)
    * Display Camera Display Button (#2)
    * Display Photo Gallery Button (#3)
    * Display Labeling Button (#4)
    * Display an info explanation Button

  2. Camera Display Fragment
    * For taking pictures.
    * Stores images to local device (phone)

  3. Photo Gallery Fragment
    * For reviewing images taken
    * Can swipe right/left to swap images
    * Pictures ordered by date

  4. Label-Images Fragment
    * Displays last taken image.
    * When a portion of the image is tapped, a square box is displayed.
    * The box shall bound the area where the tap was detected.
    * The coordinates of the box are stored as a JSON.

  5. Region of interest Gallery
    * Display the square bounding boxes created in the `Label-Images Fragment`
    * This Fragment can be displayed after the `Camera Display Fragment`.

## Finished
  - Way to upload data from phone
  - Picture taking method
  - Picture saving/storing
  - Implement CameraX

## TODO
  - use Camera2 to capture image (Replaced by CameraX)
  - Create GUI for drawing boxes overlayed on captured image
  - Make an API to get labeled data off backend
