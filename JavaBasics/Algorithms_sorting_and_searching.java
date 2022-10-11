public class Algorithms_sorting_and_searching {
    public static void main(String[] args) {

        int[] array = {1, 5, -5, -2, 0, -7, -8, 9, 3, -4};

        System.out.println("Linear Search:");
        System.out.println(linearSearch(array, 9));
        System.out.println(linearSearch(array, 4));
        System.out.println(linearSearchIndex(array, 9));
        System.out.println(linearSearchIndex(array, 4));

        int[] array1 = {11, 14, 16, 18, 20, 25, 28, 30, 34, 40, 45, 47, 52};
        System.out.println("Binary Search: ");
        System.out.println(binarySearch(array1,25,2,7));
        System.out.println(binarySearch(array1, 25,0,4));
        System.out.println(binarySearch(array1,25));
        System.out.println(binarySearch(array1,29));


        System.out.println("Sort algorithm:");
        System.out.println("Array:");
        print(array);
        int[] selection = array;
        int[] bubble = array;
        int[] insert = array;

        selectionSort(selection);
        bubbleSort(bubble);
        insertionSort(insert);

        System.out.println("Selection Sort:");
        print(selection);
        System.out.println("Bubble Sort:");
        print(bubble);
        System.out.println("Insertion Sort");
        print(insert);

    }

    // Return true if the key is found inside the array
    public static boolean linearSearch(int[] array, int key) {
        for (int idx : array) {
            if (idx == key)
                return true;
        }
        return false;
    }

    // Return the array index, if key is found; or 0 otherwise
    public static int linearSearchIndex(int[] array, int key) {
        for (int idx = 0; idx < array.length; idx++) {
            if (array[idx] == key)
                return idx + 1;
        }
        return 0;
    }

    // Return true if key is found in the array in the range of fromIdx (inclusive) to toIdx (exclusive)
    public static boolean binarySearch(int[] array, int key, int fromIdx, int toIdx) {
        if (fromIdx == toIdx - 1) {   // Terminating one-element list
            return key == array[fromIdx];
        } else {
            int midIdx = (fromIdx + toIdx) / 2;
            if (array[midIdx] == key) return true;
            else if (key < array[midIdx]) toIdx = midIdx;
            else fromIdx = midIdx + 1;
            return binarySearch(array, key, fromIdx, toIdx); // recursive
        }
    }

    // Return true if key is found in the array
    public static boolean binarySearch(int[] array, int key) {
        return binarySearch(array, key, 0, array.length);
    }

    public static void print(int[] array) {
        for (int items : array)
            System.out.print(items + " ");
        System.out.println();
    }

    public static void selectionSort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {
            int minIdx = i;
            for (int idx = i + 1; idx < len; idx++) {
                if (array[idx] < array[minIdx])
                    minIdx = idx;

                //swap
                int temp = array[minIdx];
                array[minIdx] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void bubbleSort(int[] array){
        int n = array.length;
        boolean swapped;    // boolean flag to indicate swapping occurred during a pass
        do {
            swapped = false;  // reset for each pass
            for (int i = 1; i < n; ++i) {
                // Swap if this pair is out of order
                if(array[i-1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true ;  // update flag
                }
            }
            n--;  // One item sorted after each pass
        } while (swapped);  // repeat another pass if swapping occurred, otherwise done
    }

    public static void insertionSort(int[] array) {
        int len = array.length;

        for (int i = 1; i < len; i++) {
            int pos = array[i];
            int prefix = i - 1;

            while (prefix >= 0 && pos < array[prefix]) {
                array[prefix + 1] = array[prefix];
                prefix--;
            }
            array[prefix + 1] = pos;
        }
    }
}
