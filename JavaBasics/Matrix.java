import java.util.Random;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        int[][] matrix1 = createRandomMatrix1(5,5);
        int[][] matrix2 = createRandomMatrix1(5,5);
        System.out.println("Matrix 1:");
        print(matrix1);
        System.out.println("Matrix 2:");
        print(matrix2);

        int[][] addMatrix = add(matrix1, matrix2);
        int[][] mulMatrix = multiply(matrix1, matrix2);

        System.out.println("Add two matrix");
        print(addMatrix);
        System.out.println("Multiply two matrix");
        print(mulMatrix);
    }

    public static void createRandomMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0 ;j < matrix[0].length; j++){
                matrix[i][j] = (int) (Math.random() * 10) + 1;
            }
        }
    }


    public static int[][] createRandomMatrix1(int row, int column){
        int[][] matrix = new int[row][column];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                matrix[i][j] = (int) (Math.random() * 50) + 1;
            }
        }
        return matrix;
    }
    public static void print(int[][] matrix){

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void runCreateMatrixRandom(){

        Scanner sc = new Scanner(System.in);
        int size = 10;
        int[][] matrix = createRandomMatrix1(size, size);
        print(matrix);

    }

    public static boolean haveSameDimension(int[][] matrix1, int[][] matrix2){
        if(matrix1.length != matrix2.length){
            return false;
        }

        for(int i = 0; i < matrix1.length; i++){
            if(matrix1[i].length != matrix2[i].length){
                return false;
            }
        }

        return true;
    }

    public static int[][] add(int[][] matrix1, int[][] matrix2){

            int[][] sumMatrix = new int[matrix1.length][matrix1.length];
            for(int i = 0;i < matrix1.length; i++){
                for(int j = 0; j < matrix1[0].length; j++){
                    sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            return sumMatrix;
    }

    public static int[][] subtract(int[][] matrix1, int[][] matrix2){
        int[][] subMatrix =  new int[matrix1.length][matrix1.length];
        for(int i = 0;i < matrix1.length; i++){
            for(int j = 0; j < matrix1[0].length; j++){
                subMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return subMatrix;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2){
        int row = matrix1.length;
        int col = matrix2[0].length;

        int[][] multiplyMatrix = new int[row][col];
        if( matrix1[0].length == matrix2.length){

            for(int i = 0 ; i < row; i++)
                for(int j = 0; j < col; j++){
                    int sum = 0;
                    for(int k = 0; k < matrix1[0].length; k++){
                        sum += matrix1[i][k] * matrix2[k][j];
                    }
                    multiplyMatrix[i][j] += sum;
                }
            return multiplyMatrix;
        }
        return multiplyMatrix;
    }


}
