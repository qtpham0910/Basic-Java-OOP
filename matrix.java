import java.util.Scanner;
import java.util.*;
public class matrix {
	
	public static int[][] inputMatrix(Scanner reader){
		int n = Integer.parseInt(reader.nextLine());
		int[][] a = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n;j++) {
				a[i][j] = Integer.parseInt(reader.nextLine());
			}
		}
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n;j++) {
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
		return a;
	}
	
	public static boolean isLowerTriangle(int[][] arr) {
		int n = arr.length;
		for(int i = 0; i < n; i++) 
			for(int j = i+1; j < n; j++) 
				if(arr[i][j] != 0) return false;
			
		return true;
	}
	public  static boolean isUpperTriangle(int [][] arr) {
		int n = arr.length;
		for(int i = 1; i < n; i++) 
			for(int j = 0; j < i; j++) 
				if(arr[i][j] != 0) return false;
			
	return true;
	}
	public static int[] findColumns(int[][] arr) {
		int n = arr.length;
		int mn = Integer.MAX_VALUE;
		int mxmn = Integer.MIN_VALUE;
		int[] chk = new int[n];
		for(int j = 0; j <n; j++) {
			 mn = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				mn = Math.min(mn, arr[i][j]);
			}
			chk[j] = mn;
			mxmn = Math.max(mxmn, mn);
		}
//		System.out.println("min " + mxmn);
//		for(int x:chk) {
//			System.out.print(x + " ");
//		}
//		System.out.println();
		Set<Integer> set = new HashSet<Integer>();
		   
		for(int i=0; i<n;i++) {
			if(chk[i] == mxmn) {
				set.add(i);
			}
		}
		int[] res = new int[set.size()];
		int j = 0;
		for(int i:set) {
			res[j++] = i;
		}
		for(int x:res) {
			System.out.print(x + " ");
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
//		System.out.println(inputMatrix(reader));
//		System.out.println(isLowerTriangle(inputMatrix(reader)));
//		System.out.println(isUpperTriangle(inputMatrix(reader)));
		System.out.println(findColumns(inputMatrix(reader)));
	}

}
