// import java.lang.Math;

public class Nim extends Board {


    //static int[] originalBoard;            // get the board from the original game
    public String[] binArr = new String[3];  // original board, converted into binary
    static int[] reducedBinArr = {0,0,0};    // binary board, reduced into 1s and 0s
    int removeNumber = 0;                    // number to remove, converted to decimal from reducedBinArr

    // Nim Constructor

    public Nim() {
        Board b1 = new Board();
    }; 

    public void NimMechanics() {

        // update board from the original game

        int[] originalBoard = {b1.getColor("green"), b1.getColor("yellow"), b1.getColor("orange")};

        // get originalBoard into binary 

        for (int i=0; i<3; i++) {
            binArr[i] = (Integer.toBinaryString(originalBoard[i]));       // get int from converting each item in the board to binary
            binArr[i] = String.format("%3s", binArr[i].replaceAll(" ","0"));    // put in 0s
        }

        // add each sum into reducedBinArr by place

        int[][] reducedMatrix = new int[3][3];


        for (int i=0; i<3; i++) {
            
            String[] tempArr = binArr[i].split("");
            
            for (int j=0; j<3; j++) {
                int tempInt = Integer.parseInt(tempArr[j]);      // turn each item to an integer

                reducedMatrix[i][j] = tempInt;
                System.out.print(reducedMatrix[i][j] + "   ");
            }
            System.out.println();
        }

    }





}