JUNIT = ./junit.jar
HAMCREST = ./hamcrest-core.jar
JUNITCORE = org.junit.runner.JUnitCore

INPUT = input.txt
CLASS = MartianRobots
TESTS = MartianRobotsTests

all :
	javac *.java -cp .:$(JUNIT)

run : 
	java $(CLASS) $(INPUT)

runtests :
	java -cp .:$(JUNIT):$(HAMCREST) $(JUNITCORE) $(TESTS)

clean :
	rm *.class