/******************************************************************************
 *  Compilation:  javac RandomWebSurfer.java
 *  Execution:    java RandomWebSurfer 
 *  Data files:   stdin.txt
 *
 *  % java RandomWebSurfer < stdin.txt
 *  0 0.27245
 *	1 0.26515
 *	2 0.14669
 *	3 0.24764
 *	4 0.06806
 *
 ******************************************************************************/
import java.util.Scanner;

public class RandomWebSurfer {

	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		double[][] cnt = new double[n][n];
		int[] outDegree = new int[n];
		
		int x;
		int y;
		while(scanner.hasNextInt()) {
			x=scanner.nextInt();
			y=scanner.nextInt();
			++cnt[x][y];
			++outDegree[x];
		}
		
		double leapProb = 0.1 * 1.0 / n;	// leap probabilities
		
		for(int i = 0;i < n; i++) {
			for(int j = 0; j < n ;j++) {

				cnt[i][j] = (double) ( .90 * cnt[i][j] /outDegree[i] + leapProb);  //Transition Matrix = leap Prob + Link Prob
//				System.out.printf("%7.5f ", cnt[i][j]);
				
			}
//			System.out.println();
		}
		
//		for(int i = 0;i < n; i++) {
//			System.out.println(outDegree[i]);
//		}
		
		double[] rank = new double[n];
		rank[0] = 1.0;
		
		for(int k = 0; k < m; k++) {
		
			double[] newRank = new double[n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					newRank[i] += rank[j] * cnt[j][i];
			}
			
			rank = newRank;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.printf("%d %7.5f\n",i, rank[i]);
		}
	}

}
