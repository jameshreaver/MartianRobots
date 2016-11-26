import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MartianRobotsTests {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @Test
    public void givenTestCase() throws IOException {
        String expectedOutput = runTest("givenTestCase");
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testMoveForward() throws IOException {
        String expectedOutput = runTest("testMoveForward");
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testTurnLeft() throws IOException {
        String expectedOutput = runTest("testTurnLeft");
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testTurnRight() throws IOException {
        String expectedOutput = runTest("testTurnRight");
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testScentTrace() throws IOException {
        String expectedOutput = runTest("testScentTrace");
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testMultipleRobots() throws IOException {
        String expectedOutput = runTest("testMultipleRobots");
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void inputFileNotProvided() throws IOException {
        String[] args = {};
        MartianRobots.main(args);
        assertEquals("Provide input file.", err.toString());

    }

    @Test
    public void inputFileNotFound() throws IOException {
        String[] args = {""};
        MartianRobots.main(args);
        assertEquals(" (No such file or directory)", err.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    private String runTest(String testName) {
        String input = "testInputs/" + testName + "In.txt";
        String output = "testOutputs/" + testName + "Out.txt";
        String[] args = {input};
        MartianRobots.main(args);
        try {
            byte[] outputFile = Files.readAllBytes(Paths.get(output));
            return new String(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}