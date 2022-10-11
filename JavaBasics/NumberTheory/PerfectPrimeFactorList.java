package NumberTheory;

import java.util.Scanner;

public class PerfectPrimeFactorList {
    public static void main(String[] args) {

        //default upperBound = 100
        int upperBound = 100;
        System.out.print("Enter the upper bound: " + upperBound);
        /* validate input
        System.out.print("Enter the upper bound: ");
        Scanner sc = new Scanner(System.in);
        if ( !sc.hasNextInt()) {
            System.out.println("Upper bound not valid.");
            return;
        }
        int upperBound = sc.nextInt();
         */

        printPerfectPrimeFactors(upperBound);
    }

    public static boolean isProductOfPrimeFactors(int aPosInt) {
        int product = 1;
        for (int i = 2; i <= aPosInt / 2; i++) {
            if (isPrime(i) && (aPosInt % i == 0)) {
                product *= i;
            }
        }
        return product == aPosInt;
    }

    public static boolean isPrime(int aPosInt) {
        if (aPosInt <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(aPosInt); i++) {
            if (aPosInt % i == 0)
                return false;
        }
        return true;
    }

    public static void printPerfectPrimeFactors(int upperBound) {
        System.out.println("These numbers are equal to the product of prime factors: ");

        int cntProductPrimeFactors = 0;
        for (int i = 1; i <= upperBound; i++) {
            if (isProductOfPrimeFactors(i)) {
                System.out.print(i + " ");
                cntProductPrimeFactors++;
            }
        }
        System.out.printf("\n[%1$d numbers found (%2$.2f%%)]\n"
                , cntProductPrimeFactors, ((double) 100 * cntProductPrimeFactors / upperBound));
    }
}
