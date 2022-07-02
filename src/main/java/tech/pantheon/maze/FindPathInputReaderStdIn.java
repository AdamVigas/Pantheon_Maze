package tech.pantheon.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{


    private char [][] field;
    protected void findPath() {
        try{
            List<String> list = new ArrayList<>();
            int rows = 0;
            String line = "";
            Scanner stdIn = new Scanner(System.in);
            while(stdIn.hasNextLine()) {
                rows++;
                line = stdIn.nextLine();
                list.add(line);
            }
            int cols = line.length();
            field = new char[rows][cols];
            for(int i = 0; i < rows; i++){
                line = list.get(i);
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
