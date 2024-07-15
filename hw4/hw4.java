import java.util.*; 
import java.io.*; 

public class hw4 {

    static int[][] vault = new int[][] {
        {35, 89, 52, 66, 82, 20, 95, 21},
        {79,  5, 14, 23, 78, 37, 40, 74},
        {32, 59, 17, 25, 31,  4, 16, 63}, 
        {91, 11, 77, 48, 13, 71, 92, 15},
        {56, 70, 47, 64, 22, 88, 67, 12},
        {83, 97, 94, 27, 65, 51, 30,  7},
        {10, 41,  1, 86, 46, 24, 53, 93},
        {96, 33, 44, 98, 75, 68, 99, 84},
    };

    static String[][] vaultMap = new String[8][8];

    public static void main(String[] args) {

        // 1. choose highest starting square from row 1 
        int curr = 0;
        int sum = 0; 

        for (int i=0; i<8; i++) {                           // get highest index
            if (vault[0][i] > vault[0][curr]) {
                curr = i;
            }
        }

        // outputs
        System.out.println("Starting square: " + curr);     // starting square
        updateMap(7, curr);                       // update the map

        sum += vault[0][curr];                                        // update sum

        // 2. Decide the best path from the given options 

        // possible indices: one before, one in front, one after 
        // standing at the current, get the values for the left, front, and right (if they exist)

        /*
         * set curr to the current index
         * check the left, right, and center of the next row and find the highest 
         *      complete the processes for the max: 
         *      update curr
         *      update the map
         *      update the sum
         * 
         * update curr 
         * repeat
         */

        for (int row=1; row<8; row++) {
            int checkCurr = highestIndex(row, curr);        // get new highest index
            curr = checkCurr;                               // set curr
            updateMap(7-row, curr);                         // update map
            sum += vault[row][curr];                        // update sum
        }

        // final answer
        System.out.println("\n------- Vault Exit -------");
        printMap(vaultMap);
        System.out.println("--------------------------\n 1  2  3  4  5  6  7  8  ");
        System.out.println("----- Vault Entrance -----\n");
        System.out.println("Total gems collected: " + sum);
        System.out.println("ARKENSTONE FOUND! (In vault " + (curr+1) + ")");
        



    }

    public static void updateMap(int row, int index) {
        for (int i=0; i<8; i++) {
            if (i == index) {
                vaultMap[row][i] = Integer.toString(vault[7-row][i]);
            } else {
                vaultMap[row][i] = "   ";
            }
        }
    }

    public static void printMap(String[][] map) {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                System.out.print(map[i][j]); 
            }
            System.out.println(); 
        }
    }



    public static int highestIndex(int row, int curr) {
        int ind; 

        // get left, right, front of next row
        int left = (curr == 0 ? 0 : curr - 1);           // if we're at the left wall, keep left the same
        int front = curr;                                // stay at current index
        int right = (curr == 7 ? 7 : curr + 1);          // if we're at the right wall, keep right the same

       // System.out.println("Indices: ");
       // System.out.println("Left: " + left + " \nFront: " + front + " \nRight: " + right);

        ind = (vault[row][left] > vault[row][front] ? left : front);        // compare left and front
        ind = (vault[row][ind] > vault[row][right] ? ind : right);          // compare max and right

        // System.out.println("Highest index now: " + ind);
        return ind; 
    }

}
