// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  
 *  @version 18/09/18 12:21:09
 */
class Collinear
{

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
	 * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
	 * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
	 * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
	 * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a horizontal line.
	 * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
	 * A non-horizontal line will have to cross all three of these lines. Thus
	 * we are looking for 3 points, each in a1, a2, a3 which lie on the same
	 * line.
	 * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
	 * x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0 
	 *
	 * In our case y1=1, y2=2, y3=3.
	 *
	 * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
	 *
	 * ----------------------------------------------------------
	 *
	 * 
	 *  Order of Growth
	 *  -------------------------
	 *
	 *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
	 *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
	 *
	 *  Order of growth: N^3
	 *
	 *  Explanation: three linear for-loops
	 */
	static int countCollinear(int[] a1, int[] a2, int[] a3)
	{
		//TODO: implement this method
		// Loops through every possibility and checks it against the formula.
		int howMany=0;
		for(int i = 0; i < a1.length;i++) {
			for(int j = 0; j < a2.length;j++) {
				for(int k = 0; k < a3.length;k++) {	
					if(  (a1[i] * (2-3)) + (a2[j] * (3-1)) +  (a3[k]*(1-2))    == 0)
						howMany++;	
				}
			}
		}
		return howMany;
	}

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
	 * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
	 * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
	 * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
	 * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a horizontal line.
	 *
	 * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
	 * The performance of this method should be much better than that of the above method.
	 *
	 *
	 *  Order of Growth
	 *  -------------------------
	 *
	 *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
	 *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
	 *
	 *  Order of Growth: N^2
	 *
	 *  Explanation: two linear for loops
	 *
	 *
	 */
	static int countCollinearFast(int[] a1, int[] a2, int[] a3)
	{
		//TODO: implement this method
		// loops through only two arrays, and checks to see if the third array contains the right number to satisy the equation
		sort(a3);
		int howMany=0;
		int key=0;
		for(int i = 0; i < a1.length;i++) {
			for(int j = 0; j < a2.length;j++) {
				key =(2*a2[j]) - a1[i];				// manipulation of the formula...formula used is (2 * x2) - x1 = x3
				if(binarySearch(a3, key))
					howMany++;
			}
		}
		return howMany;
	}

	// ----------------------------------------------------------
	/**
	 * Sorts an array of integers according to InsertionSort.
	 * This method is static, thus it can be called as Collinear.sort(a)
	 * @param a: An UNSORTED array of integers. 
	 * @return after the method returns, the array must be in ascending sorted order.
	 *
	 * ----------------------------------------------------------
	 *
	 *  Order of Growth
	 *  -------------------------
	 *
	 *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
	 *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
	 *
	 *  Order of Growth: N^2 x (Log2(N))
	 *
	 *  Explanation: Two linear for-loops and a binary search which is log2(N)
	 *
	 */
	static void sort(int[] a)
	{
		//sorts an array in ascending order
		for ( int j = 1; j<a.length; j++)
		{
			int i = j - 1;
			while(i>=0 && a[i]>a[i+1])
			{
				int temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
				i--;
			}
		}
	}

	// ----------------------------------------------------------
	/**
	 * Searches for an integer inside an array of integers.
	 * This method is static, thus it can be called as Collinear.binarySearch(a,x)
	 * @param a: A array of integers SORTED in ascending order.
	 * @param x: An integer.
	 * @return true if 'x' is contained in 'a'; false otherwise.
	 *
	 * ----------------------------------------------------------
	 *
	 *  Order of Growth
	 *  -------------------------
	 *
	 *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
	 *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
	 *
	 *  Order of Growth: log2(N) (base 2)
	 *
	 *  Explanation: because youre halving the amount each time meaning it is 1 = N/2^x (x being worst case of how many times youve to divide by two before you get one)
	 *  			1 = N/2^x
	 *  			2^x = N (multiply by 2^x)
	 *  			log2(N) = x (Rules of indices) (base 2)
	 *
	 */
	static boolean binarySearch(int[] a, int x)
	{
		//TODO: implement this method
		// checks if a certain number is in an array
		int low = 0;
		int high = a.length - 1;

		while(high >= low) {
			int middle =low + (high-low) / 2;
			if(a[middle] == x) {
				return true;
			}
			else if(a[middle] < x) {
				low = middle + 1;
			}
			else //(a[middle] > x) 
				high = middle - 1;
		}
		return false;
	}

}