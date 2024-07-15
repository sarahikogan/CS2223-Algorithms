import java.io.*; 
import java.util.*;

public class table {
    
    public static void main(String[] args) {

        try {
            File f = new File("EdgarAllanPoeBellsB2022groomed.txt");
            Scanner s = new Scanner(f);

            Hashtable<Integer, String> hash = new Hashtable<Integer, String>(293); 
            ArrayList<Integer> codes = new ArrayList<Integer>(293); 
            for (int i : codes ) { codes.set(i,-1); };

            while (s.hasNextLine()) {
                String input = s.nextLine(); 
                String[] inputs = input.split(" "); 

                int h = 0; 

                for (int i=0; i<inputs.length; i++) {
                    h = hashCode(inputs[i]);

                    hash.put(h, inputs[i]);

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

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            h = ( h*123 + (int) c ) % 293; 
        }

        return h; 
    }

    public static void printHashTable(Hashtable h) {
        for (int i=0; i<h.size(); i++) {

            String s = (h.get(i) == null ? "" : (String) h.get(i));

            System.out.println(i + "    " + s + "   " + hashCode(s));
        }
    }
}