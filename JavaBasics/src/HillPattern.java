import java.util.*;

public class HillPattern {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the rows: ");
		int size = sc.nextInt();
		sc.nextLine();
		
		int length = 2*size - 1;
		//Pattern a
		for( int row = 1; row <= size; row++) {
			for( int col = 1; col <= length; col++ ) {
				if ((col + row >= size +1) && (row >= col - size + 1)) {
					System.out.print(" #");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("(a)");
		
		
		// Pattern b
		for ( int row = 1;row <= size; row++) {
			for ( int col = 1; col<= length;col++ ) {
				if ((col + row <= 2 * size) && col >= row ) {
					System.out.print(" #");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("(b)");
		
		
		// Pattern c
		for ( int row = 1;row <= length;row++) {
			for ( int col = 1; col <= length;col++ ) {
				if ((col + row > size) && (col + size > row) && (row >= col-size+1) && (col + row < 3 * size)  ) {
					System.out.print(" #");
					
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("(c)");
		
		// row + col == length - 1 && row + col > length
		// Pattern d
		for ( int row = 0; row <= length + 1; row++) {
			for ( int col = 0; col <= length + 1; col++ ) {
				if ((col + row > size) && (col + size > row) && (row >= col-size+1) && (col + row < 3 * size)  ) {
					System.out.print("  ");
					
				} else {
					System.out.print(" #");
				}
			}
			System.out.println();
		}
		System.out.println("(d)");
	}
	
	
}