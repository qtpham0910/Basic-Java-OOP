import java.security.PublicKey;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Example7 {
	// Kiểm tra hàng có đủ 1-9
	public static int row_valid(int row, int[][] x) {
		int t[] = x[row];
		Set<Integer> set = new HashSet<Integer>();
		for(int val : t) {
			if(set.add(val) == false) {
				return 0;
			}
		}
		return 1;
	}
	
	//Kiểm tra cột có đủ 1-9 
	public static int col_valid(int col, int[][] x) {
	
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < 9; i++) {
			if(set.add(x[i][col]) == false) {
				return 0;
			}
		}
		return 1;
	}

	//Kiểm tra bảng 3x3 có đủ 1-9
	public static int subSquare_valid(int a[][]) {
		
		for(int i = 0; i < 9; i+=3) {
			for(int j = 0;  j < 9; j+=3) {
				Set<Integer> set = new HashSet<Integer>(9);
				
				for(int row = i; row < i+3; row++) {
					for(int col = j; col < j+3; col++) {
						if (set.add(a[row][col]) == false) {
				            return 0;
				            }
					}
				}
			}
		}
		return 1;
		
		
	}
	
	// Kiểm tra có phải là bảng Sudoku 9x9
	public static void valid_sudoku(int[][] a) {
		
		for(int i = 0; i < 9; i++) {
			int r = row_valid(i, a);
			int c = col_valid(i, a);
			
			if( c == 0 || r == 0) {
				System.out.println("Không phải bảng sudoku");
				return;
			}
		}
		
		int valid_sub = subSquare_valid(a);
		if(valid_sub == 0) {
			System.out.println("Không phải bảng sudoku");
			return;
		}
		else {
			System.out.println("Đây là 1 bảng Sudoku");
			return;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		int a[][] = new int[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++)
				a[i][j] = rand.nextInt(9) + 1;
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		valid_sudoku(a);
	}
	

}
