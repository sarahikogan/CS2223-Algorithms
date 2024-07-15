import java.util.*;

public class easyinversioncount {

    public static void main(String args[]) {

        // naive O(n^2) sorting algorithm that counts inversions in array A 

        // take in array
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an array separated by commas: ");

        String arrString = s.nextLine(); 
        String[] arrString2 = arrString.split(",");
        int[] arr = new int[arrString2.length];

        // get numbers out of array
        for (int i=0; i<arrString2.length; i++) {
            arr[i] = Integer.parseInt(arrString2[i]);
        }

        LinkedList<String> storeInversions = new LinkedList<String>();
        int[] tempInversion = new int[2]; 

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {

                if ((i < j) && (arr[i] > arr[j])) {
                    tempInversion[0] = arr[i];
                    tempInversion[1] = arr[j];
                    storeInversions.add("(" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }

        // print list
        for (int i=0; i<storeInversions.size(); i++) {
            System.out.println(storeInversions.get(i));
        } 

        // print inversion count
        System.out.println("Inversions: " + storeInversions.size());
    }
}