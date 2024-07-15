import java.util.*; 
import java.io.*; 

public class hash {

    public static void main(String[] args) {
        File f = new File("EdgarAllanPoeBellsB2022groomed.txt");
        Scanner s = new Scanner(f);

        // Hashtable<Integer, String> hash = new Hashtable<Integer, String>(293); 

        try {

            while (s.hasNextLine()) {

                int hashed; 

                // get next line 
                String input = s.nextLine(); 

                // separate it by spaces 
                String[] inputs = input.split(" ");

                // go through each word
                for (int i=0; i<inputs.length; i++) {
                    hashed = hashCode(inputs[i]);
                    System.out.println(inputs[i] + " " + hashed);
                }



            }

            s.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); 
        }
    }

    public static int hashCode(String s) {

        // h: computed hash value
        // s: length of word
        // ci: ith character of the word
        // ord(c): ascii of ci
        // C: constant larger than ord(ci)
        // m: modulus

        int h = 0; 

        for (int i=0; i<s.length()-1; i++) {
            char c = s.charAt(i);
            h = ( h*123 + (int) c ) % 293; 
        }

        return h; 
    }
}