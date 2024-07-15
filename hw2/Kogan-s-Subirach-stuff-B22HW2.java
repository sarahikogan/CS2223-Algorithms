import java.util.*;

class subirach {


    static int countFours = 0; 

    static Scanner s = new Scanner(System.in);


    static int[] subirach = {  1, 14, 14,  4, 
                              11,  7,  6,  9, 
                               8, 10, 10,  5, 
                              13,  2,  3, 15};

    static int count = 0;
    static LinkedList<String> combos = new LinkedList<String>();

    public static void main(String[] args) {

        int print = 0;              // check whether to print all combinations
        System.out.println("Would you like to print all combinations? (Yes (1) or No (0)):");
        if (s.nextInt() == 1) {print = 1; };

        // PART 1: 4 ELEMENTS

        int data33[] = new int[4];

        getSubsets(4, 33, 0, data33, 0);      // get subsets for length 4, sum 33

        System.out.println("There are " + count + " combinations of 4 numbers that add up to 33.");
        if (print == 1) { printCombos(combos); };

        System.out.println("----------------");

        // reset count and combos
        count = 0;
        combos.clear();

        // PART 2: ANY NUMBER OF ELEMENTS 

        int sumCount = 0;                   // count total sum

        System.out.println("These combinations add to 33:");

        for (int i=0; i<16; i++) {          // go through each possible size
            int data[] = new int[i];        // create temp array with length needed
            getSubsets(i, 33, 0, data, 0);
            System.out.println(count + "\t combos of \t" + i);
            sumCount += count;
            count = 0;
        }
        
        System.out.println("There are " + sumCount + " total combinations that add to 33.");

        System.out.println("----------------");
        // reset count and combos
        count = 0;
        combos.clear();

        // PART 3: HOW MANY WAYS CAN EVERY SUM BE FORMED? 

        sumCount = 0;

        for (int sum=0; sum<=132; sum++) {        // go through each possible sum
            for (int size=0; size<16; size++) {     // go through each possible size

                int data[] = new int[size];        // create temp array with length needed
                getSubsets(size, sum, 0, data, 0);

            }
            System.out.println(sum + "\t occurs \t" + count + " times.");
                sumCount += count;
                count = 0;
        }

        System.out.println("The most popular number is 66, which is 33*2.");
    }

    /*
     * static void getSubsets(int length, int sum, int ind, int[] temp, int last, int count, LinkedList<String> combos)
     * gets all the subsets where the sum equals sum, recursively
     * length: amt of elts in each subset
     * sum: desired sum
     * ind: current index
     * temp[]: store code temporarily
     * last: last element
     * count: number of elements in the list
     * combos: stores combinations
     */

    static void getSubsets(int length, int sum, int ind, int[] temp, int last) {

        if (ind == length) {            // index is the required length: iteration complete. Print and check!
            if (checkSum(temp) == sum) {
                combos.add(getArr(temp));
                count++;
            }
        return;
        }

        if (last >= 16) { return; };                // no more combinations left to make. end loop

        temp[ind] = subirach[last];                      // set temp to next location

        // recursive! next index: 
        getSubsets(length, sum, ind+1, temp, last+1);
        // same index: 
        getSubsets(length, sum, ind, temp, last+1);

    }

    /*
     * int permutationSum(int[] items)
     * Returns the sum of the given array, using the subirach square
     */
    public static int checkSum(int[] items) {

        int sum = 0;

        for (int i=0; i<items.length; i++) {
            sum += items[i];
        }

        return sum;
    }

    public static String getArr(int[] arr) {
        String temp = ""; 
        for (int i=0; i<arr.length; i++) {
            temp += arr[i] + " ";
        }
        return temp;
    }

    public static void printCombos(LinkedList<String> combos) {
        for (int i=0; i<combos.size(); i++) {
            System.out.println(combos.get(i));
        }
    }
    
};
