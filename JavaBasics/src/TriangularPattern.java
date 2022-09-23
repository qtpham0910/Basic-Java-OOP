import java.util.*;

public class TriangularPattern {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size: ");
		int size = sc.nextInt();
		sc.nextLine();
		
		//Pattern a
		for(int row = 1; row <= size; row++) {
			for ( int col = 1; col <= row; col++) {
				System.out.print("# ");
			}
			System.out.println();
		}
		for(int i = 0; i < size/2+1; i++) 
			System.out.print(" ");
		System.out.println("(a)");
		
		
		//Pattern b
		for ( int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {
				if (row <= col) {
					System.out.print("# ");
				}
			}
			System.out.println();
		}
		
		for(int i = 0; i < size/2+1; i++) 
			System.out.print(" ");
		System.out.println("(b)");
		
		
		//Pattern c
		for ( int row = 1; row <= size; row++) {
			for ( int col = 1; col<= size; col++) {
				if (row <= col) {
					System.out.print("# ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		for(int i = 0; i < size/2+1; i++) 
			System.out.print(" ");
		System.out.println("(c)");
		
		
		// Pattern d
		for(int row = 1; row <= size; row++) {
			for(int col = 1; col <= size; col++) {
				if (row + col >= size+1) {
					System.out.print("# ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		for(int i = 0; i < size/2+1; i++) 
			System.out.print(" ");
		System.out.println("(d)");
		
	}
}
