import java.util.*;
public class TimeTable {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size: ");
		int size = sc.nextInt();
		sc.nextLine();
		System.out.print(" * |");
		for ( int i = 1; i <= size; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();
		
		for (int j = 1; j < size*4 + 5 ; j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 1; i <= size; i++) {
			System.out.printf("%2d %s",i ,"|");
				for ( int j = 1; j <= size; j++) {
					int res = j * i;
					System.out.printf("%4d", res);
				}
			System.out.println();
		}
		sc.close();
	}
	
}