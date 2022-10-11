/**
 * This program contains Method 2.4 to 2.10 in 'Exercise on Method'
 */

import java.util.Scanner;

public class ExercisesOnMethod {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ExercisesOnMethod aExerciseOnMethod = new ExercisesOnMethod();

        aExerciseOnMethod.runArrayToString();
        aExerciseOnMethod.runContains();
        aExerciseOnMethod.runSearch();
        aExerciseOnMethod.runEquals();
        aExerciseOnMethod.runCopyOf();
        aExerciseOnMethod.runSwap();
        aExerciseOnMethod.runReverse();

    }

    public static int[] inputArray() {
        System.out.print("Enter the number of items: ");
        int numItems = sc.nextInt();
        sc.nextLine();
        int[] array = new int[numItems];
        System.out.println("Enter the value of all items (separated by enter): ");
        for (int idx = 0; idx < numItems; idx++) {
            array[idx] = sc.nextInt();
        }
        return array;
    }
    //function array.toString
    public static String arrayToString(int[] array){
        String result = "[";
        for(int i = 0; i < array.length; i++){
            result += String.valueOf(array[i]);
            if(i < array.length - 1)
            result += ", ";
        }
        result += "]";
        return result;
    }

    private void runArrayToString(){
        System.out.println("\tArrayToString():");
        int[] array = inputArray();
        System.out.print("Array to string:\nArray = ");
        System.out.println(arrayToString(array));
    }
    // function and run contains
    public static boolean contains(int[] array, int key) {
        for (int j : array) {
            if (j == key)
                return true;
        }
        return false;
    }

    private void runContains() {
        System.out.println("\tContains(): ");
        int[] array1 = inputArray();
        System.out.print("Enter key: ");
        int key = sc.nextInt();
        sc.nextLine();
        System.out.println(contains(array1, key) ? "Array contains key = " + key : "Array does not contains key = " + key);
    }

    // function and run search
    public static int search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i + 1;
            }
        }
        return -1;
    }

    private void runSearch() {
        System.out.println("\tSearch(): ");
        int[] array = inputArray();
        System.out.print("Enter key: ");
        int key = sc.nextInt();
        sc.nextLine();
        System.out.println(search(array, key) != -1 ? "Index of key is: " + key : "Array does not contains " + key);
    }

    //function and run equals
    public static boolean equals(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private void runEquals() {
        System.out.println("\tEquals():");
        System.out.println("Array 1:");
        int[] array1 = inputArray();
        System.out.println("Array 2:");
        int[] array2 = inputArray();
        System.out.println(equals(array1, array2) ? "Array1 equals Array2" : "Array1 not equals Array2");
    }

    //function Copy
    public static int[] copyOf(int[] array, int newLength) {
        int[] copy = new int[newLength];

        for(int i = 0; i < array.length; i++)
            copy[i] = array[i];
        return copy;
    }

    private void runCopyOf(){
        System.out.println("\tCopyOf(): ");
        System.out.println("Array 1:");
        int[] array = inputArray();
        System.out.print("New Array 2 with new length: ");
        int newLength = sc.nextInt();
        sc.nextLine();
        int[] array2 = copyOf(array, newLength);

        for(int i : array2)
            System.out.print(i + " ");

        System.out.println();
    }

    // function Swap
    public static boolean swap(int[] array1, int[] array2){
        int len1 = array1.length;
        int len2 = array2.length;
        if(len1 != len2){
            return false;
        }

        for(int i = 0; i < len1; i++) {
            int temp = array1[i];
            array1[i] = array2[i];
            array2[i] = temp;
        }
        return true;
    }

    private void runSwap(){
        System.out.println("\tSwap():");
        System.out.println("Array 1:");
        int[] array1 = inputArray();
        System.out.println("Array 2:");
        int[] array2 = inputArray();

        System.out.println(swap(array1, array2) ? "Swap two arrays successful" : "2 arrays does not have same length");
    }


    // void Reverse
    public static void reverse(int[] array){
        for(int fldx = 0, bldx = array.length - 1; fldx < bldx; ++fldx, --bldx){
            int temp = array[fldx];
            array[fldx] = array[bldx];
            array[bldx] = temp;
        }
    }

    private void runReverse(){
        System.out.println("\tReverse():");
        int[] array = inputArray();
        reverse(array);
        System.out.print("Array after reverse: ");
        for(int items : array){
            System.out.print(items + " ");
        }
    }
}
