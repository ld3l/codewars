import java.util.Arrays;

//###TASK###
//Description:
//Kate constantly finds herself in some kind of a maze. Help her to find a way out!.
//
//For a given maze and Kate's position find if there is a way out. Your function should return True or False.
//
//Each maze is defined as a list of strings, where each char stays for a single maze "cell". ' ' (space) can be stepped on, '#' means wall and 'k' stays for Kate's starting position. Note that the maze may not always be square or even rectangular.
//
//Kate can move left, up, right or down only.
//
//There should be only one Kate in a maze. In any other case you have to throw an exception.
//
//Example input
//['# ##',
//'# k#',
//'####']
//Example output
//True
//
//Example input
//['####'.
//'# k#',
//'####']
//Example output
//False

public class Maze {
    public static boolean hasExit(String[] maze) {
        int w = Arrays.stream(maze).mapToInt(String::length).max().orElseThrow(RuntimeException::new);
        boolean[][] wasHere = new boolean[maze.length][w];
        int x = -1;
        int y = -1;
        for (int i = 0; i < maze.length; i++) {
            String s = maze[i];
            if (s.contains("k")) {
                if (x == -1) {
                    x = i;
                    y = s.indexOf("k");
                    if (s.indexOf("k", y + 1) != -1) throw new RuntimeException();
                } else throw new RuntimeException();
            }
        }

        String[] fixMaze = new String[maze.length];
        for (int i = 0; i < maze.length; i++) {
            String s = maze[i];
            fixMaze[i] = "";
            for (int j = 0; j < w; j++) {
                fixMaze[i] += j < s.length() ? s.charAt(j) : " ";
            }
        }


        if (x == -1) throw new RuntimeException();
        return r(fixMaze, x, y, wasHere);
    }

    public static boolean r(String[] maze, int x, int y, boolean[][] wasHere) {
        if (x >= wasHere.length || y >= maze[x].length()) return false;
        if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[x].length() - 1) {
            if (maze[x].charAt(y) != '#')
                return true;
        }


        if (maze[x].charAt(y) != '#' && !wasHere[x][y]) {
            wasHere[x][y] = true;
            return r(maze, x + 1, y, wasHere) || r(maze, x - 1, y, wasHere) || r(maze, x, y + 1, wasHere) || r(maze, x, y - 1, wasHere);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasExit(new String[]{"########",
                "# # ####",
                "# #k#   ",
                "# # # ##",
                "# # # ##",
                "#      #",
                "########"}));
        System.out.println(hasExit(new String[]
                {"#########",
                        "#k        #",
                        "###########"}));
    }

}