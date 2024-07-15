import java.util.*;

public class palindromecheck {

    public static void main(String[] args) {

        // inits
        System.out.println("Enter a phrase to check if it's a palindrome:");
        Scanner getPhrase = new Scanner(System.in);
        String phrase = getPhrase.nextLine();
        getPhrase.close();

        // case, punctuation, space insensitivity

        phrase = phrase.replaceAll("[^a-zA-Z0-9]+", "");
        phrase = phrase.toLowerCase();

        // reverse array

        String reversedPhrase = ""; 

        for (int i=phrase.length()-1; i>-1; i--) {
            reversedPhrase += phrase.charAt(i);
        }

        // check if they're equal

        if (phrase.equals(reversedPhrase)) {
            System.out.println("This is a palindrome!");
        } else {
            System.out.println("This is not a palindrome!");
        }
    }
}