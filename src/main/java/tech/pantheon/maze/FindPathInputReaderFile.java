package tech.pantheon.maze;

import java.io.*;
import java.util.Scanner;

public class FindPathInputReaderFile extends AbstractFindPathInputReader{

    private String filename;
    private char [][] field;
    public FindPathInputReaderFile(String filename) {
        this.filename = filename;
    }

    protected void findPath(){
        try{
            int rows = 0;
            String line = "";
            Scanner inFile = new Scanner(new File(this.filename));
            while(inFile.hasNextLine()) {
                rows++;
                line = inFile.nextLine();
            }

            int cols = line.length();
            inFile = new Scanner(new File(this.filename));
            // this will bring the scanner back to the start of the file

            field = new char[rows][cols];
            for(int i = 0; i < rows; i++){
                line = inFile.nextLine();
                for(int k = 0; k < cols; k++){
                    field[i][k] = line.charAt(k);
                }
            }
        }catch (Exception ex) {
            System.out.println("Couldnt find file.");
        }
    }

    public char[][] getField() {
        return field;
    }
}

