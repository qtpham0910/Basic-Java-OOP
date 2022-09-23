import java.util.*;

public class BoxPattern {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size: ");
		int size = sc.nextInt();
		sc.nextLine();
		size -= 1;
		//Pattern a 
		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {
				if (row == 1 || row == size || col==1 || col == size) {
					System.out.print(" #");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		for(int i = 0; i < size/2+1; i++) 
			System.out.print(" ");
		System.out.println("(a)\n");
		
		
		// Pattern b
		for ( int row=1;row<=size;row++) {
			for ( int col=1;col<=size;col++) {
				if (row == 1 || row == size || col == row ) {
					System.out.print(" #");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		for(int i = 0; i < size/2+1; i++) 
			System.out.print(" ");
		System.out.println("(b)\n");
		
		
		// Pattern c
		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {
				if (row == 1 || row == size || col + row == size + 1 ) {
					System.out.print(" #");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		for(int i = 0; i < size/2+1; i++) 
			System.out.print(" ");
		System.out.println("(c)\n");
		
		
		//Pattern d
		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {
				if (row == 1 || row == size ||  col + row == size + 1 || row == col ) {
					System.out.print(" #");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
			
		}
		for(int i = 0; i < size/2+1; i++) 
			System.out.print(" ");
		System.out.println("(d)\n");
		sc.close();
	}
	
}