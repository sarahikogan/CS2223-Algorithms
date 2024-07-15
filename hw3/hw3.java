import java.util.*;
import java.lang.Math; 

class graycodesarefun {

    public static void main(String[] args) {

        // brgc(n) algorithm

        System.out.println("Enter a positive integer n: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        LinkedList<String> output = brgc(n);

        getOrder(output);

        printTable(output); 
        
        s.close();

    }

    // PART 1: GENERATE LIST

    // generates recursively the binary reflected Gray code of order n
    // input: a positive integer n
    // output: a list of all bit strings of length n composing the Gray code

    public static LinkedList<String> brgc(int n) {

        LinkedList<String> L = new LinkedList<String>(); 

            // base case 
        if (n == 1) { 
            L.add("0");
            L.add("1");
            return L; 


        } else {

            // generate L1 
            LinkedList<String> L1 = brgc(n - 1);

            // generate L2 as L1 reversed
            LinkedList<String> L2 = new LinkedList<String>(); 

            for (int i=L1.size()-1; i>=0; i--) {
                L2.add(L1.get(i));
            }

            String temp;

            // add 0 in front of each L1 
            for (int i=0; i<L1.size(); i++) {
                temp = "0" + L1.get(i);
                L1.set(i, temp);  
            }

            // add 1 in front of each L2
            for (int i=0; i<L2.size(); i++) {
                temp = "1" + L2.get(i);
                L2.set(i, temp);  
            }

            // add L2 to L1 
            LinkedList<String> fullL = L1;
            for (int i=0; i<L2.size(); i++) {
                fullL.add(L2.get(i));
            }

            L = fullL;
    
        }

        return L; 
    }

    // PART 2: DETERMINE WHICH CHILD MOVES AND WHEN

    public static LinkedList<String> getOrder(LinkedList<String> gclist) {

        LinkedList<String> directions = new LinkedList<String>();

        // subtract item from the one before it to get the place of the moved one

        

        for (int i=1; i<gclist.size(); i++) {

            int temp; 
            String tempDirection = ""; 
            // System.out.println(gclist.get(i));
            temp = Integer.parseInt(gclist.get(i)) - Integer.parseInt(gclist.get(i - 1)); // determine place value of change 
            
            int absTemp = Math.abs(temp);

            switch(absTemp) {
                case 1: 
                    tempDirection +=  "Alice";
                    break; 
                case 10: 
                    tempDirection += "Bob";
                    break; 
                case 100: 
                    tempDirection += "Chris";
                    break; 
                case 1000: 
                    tempDirection += "Dylan";
                    break; 
                default: 
                    System.out.println("Didn't work!");         
            }

            if (temp > 0) {
                tempDirection += " In"; 
            } else {
                tempDirection += " Out";
            }

            directions.add(tempDirection);
        }
        return directions; 
    }

    public static String getNamesIn(String output) {
        char[] digits = output.toCharArray(); 
        String names = ""; 

        if (digits[0] == '1') { names += "David "; }; 
        if (digits[1] == '1') { names += "Chris "; };
        if (digits[2] == '1') { names += "Bob "; }; 
        if (digits[3] == '1') { names += "Alice "; };

        return names; 
    }

    public static void printTable(LinkedList<String> output) {

        LinkedList<String> names = getOrder(output);

        System.out.println("Index      Gray Code             Children in Photo           Action");
        System.out.println("-------------------------------------------------------------------");
        for (int i=0; i<output.size()-1; i++) {
            System.out.printf("%4d %15s %30s %15s", i, output.get(i), getNamesIn(output.get(i)), names.get(i));
            System.out.println();
        }

    }

    public static void printLL(LinkedList<String> ll) {
        for (int i=0; i<ll.size(); i++) {
            System.out.print(ll.get(i));
        }
        System.out.println(); 
    }

}