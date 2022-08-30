package hangman;
import java.util.Random;

public class Words {

    // hayes
    // method to get a random word
   public static String getRandomWord() {

       // variables
       Random rand = new Random();
       int randomNum = 0;
       String randomWord = "";

       // get random word
       String[] wordList = {"mario", "chris", "pratt", "luigi", "sandwich", "motel", "water", "mcdonalds", "batman", "hulk", "balls", "cookie", "mexico", "crackers", "flag", "xavier", "supercalifragilisticexpialidocious", "kramar", "spider", "man", "feet", "dust", "poop", "obama", "duck", "godburn", "hayes", "harris", "ikea", "adidas", "soup", "nintendo", "pizza", "time", "fazbear", "minecraft", "friends", "office", "destroy", "build", "hangman", "enderman", "steve", "daddy", "papa", "quintana", "kirejczyk", "doppelkupplungsgetriebe", "yugioh", "pokemon", "magic", "ahhhhhhhhhhh", "joker", "mark", "hamill", "cheese", "kikanamada"};
       randomNum = rand.nextInt(wordList.length);
       randomWord = wordList[randomNum];
       return randomWord;

   }

   // sanchit
   // method to tell if a letter is in a word
   public static boolean isLetterInWord(char letter, String word) {

       // variables
       boolean isOrIsNot = false;

       // run letter through word
       for (char i: word.toCharArray()) {
            if (letter == i) {
                isOrIsNot = true;
            }
       }
       return  isOrIsNot;

   }

}
