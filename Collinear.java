/**
*   MimGo - HUS 😎
*   Input integer Matrix A(m x n)
*   Check and list collinear columns
* Two arrays of numbers A and B with the same number of elements 
* are said to be collinear if there exists a t != 0 such that A[i]*t = B[i] for all i.

*   % java Collinear 
*   5 6
*   1  2   2   3  5   4
*   3  1   6   1  15  2
*   2  0   4   7   10  0
*   7  3  14  10  35  6
*   4  1   8  2   20  2
*   // Result
*   0 1 0 3 0 1
*
**/

import java.util.*;

 class Collinear{

    public static boolean isCollinear(int V[], int U[]){
        int n = V.length;
       double[] a = new double[n];
        for(int i = 0; i < n; i++){
            if(V[i] == 0 && U[i] == 0) {
                a[i] = 0;
                continue;
            }
            if(V[i] == 0 && U[i] !=0){
                a[i] = -1;
                continue;
            }
             a[i] = 1.0 * V[i] / U[i];
        }
        
        int flg =1;
        for(int i = 0 ; i < n-1; i++){
            if(a[i] == 0.0 || a[i+1] ==0.0)continue;
            if(a[i] != a[i+1] ){
                flg = 0;
                return false;
            }
            
        }
                 return true;
            
    }
    
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
       int m = scanner.nextInt();
       int n = scanner.nextInt();
       int[][] a = new int[m][n];

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = scanner.nextInt();
            }
        }
        
        int k = 0;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = -1;
        }
        int[] v = new int[m];
        int[] u = new int[m];
        for(int i = 0; i < n; i++){
            for(int l = i+1; l < n; l++){
                for(int j = 0; j < m; j++){
                v[j] = a[j][i];
                u[j] = a[j][l];
            }
            if(res[l] != -1) continue;
            
            if( isCollinear(v,u) == true){
               
                res[i] = k;
                res[l] = k;
            }
        }
        k++;
        
    }
  
        for(int i = 0;i < n; i++){
            if(res[i] == -1){
                res[i] = i;
                
            }
                System.out.print(res[i] + " ");
        }
        
        
    }
}

