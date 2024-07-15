import java.util.Scanner; 
import java.util.Random; 
import java.util.LinkedList;

public class hw1 {

    public static LinkedList<Integer> board = new LinkedList<Integer>();
    public static LinkedList<String> boardColors = new LinkedList<String>();

     /************************** MAIN **************************/
    public static void main(String args[]) {

        initializeBoards(board, boardColors);

        Scanner fpScanner = new Scanner(System.in);     // create scanner

        System.out.println("Welcome to Double Trouble! \nIf you want to start, enter \"yes\"; otherwise, enter \"no\".");
        String fpString = fpScanner.nextLine(); 

        int fpInt = (fpString.equals("yes")) ? 0 : 1; // set the starting player (0: player starts, 1: computer starts)

        //runGame(fpInt);        // run the game

        fpScanner.close();
    }

    // initializeBoard();
    // enter all initial values into linkedList board 

    public static void initializeBoards(LinkedList<Integer> board, LinkedList<String> boardColors) {
        board.add(3);
        board.add(7);
        board.add(5);

        boardColors.add("green");
        boardColors.add("yellow");
        boardColors.add("orange");
    }

    // printBoard();
    // print out the current board 

    public static void printBoard() {
        for (int i=0; i < board.size(); i++) {
            System.out.print(boardColors.get(i) + " ");
            System.out.println(board.get(i));
        }
    }

    // runGame(int player);
    // takes in 0 for player starts, 1 for computer starts
    // runs the game
    
     
    public static void runGame(int player) {

        int currentPlayer = player;             // store the current player
        
        while (!checkWinner()) {                // until winner is found
            
            System.out.println("[][][][][][][][][][][][][][][][]");

            if (currentPlayer == 0) {           // player's turn

                System.out.println("Your turn!");
                // playerMechanics();

                currentPlayer = 1;              // switch sides
            
            } else {                            // computer's turn

                System.out.println("Computer's turn!");
               //  nimMechanics();

                currentPlayer = 0;              // switch sides
            }

            printBoard();
        }

        System.out.println("The winner is... ");
        System.out.println((currentPlayer == 1 ? "the computer! Better luck next time!" : "you! Great job!"));

    }

    public static void playerMechanics() {

        
    }


}