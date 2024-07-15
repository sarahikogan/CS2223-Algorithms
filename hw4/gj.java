import java.util.*; 
import java.io.*; 

public class gj {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 4,-3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 3,-2, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1,-1, 0, 0, 0},
            {1,-1, 1,-1, 1,-1, 1,-1, 1,-1, 1,-1, 0},
        }; 

        int[] b = {364, 4, 16, 36, 64, 100, 79, 61, 0, 0, 0, -42};

        betterForwardElimination(matrix, b);
    }

    public static int[][] betterForwardElimination(int[][] m, int[] b) {

        int n = b.length; 

        for (int i=1; i<n; i++) {
            m[i][n] = b[i];                                // appends b to A as the last column
        }

        for (int i=1; i<n-1; i++) {
            int pivotrow = i; 
            for (int j=i+1; j<n; j++) {
                if (Math.abs(m[j][i]) > Math.abs(m[pivotrow][i])) {           
                    pivotrow = j; 
                }
            }
            for (int k=i; k<n+1; k++) {
                int temp = m[i][k];
                m[i][k] = m[pivotrow][k];
                m[pivotrow][k] = temp; 
            }
            for (int j=i+1; j<n; j++) {
                int temp = m[j][i] / (m[i][i] > 0 ? m[i][i] : 1); 
                for (int k=i; k<n+1; k++) {
                    m[j][k] = m[j][k] - m[i][k] * temp; 
                }
            }
        }
        printMatrix(m); 
        return m; 
    }

    public static void printMatrix(int[][] m) {
        for (int i=0; i<12; i++) {
            for (int j=0; j<13; j++) {
                System.out.print(String.format("%4d", m[i][j]));
            }
            System.out.println(); 
        }
    }
}