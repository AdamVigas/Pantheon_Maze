package tech.pantheon.maze;

import java.util.Collections;

public class App {
    public static void main(String[] args) {



        //fromFile("input.txt");
        fromStdInput();

    }

    /**
     * Method reads input from file and solves the problem by finding route from S to X - route is not the shortest one
     * @param filename is name of our file, there is our maze
     */
    public static void fromFile(String filename) {
        // Read input from file
        FindPathInputReaderFile file = new FindPathInputReaderFile(filename);
        file.findPath();

        // Instance maze
        Maze m = new Maze();
        // sets maze from our file
        m.setMaze(file.getField());
        //checks size of our field
        m.checkSize();
        //recursion
        m.solve();
        // prints out maze with route
        System.out.println(m);
        // Our steps in arraylist
        Collections.reverse(m.steps);
        System.out.println(m.steps.toString());
    }

    /**
     * Method reads input from standard input and solves the problem by finding route from S to X - route is not the shortest one
     */

    public static void fromStdInput() {
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
        // prints out maze with route
        System.out.println(m);
        // Our steps in arraylist
        Collections.reverse(m.steps);
        System.out.println(m.steps.toString());
    }
}
