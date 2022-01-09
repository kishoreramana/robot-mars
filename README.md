# robot-mars
A program to control the robot on martian surface

Mars Rover

Run in local mode

Run com.kishore.projects.mars.rover.Rover from your IDE. supply Robot position and instructions.
Run in Jar mode

Run mvn clean package or mvn clean install from the root directory of the project
Run java -jar target\project-mars-rover-1.0.0-SNAPSHOT.jar
INPUT

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.
Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.
OUTPUT

The output for each rover should be its final co-ordinates and heading.

INPUT AND OUTPUT

Test Input: 5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM

Expected Output: 1 3 N 5 1 E
