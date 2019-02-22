// -------------------------------------------------------------------------

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



    }//end quicksort

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
            int n = a.length-1;
            // For current size of subarrays to
            // be merged curr_size varies from
            // 1 to n/2
            int curr_size;

            // For picking starting index of
            // left subarray to be merged
            int left_start;


            // Merge subarrays in bottom up
            // manner. First merge subarrays
            // of size 1 to create sorted
            // subarrays of size 2, then merge
            // subarrays of size 2 to create
            // sorted subarrays of size 4, and
            // so on.
            for (curr_size = 1; curr_size <= n-1;
                 curr_size = 2*curr_size)
            {

                // Pick starting point of different
                // subarrays of current size
                for (left_start = 0; left_start < n-1;
                     left_start += 2*curr_size)
                {
                    // Find ending point of left
                    // subarray. mid+1 is starting
                    // point of right
                    int mid = left_start + curr_size - 1;

                    int right_end = Math.min(left_start
                            + 2*curr_size - 1, n-1);

                    // Merge Subarrays arr[left_start...mid]
                    // & arr[mid+1...right_end]
                    merge(a, left_start, mid, right_end);
                }
            }
            return a;
        }

    /* Function to merge the two haves arr[l..m] and
    arr[m+1..r] of array arr[] */
        static void merge(double arr[], int l, int m, int r)
        {
            int i, j, k;
            int n1 = m - l + 1;
            int n2 = r - m;

            /* create temp arrays */
            double L[] = new double[n1];
            double R[] = new double[n2];

        /* Copy data to temp arrays L[]
        and R[] */
            for (i = 0; i < n1; i++)
                L[i] = arr[l + i];
            for (j = 0; j < n2; j++)
                R[j] = arr[m + 1+ j];

        /* Merge the temp arrays back into
        arr[l..r]*/
            i = 0;
            j = 0;
            k = l;
            while (i < n1 && j < n2)
            {
                if (L[i] <= R[j])
                {
                    arr[k] = L[i];
                    i++;
                }
                else
                {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

        /* Copy the remaining elements of
        L[], if there are any */
            while (i < n1)
            {
                arr[k] = L[i];
                i++;
                k++;
            }

        /* Copy the remaining elements of
        R[], if there are any */
            while (j < n2)
            {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
    //end mergesortIterative



    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {

        if(a == null)
        {
            return null;
        }

        if(a.length > 1)
        {
            int mid = a.length / 2;

            // Split left part
            double[] left = new double[mid];
            for(int i = 0; i < mid; i++)
            {
                left[i] = a[i];
            }

            // Split right part
            double[] right = new double[a.length - mid];
            for(int i = mid; i < a.length; i++)
            {
                right[i - mid] = a[i];
            }
            mergeSortIterative(left);
            mergeSortIterative(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while(i < left.length && j < right.length)
            {
                if(left[i] < right[j])
                {
                    a[k] = left[i];
                    i++;
                }
                else
                {
                    a[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while(i < left.length)
            {
                a[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length)
            {
                a[k] = right[j];
                j++;
                k++;
            }
        }
        return a;
        //todo: implement the sort

    }//end mergeSortRecursive


    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

        //todo: implement the sort

    }//end selectionsort




    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

}//end class
