import java.util.Scanner;

public class PrintArray {
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

        System.out.print("The values are: ");
        if(items.length == 0 ){
            System.out.print("[");
        }
        for (int i = 0; i < items.length; i++) {
            if (i == 0) {
                System.out.printf("[%d", items[i]);
            } else {
                System.out.printf(", %d", items[i]);
            }

            // one line
            //System.out.print( (i == 0) ? "[" + items[i] : ", " + items[i]);
        }

        System.out.print("]");
    }
}
