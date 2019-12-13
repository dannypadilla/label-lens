# Label Lens


### Android App

#### TODO

- Create method to upload data from phone
- Setup backend to store data as (Image, Label)
- use Camera2 to capture image
- Create GUI for drawing boxes overlayed on captured image
- Make an API to get labeled data off backend

### Accessing Labelled Images
1. Install the [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2-linux-mac.html#cliv2-linux--mac-prereq)
2. Navigate to your desired location in the terminal
3. `aws s3 sync s3://labellens-userfiles-mobilehub-866544857/public/* <your_folder>`
4. Look at the things 👍

## Fragments

1. Main Menu Fragment
  - Display App name (Label Lens).
  - Display Camera Display Button.
  - Display Photo Gallery Button.
  - Display Labeling Button.
  - Display an info explanation Button.

2. Camera Display Fragment
  - For taking pictures.
  - Stores images to local device (phone).

3. Photo Gallery Fragment
  - For reviewing images taken.

4. Label-Images Fragment
  - Displays last taken image.
  - When a portion of the image is tapped, a square box is displayed.
  - The box shall bound the area where the tap was detected.
  - The coordinates of the box are stored as a JSON.


5. Region of interest Gallery
  - Display the square bounding boxes created in the `Label-Images Fragment`
  - This Fragment can be displayed after the `Camera Display Fragment`.
