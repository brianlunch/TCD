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
    public void testEmpty() {
    }


    @Test
    public void testQuickSort() {
        double[] a = {1.0, 3.0, 6.0, 5.0, 4.0, 2.0};
        double[] aSort = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.quickSort(a)));


        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.mergeSortIterative(a)));
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.mergeSortRecursive(a)));
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

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------

    /**
     * Main Method.
     * Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     */
    public static void main(String[] args) {
        //TODO: implement this method
    }

}
