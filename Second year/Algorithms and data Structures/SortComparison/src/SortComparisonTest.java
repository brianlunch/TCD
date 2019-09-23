import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Array;
import java.util.Arrays;

//-------------------------------------------------------------------------

/**
 * Test class for SortComparison.java
 *
 * @author
 * @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
    //~ Constructor ........................................................
    @Test
    public void testConstructor() {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------

    /**
     * Check that the methods work for empty arrays
     */

    @Test
    public void testQuickSortEmpty() {
        double[] a = new double[0];
        Assert.assertEquals(a, SortComparison.quickSort(a));
    }

    @Test
    public void testSelectionSortEmpty() {
        double[] a = new double[0];
        Assert.assertEquals(a, SortComparison.selectionSort(a));
    }

    @Test
    public void testInsertionSortEmpty() {
        double[] a = new double[0];
        Assert.assertEquals(a, SortComparison.insertionSort(a));
    }

    @Test
    public void testMergeSortREmpty() {
        double[] a = new double[0];
        Assert.assertEquals(a, SortComparison.mergeSortRecursive(a));
    }

    @Test
    public void testMergeSortIEmpty() {
        double[] a = new double[0];
        Assert.assertEquals(a, SortComparison.mergeSortIterative(a));
    }


    @Test
    public void testQuickSort() {
        double[] a = {1.0, 3.0, 6.0, 5.0, 4.0, 2.0};
        double[] aSort = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.quickSort(a)));
    }

    @Test
    public void testSelectionSort() {
        double[] a = {1.0, 3.0, 6.0, 5.0, 4.0, 2.0};
        double[] aSort = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.selectionSort(a)));
    }

    @Test
    public void testInsertionSort() {
        double[] a = {1.0, 3.0, 6.0, 5.0, 4.0, 2.0};
        double[] aSort = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.insertionSort(a)));
    }

    @Test
    public void testMergeSortR() {
        double[] a = {1.0, 3.0, 6.0, 5.0, 4.0, 2.0};
        double[] aSort = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.mergeSortRecursive(a)));
    }

    @Test
    public void testMergeSortI() {
        double[] a = {1.0, 3.0, 6.0, 5.0, 4.0, 2.0};
        double[] aSort = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.mergeSortIterative(a)));
    }

}