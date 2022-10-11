import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args){

        NumberGuess guessANumber = new NumberGuess();
        guessANumber.guessTheNumber();

    }

    public static void guessTheNumber(){
        Scanner sc = new Scanner(System.in);
        int trial = 1;
        final int SECRETNUMBER = (int)(Math.random() * 100);
        System.out.println("Key your guess: ");
        int guess = sc.nextInt();
        while(guess != SECRETNUMBER){
            if(guess > SECRETNUMBER) {
                System.out.println("Try lower");
            }
            if(guess < SECRETNUMBER) {
                System.out.println("Try higher");
            }
            ++trial;
            guess = sc.nextInt();
        }
        System.out.println("You got it in " + trial + " trials!");
    }

}
