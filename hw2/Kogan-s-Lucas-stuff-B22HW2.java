import java.util.Scanner;

public class lucas {

    public static void main(String[] args) {

        System.out.println("Enter a number: ");
        Scanner numScanner = new Scanner(System.in);

        int n = numScanner.nextInt();

        // LUCAS

        System.out.println("Lucas Numbers:");      

        long startTime = System.currentTimeMillis();           // get start time

        for (int i=0; i<n; i++) {                              // print every number until n-1 with comma
            System.out.print(lucas(i) + ", ");
        }
        System.out.println(lucas(n));

        long endTime = System.currentTimeMillis();   

        long totalTime = endTime - startTime;

        System.out.println("\nRuntime for Lucas numbers:\n" + totalTime);

        // CUSTOM LUCAS

        System.out.println("Custom Lucas Numbers:");      

        startTime = System.currentTimeMillis();                // get start time

        for (int i=0; i<n; i++) {                              // print every number until n-1 with comma
            System.out.print(customLucas(i) + ", ");
        }
        System.out.println(customLucas(n));

        long endTime = System.currentTimeMillis();   

        long totalTime = endTime - startTime;

        System.out.println("\nRuntime for Custom Lucas numbers:\n" + totalTime);

        // RATIOS

        getCalculationTime(n);





        numScanner.close();

    }

    /*
     * int lucas(int num)
     * takes in user's input
     * recursively returns lucas numbers
     */

    public static int lucas(int num) {

        if (num == 0) return 2;
        if (num == 1) return 1; 
        return lucas(num - 1) + lucas(num - 2);
    }

    /*
     * int customLucas(int num)
     * takes in user's input
     * recursively returns custom lucas numbers with changed bases
     */


    public static int customLucas(int num) {
        if (num == 0) return 19; 
        if (num == 1) return 9; 
        return customLucas(num - 1) + customLucas(num - 2);
    }

    /*
     * void printEndTime(long startTime)
     * takes in start time
     * gets end time from start time
     */

    public static void printEndTime(long startTime) {

        long endTime = System.currentTimeMillis();   

        long totalTime = endTime - startTime;

        System.out.println("\nRuntime for Lucas numbers:\n" + totalTime);
    }

    /*
     * int getCalculationTime(int num)
     * takes in a number of calculations 
     * outputs the ratio of calculations (lucas(num+1))/(lucas(num))
     */

     public static int getCalcRatio(int num) {

        return ((lucas(num + 1)) / (lucas(num)));

    }

}
