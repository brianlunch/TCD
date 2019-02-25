// -------------------------------------------------------------------------

/*
*   All measuremnts are in ms
*
*  insertion sort
*       10 random - 0.008576286
 *       100 random - 0.158044429
 *       1000 random - 4.923271857
 *       1000 few unique - 5.1824
 *       1000 nearly ordered - 0.060952429
 *       1000 reverse order - 0.784558286
 *       1000 sorted - 0.003883714
 *
 *  selection sort
 *       10 random - 0.006796571
 *       100 random - 0.169048
 *       1000 random - 20.63164471
 *       1000 few unique - 2.089799857
 *       1000 nearly ordered - 1.629853
 *       1000 reverse order - 2.511287571
 *       1000 sorted - 1.861741429
 *
*
 *  quick sort
 *       10 random - 0.011813
 *       100 random - 0.064728
 *       1000 random - 0.974858857
 *       1000 few unique - 0.186794571
 *       1000 nearly ordered - 0.235664143
 *       1000 reverse order - 1.124488429
 *       1000 sorted - 1.327681143
 *
 *
 *  merge sort recursive
 *       10 random - 0.015102857
 *       100 random - 0.144343571
 *       1000 random - 0.984976
 *       1000 few unique - 0.168994286
 *       1000 nearly ordered - 0.156965429
 *       1000 reverse order - 0.081611286
 *       1000 sorted - 0.079993286

 *
 *  merge sort iterative
 *       10 random - 0.070607571
 *       100 random - 0.106747714
 *       1000 random - 3.197944714
 *       1000 few unique - 0.299475
 *       1000 nearly ordered - 0.231348571
 *       1000 reverse order - 0.146555143
 *       1000 sorted - 0.241867571

 *
 *
 *      a -
 *
 *      b - Selection sort as it has an O(n^2) in all cases
 *
 *      c - Best - Quick Sort
 *          Worst - Selection Sort
 *
 *      d - Ìterative takes a lot longer when the data is larger and random
 *
 *      e - 10 random - selection sort
 *          100 random - quick sort
 *          1000 random - quick sort
 *          1000 few unique - merge sort recursive
 *          1000 nearly ordered - insertion sort
 *          1000 reverse order - merge sort recursive
 *          1000 sorted - insertion sort
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2019
 */

class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){

        int n = a.length;
        for (int i=1; i<n; ++i)
        {
            double key = a[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && a[j] > key)
            {
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1] = key;
        }
        return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
        quickSortR(a,0,a.length-1);
        return a;
    }//end quicksort

    private static void quickSortR(double arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSortR(arr, begin, partitionIndex-1);
            quickSortR(arr, partitionIndex+1, end);
        }
    }

    private static int partition(double arr[], int begin, int end) {
        double pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                double swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        double swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
        int length = a.length;
        double[] aux = new double[length];
        for (int i = 1; i < length; i = i + i) {
            for (int low = 0; low < length - i; low += i + i) {
                merge(a, aux, low, low+i-1, Math.min(low+i+i-1,length-1));
            }
        }
        return a;

    }//end mergeSortIterative



    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
        double[] aux = new double[a.length];
        sort(a, aux, 0, a.length-1);
        return a;

    }

    private static void sort(double[] a, double[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid+1, high);
        merge(a, aux, low, mid, high);
    }

    private static void merge(double[] a, double[] aux, int low, int mid, int high) {
        //copy
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        //merge
        int i = low, j = mid+1;
        for (int k = low; k <= high; k++) {
            if      (i > mid)           a[k] = aux[j++];
            else if (j > high)          a[k] = aux[i++];
            else if (aux[j] < aux[i])   a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }
    //end mergeSortRecursive


    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        int length = a.length;
        for (int i = 0; i < length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            double temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
        return a;

    }//end selectionsort




    public static void main(String[] args) {
        String[] files = new String[]{"/users/brian/numbers10.txt","/users/brian/numbers100.txt",
                "/users/brian/numbers1000.txt", "/users/brian/numbers1000Duplicates.txt","/users/brian/numbersNearlyOrdered1000.txt",
        "/users/brian/numbersReverse1000.txt", "/users/brian/numbersSorted1000.txt"};

        for (String file : files) {
            ArrayList<Double> doubles = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    line = br.readLine();
                    if (line != null) doubles.add(Double.parseDouble(line));
                }

                double[] a = resetArray(doubles);
                //System.out.println("Selection Sort: ");
                //printArray(a);
                double startTime = System.nanoTime();
                selectionSort(a);
                double endTime = System.nanoTime();
                double duration = (endTime - startTime) / 1000000;
                //printArray(a);
                System.out.println("Selection Sort time for " + file.split("/")[file.split("/").length - 1] + ": " + duration + "ms");

                a = resetArray(doubles);
                //System.out.println("Insertion Sort: ");
                //printArray(a);
                startTime = System.nanoTime();
                insertionSort(a);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                //printArray(a);
                System.out.println("Insertion Sort time for " + file.split("/")[file.split("/").length - 1] + ": " + duration + "ms");

                a = resetArray(doubles);
                //System.out.println("MergeSort Iterative: ");
                //printArray(a);
                startTime = System.nanoTime();
                mergeSortIterative(a);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                //printArray(a);
                System.out.println("MergeSort Iterative time for " + file.split("/")[file.split("/").length - 1] + " was " + duration + "ms");


                a = resetArray(doubles);
                //System.out.println("MergeSort Recursive: ");
                //printArray(a);
                startTime = System.nanoTime();
                mergeSortRecursive(a);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                //printArray(a);
                System.out.println("MergeSort Recursive time for " + file.split("/")[file.split("/").length - 1] + ": " + duration + "ms");

                a = resetArray(doubles);
                //System.out.println("QuickSort: ");
                //printArray(a);
                startTime = System.nanoTime();
                quickSort(a);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                //printArray(a);
                System.out.println("QuickSort time for " + file.split("/")[file.split("/").length - 1] + ": " + duration + "ms");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    private static double[] resetArray(ArrayList<Double> doubles) {
        double[] a;
        a = new double[doubles.size()];
        for (int j = 0; j < a.length; j++) {
            a[j] = doubles.get(j);
        }
        return a;
    }
}//end class