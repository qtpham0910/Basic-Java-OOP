import java.util.Scanner;

public class MagicSum {

    public static void main(String[] args) {
        MagicSum aMagicSumOfEight = new MagicSum();
        aMagicSumOfEight.run();
    }
    public static boolean hasEight(int number) {
        int remainder;
        while (number > 0) {
            remainder = number % 10;
            if (remainder != 8) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        final int SENTINEL = -1;
        int sum = 0;
        int number;

        System.out.print("Enter a positive integer (or −1 to end): ");
        number = sc.nextInt();

        while(number != SENTINEL) {
            if (hasEight(number))
                sum += number;

            System.out.print("Enter a positive integer (or −1 to end): ");
            number = sc.nextInt();

        }
        sc.close();
        System.out.println("The magic sum is " + sum);
    }


}
