package tech.pantheon.maze;

import java.util.ArrayList;


public class Maze {
    private int sizeX;
    private int sizeY;

    public boolean found = false;
    ArrayList<String> steps = new ArrayList<>();
    public char[][] maze;


    public void solve() {
        Coordinations coord = new Coordinations();
        coord.findStart(maze);
        if (step(coord.getX(),coord.getY())) {
            maze[coord.getX()][coord.getY()] = 'S';
        }else System.out.println("Couldnt find exit.");
    }

    public void setMaze(char[][] maze) {
        this.maze = maze;
    }

    public void checkSize() {
        int i = 0;
        int j = 0;
        for (;i < maze.length;i++) {
            for (;j < maze[i].length;j++) {

            }
        }
        this.sizeX = i;
        this.sizeY = j;
    }

    // Backtracking method
    public boolean step (int x, int y) {

        /** Accept case - we found the exit **/
        if (maze[x][y] == 'X') {
            found = true;
            return true;
        }

        /** Reject case - we hit a wall or our path **/
        if (maze[x][y] == '#' || maze[x][y] == '*') {
            if(steps.size() != 0) {
                steps.remove(steps.size()-1);
            }
            return false;
        }

        /** Backtracking Step **/

        // Mark this location as part of our path
        maze[x][y] = '*';
        boolean result;

        // Try to go Right
        if(sizeY-1 > y) {
            result = step(x, y+1);
            if (result) {
                steps.add("r");
                return true;
            }
        }



        if(x > 0) {
            // Try to go Up
            result = step(x-1, y);
            if (result) {
                steps.add("u");
                return true;
            }
        }


        if(y > 0){
            // Try to go Left
            result = step(x, y-1);
            if (result) {
                steps.add("l");
                return true;
            }
        }

        if(sizeX-1 > x){
            // Try to go Down
            result = step(x+1, y);
            if (result) {
                steps.add("d");
                return true;
            }
        }

        /** Deadend - this location can't be part of the solution **/

        // Unmark this location
        maze[x][y] = '.';
        if(steps.size() != 0) {
            steps.remove(steps.size()-1);
        }
        // Go back
        return false;
    }

    public String toString() {
        String output = "";
        for (int x=0; x<sizeX; x++) {
            for (int y=0; y<sizeY; y++) {
                output += maze[x][y] + " ";
            }
            output += "\n";
        }
        return output;
    }





}
