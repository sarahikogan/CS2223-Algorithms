import java.util.Scanner;

class graycodes {
    public static void main(String args[]) {

        System.out.println("Enter the number to convert into a gray code: ");
        Scanner input = new Scanner(System.in);

        int og = input.nextInt();

        input.close();

        // convert to binary
        String ogString = Integer.toBinaryString(og);

        // convert to array
        char[] ogArr = ogString.toCharArray();
        int[] newArr = new int[ogString.length()];

        // check each array item against the previous
        for (int i=1; i<ogArr.length; i++) {
            newArr[i-1] = (ogArr[i] == ogArr[i-1]) ? 0 : 1;
        }

        for (int i=0; i<newArr.length; i++) {
            System.out.print(newArr[i]);
        }
        System.out.println();
    }
}

