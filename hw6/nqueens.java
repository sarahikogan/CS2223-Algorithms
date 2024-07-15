import java.util.*; 
import java.io.*; 

public class nqueens {
    
    public static void main(String[] args) {

        int[] b = {1, 6, 8, 3, 7, 4, 2, 5};

        // take in the starting board

        isLegalPosition(b, 8);
        
        // add the next queen 

        // check if it's legal
            // if not, keep moving the queen down the line until it is 

        // 
        
    }

    public static boolean isLegalPosition(int[] board, int n) {

        int[][] b = readInBoard(board);

        // check columns

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if ((board[i] == board[j]) && (board[i] != 0)) {
                    System.out.println("Column similarity found: " + board[i]); 
                    return false; 
                }
            }
        }

        // check diagonals
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=-n; k<n; k++) {
                    if (b[(i+Math.abs(k))][j+k] == b[i][j]) {
                        System.out.println("Diagonal found: " + b[i][j] + " at " + k);
                        return false; 
                    }
                }
            }
        }

        // no need to check rows since the program implements that already
        return true; 
    }
    
    public static int[][] readInBoard(int[] board) {
        int[][] tboard = new int[board.length][board.length];

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (j+1 == board[i]) {
                    tboard[i][j] = board[i]; 
                } else {
                    tboard[i][j] = 0; 
                }
                System.out.print("[" + tboard[i][j] + "]");
            }
            System.out.println(); 
        }

        return tboard; 
    }

}
