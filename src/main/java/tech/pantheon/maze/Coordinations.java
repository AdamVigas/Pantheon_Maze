package tech.pantheon.maze;

public class Coordinations {
    int x;
    int y;

    public void findStart(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length;j++) {
                if(maze[i][j] == 'S') {
                    setX(i);
                    setY(j);
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
