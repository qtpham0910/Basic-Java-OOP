import java.io.*;
import java.util.*;

public class WordGuess {

    //location of text file
    static File filePath = new File("src/english.txt");

    public static void main(String[] args ){

        String word = WordPrepare(filePath);
        WordGuess aWordToGuess = new WordGuess();
        aWordToGuess.guessWord(word);
    }
    private void guessWord(String word){
//        System.out.println(word);
        Scanner sc = new Scanner(System.in);
        Boolean[] keyArray = new Boolean[word.length()];
        Arrays.fill(keyArray,false);
        int quit = 0;
        int count = 0;
        System.out.println("Guess a word with " + word.length() + " letter(s)\tor\t-1 to quit");

        while(true){

            System.out.print("Key in one character or your guess word: ");
            String guess = sc.next();
            count++;
            //fix case word.length == 1
            if(guess.equals(word)){
                break;
            }

            if(guess.equals("-1")){
                quit = 1;
                break;
            }
            if(guess.length() == 1){
                    System.out.println("Trial " + count + ":");
                    for(int i = 0; i < word.length(); i++){
                        if((guess.charAt(0)) == (word.charAt(i)) || keyArray[i]) {
                            keyArray[i] = true;
                            System.out.print(word.charAt(i));
                        }
                        else {
                            System.out.print("_");
                        }
                    }
                    System.out.println();

            }
            else {
                System.out.println("Trial " + count + ":");
                for(int i = 0; i < word.length(); i++) {
                    if (keyArray[i]) {
                        System.out.print(word.charAt(i));
                    } else {
                        System.out.print("_");
                         }
                    }
                System.out.println();
            }

            int chk = 0;
            for(Boolean key : keyArray){
                if(key) ++chk;

            }
            if(chk == word.length())
                break;
        }
        if(quit == 0)
           System.out.println("Congratulation ! \nYou got it in " + count + " trial(s)");
        else
            System.out.println("Quit!\nThe answer is " + word);
    }
    private static String WordPrepare(File filePath) {
 //       File filePath = new File("src/english.txt");
        int i = 0;
        String[] array = new String[84096];
        try (FileInputStream input = new FileInputStream(filePath);
             Scanner sc = new Scanner(input, "UTF-8")) {

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                array[i] = data;
                i++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return array[(int) (Math.random() * i) - 1];
    }

}
