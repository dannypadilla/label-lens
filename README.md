# Label Lens


### Android App

#### TODO

- Create method to upload data from phone
- Setup backend to store data as (Image, Label)
- use Camera2 to capture image
- Create GUI for drawing boxes overlayed on captured image
- Make an API to get labeled data off backend


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
