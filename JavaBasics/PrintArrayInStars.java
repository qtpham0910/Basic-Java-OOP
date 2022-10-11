import java.util.Scanner;

public class PrintArrayInStars {
    public static void main(String[] args) {
        final int NUMITEMS;
        int[] items;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of the items: ");
        NUMITEMS = sc.nextInt();
        sc.nextLine();
        items = new int[NUMITEMS];
        if (items.length > 0) {
            System.out.print("Enter the value of all items (separated by space): ");
            String strInput = sc.nextLine();
            String[] splitStr = strInput.split(" ");
            for (int i = 0; i < items.length; i++) {
                items[i] = Integer.parseInt(splitStr[i]);
            }
        }

        for (int idx = 0; idx < items.length; ++idx) { // row
            System.out.print(idx + ": ");

            for (int starNo = 1; starNo <= items[idx]; ++starNo) {// column
                System.out.print("*");
            }
            System.out.println("(" + items[idx] + ")");
        }
    }
}
