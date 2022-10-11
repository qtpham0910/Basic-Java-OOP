package NumberTheory;

import java.util.Scanner;

public class PerfectNumberList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //default upper bound = 1000
        int upperBound = 1000;
        System.out.println("Enter the upper bound: " + upperBound );

    /* input and validate input for upper bound

        System.out.print("Enter the upper bound: ");

        if ( ! sc.hasNextInt()) {
            System.out.println("Upper bound invalid.");
            return;
        }
        int upperBound = sc.nextInt();

        if (upperBound < 0) {
            System.out.println("Upper bound is not positive.");
            return;
        }

    done validate */

        printPerfectList(upperBound);
        printNotDeficientNorPerfect(upperBound);

    }

    public static boolean isPerfect(int aPosInt) {
        int divisorSum = 0;
        for (int i = 1; i <= aPosInt/2 ; i++) {
            if (aPosInt % i == 0)
                divisorSum += i;
        }
        return divisorSum == aPosInt;
    }

    public static boolean isDeficient(int aPosInt) {
        int divisorSum = 0;
        for (int i = 1; i <= aPosInt / 2 ; i++) {
            if (aPosInt % i == 0)
                divisorSum += i;
        }
        return divisorSum < aPosInt;
    }
    public static void printPerfectList(int upperBound){
        System.out.println("These numbers are perfect:");
        int cntPerfectNum = 0;
        for (int i = 1; i <= upperBound; i++) {
            if ( !isPerfect(i)) {
                continue;
            }
            System.out.printf("%d ", i);
            cntPerfectNum++;
        }
        System.out.printf("\n[%1$d perfect numbers found (%2$.2f%%)]\n",
                cntPerfectNum, ((double)100 * cntPerfectNum/upperBound));

        System.out.println();
    }
    public static void printNotDeficientNorPerfect(int upperBound){
        System.out.println("These numbers are neither deficient nor perfect:");
        int cntDeficientNum = 0;
        for (int i = 1; i <= upperBound; i++) {
            if ( isDeficient(i) || isPerfect(i)) {
                continue;
            }
            System.out.printf("%d ", i);
            cntDeficientNum++;
        }
        System.out.printf("\n[%1$d numbers found (%2$.2f%%)]\n",
                cntDeficientNum, ((double)100 * cntDeficientNum/upperBound));
    }
}