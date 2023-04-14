# Martian Robots

This is a coding exercise. It simulates the creation of Martian Robots on the surface of a planet, given as a rectangular grid. It then assigns them a series of instructions to move around said planet. Robots which move outside of the grid are lost, but they leave a trace behind so that other robots ignore instructions that would make them fall from the same position on the planet.

### Running Martian Robots

To run the program, clone the repository and compile the source files with the command:
```
make
```
Then you can run an example by executing:
```
make run
```
You can also run the tests with:
```
make runtests
```
When you are done, clean it all up with:
```
make clean
```

### More Information

The class MartianRobots contains the main function. This function takes a command line argument specifying the file with the instructions on how to create the Planet and the Robots. Here is an example of an input file.
```
2 2
1 1 E
FLFL

0 0 S
FFFFR
```

This instructs the program to create a grid of maximum coordinates 2 and 2 (meaning a 3x3 grid) and to spawn a robot in the middle at position (1, 1) on the grid, facing East. This robot is instructed to move Forward, turn Left, move Forward and turn Left again. We expect its final position to be (2, 2) facing West.
We then spawn another robot at position (0, 0), facing South. We instruct it to move Forward over the edge of the grid, meaning that this robot will get LOST.

Feeding this input to the program will yield the expected result:
```
2 2 W 
0 0 S LOST
```
##
This program was developed by James Reaver in November 2016 at Imperial College London. The code is provided without a licence and all the rights are reserved.
