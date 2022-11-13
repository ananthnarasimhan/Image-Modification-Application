# How to Run JAR
  - Run the following in terminal
  - java -jar project5.jar -script path-of-script-file (for batch file mode). 
  - java -jar project5.jar -interactive (for UI mode).

# ASSUMPTIONS
- Values for converting to sepia tone and grey scale is fixed and is defined in code.
- I have assumed that at one time only one operation can be performed.
- I have used the 8 colors per channel for dithering.
- Read,remove color,replace color and write cross stitch pattern can be performed only after cross stitch.
- Update dmc index can be done only using UI and not batch command.
- Convert to dmc colors will change the image matrix.
- The user will always enter data in pop up panes.


# List of Working Features
- My program is able to convert the image into grey scale,sepia tone, blur,sharpen,clamp values, dither,mosaic,pixellate an image  successfully.
- My program is also able to generate cross stitch pattern also.
- The features of remove color,replace color,add text to image and create a new cross stitch pattern using the dmc colors specified by the user.
- After performing the cross stitch using UI a dmc index with symbol and color can be seen on the UI in the right side.

# DESIGN CHANGES
- I am passing the data from the controller to the view instead of model to view.
- I added another interface for the view to communicate with the controller.

# CHANGES from previous project
- The controller is passed a readable to read the batch commands and an appendable to store the log of operation.
- I added a new controller to handle the UI.
- I moved the read and write from the controller to the model.
- I also added the methods of remove dmc color,replace dmc color and read and write cross stitch pattern of both the user defined and all possible one.
- I added a view to the project.

## Limitations 
- My progam has only 8 values per channel color in dithering which are fixed.
- Only one transformation operation can be performed for one read of image.
- We need to specify the number of blocks for pixelation.
- Cross stitch pattern will not alter the original image.
- The dmc index will be displayed on the UI only after cross stitch is called from the UI and not the batch file.
- Replace dmc index will cause the original image to change as well.
- Update Dmc index and can be performed only on the UI and cannot be performed using batch commands.

## Description of runs
- The program can be run using the batch file as well as by a UI.
- The user will have two options and he can choice anyone as shown in "how to run a jar".
- The UI will be empty initially and after loading the image the image will display on the screen.
- On the top panel of the UI are menu options which the user can use to modify the image.
- It also contains a batch option to run batch commands.
- In add text menu option the user can specify the text and the color for the text.
- After the user selects cross stitch using the option a dmc index along with the pattern appears.

## Citations
- Effective Java, 3rd Editionby Joshua Block, 2018.  ISBN: 978-0134685991.
- The professor's code for image panel and scrollable picture.
- This images were taken by me and I am authorizing its use in this project.
