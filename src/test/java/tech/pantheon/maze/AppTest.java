package tech.pantheon.maze;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test(timeout = 5)
    public void fromFile() {
        FindPathInputReaderFile file = new FindPathInputReaderFile("input.txt");
        file.findPath();

        // Instance maze
        Maze m = new Maze();
        // sets maze from our file
        m.setMaze(file.getField());
        //checks size of our field
        m.checkSize();
        //recursion
        m.solve();
        assertTrue("Must return true if we found exit", m.found);
    }

    @Test(timeout = 5)
    public void fromStdInput() {
        // Prepared maze that should be set from standard input
        String userInput = String.format("....................................\n" +
                        "..S...#......................#......\n" +
                        "......#......................#......\n" +
                        ".............................#......\n" +
                        "....................................\n" +
                        "....................................\n" +
                        "..............#.....................\n" +
                        "............#.......................\n" +
                        "..........#.........................\n" +
                        "....................................\n" +
                        ".....................#..........#...\n" +
                        ".....................#....X.....#...\n" +
                        ".....................#..........#...\n" +
                        "....................................");

        // Get input from user
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        FindPathInputReaderStdIn stdIn = new FindPathInputReaderStdIn();
        stdIn.findPath();
        // Instance maze
        Maze m = new Maze();
        // sets maze from our file
        m.setMaze(stdIn.getField());
        //checks size of our field
        m.checkSize();
        //recursion
        m.solve();

        assertTrue("Must return true if we found exit", m.found);
    }



}