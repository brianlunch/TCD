// -------------------------------------------------------------------------

import java.util.Arrays;

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
        //todo: do experiments as per assignment instructions
    
    }

}//end class