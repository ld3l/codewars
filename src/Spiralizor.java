//###TASK###
//Your task, is to create a NxN spiral with a given size.
//For example, spiral with size 5 should look like this:
//
//        00000
//        ....0
//        000.0
//        0...0
//        00000
//and with the size 10:
//
//        0000000000
//        .........0
//        00000000.0
//        0......0.0
//        0.0000.0.0
//        0.0..0.0.0
//        0.0....0.0
//        0.000000.0
//        0........0
//        0000000000
//Return value should contain array of arrays, of 0 and 1, for example for given size 5 result should be:
//[[1,1,1,1,1],[0,0,0,0,1],[1,1,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//Because of the edge-cases for tiny spirals, the size will be at least 5.
//General rule-of-a-thumb is, that the snake made with '1' cannot touch to itself.
public class Spiralizor {

    public static int[][] spiralize(int size) {
        int[][] spiral = new int[size][size];
        int minCol = 0;
        int maxCol = size-1;
        int minRow = 0;
        int maxRow = size-1;
        while (minRow <= maxRow){
            for (int i = minCol; i <= maxCol; i++) spiral[minRow][i] = 1;

            for (int i = minRow; i <= maxRow; i++) spiral[i][maxCol] = 1;

            if(minCol != 0) minCol+=1;
            if(maxRow-1 == minRow) break;

            for (int i = maxCol-1; i >= minCol; i--) spiral[maxRow][i] = 1;

            for (int i = maxRow-1; i >= minRow+2; i--) spiral[i][minCol] = 1;

            minCol+=1;
            minRow+=2;
            maxCol-=2;
            maxRow-=2;
        }
        return spiral;
    }

    public static void main(String[] args) {
        printArr(spiralize(10));
    }

    static void printArr(int[][] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1) {
                    System.out.print("*");
                } else System.out.print(".");
            }
            System.out.println();
        }
    }


}
