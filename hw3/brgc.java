import java.util.*;

class hw3 {

    public static void main(String[] args) {

        // brgc(n) algorithm

        System.out.println("Enter a positive integer n: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        brgc(n);
        

    }

    // generates recursively the binary reflected Gray code of order n
    // input: a positive integer n
    // output: a list of all bit strings of length n composing the Gray code

    LinkedList<Integer> graycode(int n) {

        LinkedList L = new LinkedList<Integer>();

        // base case
        if (n == 1) {
            // make list L containing bit strings 0 and 1 in this order
            L.add(0);
            L.add(1);
        } else {
            // new list 1 
            LinkedList L1 = brgc(n - 1);
            // new list 2
            LinkedList L2 = new LinkedList<Integer>(); 
            for (int i=L.size() - 1; i>0; i--) {
                L2.add(i);
            }

            printLL(L2);

            
        }



        return L; 


    }

    void printLL(LinkedList<Integer> ll) {
        for (int i=0; i<ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
        System.out.println(); 
    }

}