package hangman;
import java.util.Scanner;

public class HangmanGame {

    // all contributed
    public static void main(String[] args) {

        // creates variables
        Scanner sc = new Scanner(System.in);
        String word = Words.getRandomWord();
        String displayWord = wordToBlankLetters(word);
        char chosenChar;
        boolean decisionReached = false;
        boolean hasWon = false;
        int fails = 0;

        // introduction
        System.out.println("Let's play a game: ");
        System.out.println("I'm thinking of a word");
        // game loop
        while (decisionReached == false) {
            // display current information
            System.out.println(displayWord);
            // letter choose code
            System.out.println("Give me a letter");
            chosenChar = sc.next().charAt(0);
            if (Words.isLetterInWord(chosenChar, word)) {
                System.out.println("You have chosen right");
                displayWord = fillBlankLetters(chosenChar, word, displayWord);
            } else {
                System.out.println("You have chosen wrong and have gained a strike");
                fails++;
                System.out.println("You have " + fails + "/6 strikes");
            }
            // decide when game is won or lost
            if (Words.isLetterInWord('_', displayWord) == false) {
                decisionReached = true;
                hasWon = true;
                break;
            } else if (fails > 5) {
                decisionReached = true;
                hasWon = false;
                break;
            }
        }

        // code for when a decision is reached
        if (hasWon == true) {
            System.out.println(displayWord);
            System.out.println("Congratulations! You Won!");
        } else {
            System.out.println("You a big loser");
            System.out.println("The word was: " + word);
        }

    }

    // sanchit
    // method to display word as blank play letters
    public static String wordToBlankLetters(String word) {

        // variables
        String wordBlankLetters = "";

        // convert text
        for (char i: word.toCharArray()) {
            wordBlankLetters = wordBlankLetters + "_ ";
        }
        return wordBlankLetters;

    }

    // ryan
    // method to fill in blank letters
    public static String fillBlankLetters (char letter, String word, String displayWord) {

        // variables
        int howManyTimes = 0;
        int loopNumber = 0;
        int replaceIndex = 0;
        char[] originalString = displayWord.toCharArray();
        String replaceString = "";

        // set letter in
        for (int i = 0; i <= word.length() - 1; i++) {
            if (letter == word.toCharArray()[i]) {
                howManyTimes++;
            }
        }
        int[] finalIndexes = new int[howManyTimes];
        for (int i = 0; i <= word.length() - 1; i++) {
            if (letter == word.toCharArray()[i]) {
                finalIndexes[loopNumber] = i + 1;
                loopNumber++;
            }
        }
        for (int i = 0; i <= finalIndexes.length - 1; i++) {
            replaceIndex = ((finalIndexes[i] * 2) - 2);
            originalString[replaceIndex] = letter;
        }
        for (int i = 0; i <= originalString.length - 1; i++) {
            replaceString = replaceString + originalString[i];
        }
        return replaceString;

    }

}
