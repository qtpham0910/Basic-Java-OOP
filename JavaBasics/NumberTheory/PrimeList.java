package NumberTheory;

import java.util.Scanner;

public class PrimeList {
    public static void main(String[] args) {

        // default upper bound = 10000
        int upperBound = 10000;
        System.out.println("Enter the upper bound: " + upperBound);

        /* Validate input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the upper bound: ");

        if ( ! sc.hasNextInt()) {
            System.out.println("Upper bound invalid.");
            return;
        }
        int upperBound = sc.nextInt();

         */

        printPrimeList(upperBound);
    }

    public static boolean isPrime(int aPosInt){
        if(aPosInt <= 1)
            return false;

        for(int i = 2; i <= Math.sqrt(aPosInt); i++){
            if(aPosInt % i == 0)
                return false;
        }
        return true;
    }

    public static void printPrimeList(int upperBound){
        int cntPrime = 0;
        for(int i = 1; i <= upperBound; i++){
            if(isPrime(i)) {
                System.out.println(i);
                cntPrime++;
            }
        }
        System.out.printf("\n[%1$d primes found (%2$.2f%%)]",
                cntPrime, (double)100 * cntPrime/upperBound);
    }
}
