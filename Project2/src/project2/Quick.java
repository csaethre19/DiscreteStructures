package project2;

import java.util.Random;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {

	static int comps = 0;

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param a the array to be sorted
	 */
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
		assert isSorted(a);
	}
	
	public static void clearCount() {
		comps = 0;
	}

	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(Comparable[] a, int lo, int hi) {
		comps++;
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
		assert isSorted(a, lo, hi);
	}

	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j.
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {

			// find item on lo to swap
			while (less(a[++i], v)) {
				comps++;
				if (i == hi)
					break;
			}

			// find item on hi to swap
			while (less(v, a[--j])) {
				comps++;
				if (j == lo)
					break; // redundant since a[lo] acts as sentinel
			}

			// check if pointers cross
			comps++;
			if (i >= j)
				break;

			exch(a, i, j);
		}

		// put partitioning item v at a[j]
		exch(a, lo, j);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	/**
	 * Rearranges the array so that {@code a[k]} contains the kth smallest key;
	 * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]};
	 * and {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to)
	 * {@code a[k]}.
	 *
	 * @param a the array
	 * @param k the rank of the key
	 * @return the key of rank {@code k}
	 * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
	 */
	public static Comparable select(Comparable[] a, int k) {
		if (k < 0 || k >= a.length) {
			comps +=2;
			throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
		}
		StdRandom.shuffle(a);
		int lo = 0, hi = a.length - 1;

		comps++;
		while (hi > lo) {
			comps++;
			int i = partition(a, lo, hi);
			comps++;
			if (i > k) {
				hi = i - 1;
			}
			else if (i < k)
				lo = i + 1;
			else
				return a[i];
		}
		return a[lo];
	}

	/***************************************************************************
	 * Helper sorting functions.
	 ***************************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		comps++;
		if (v == w)
			return false; // optimization when reference equals
		comps++;
		return v.compareTo(w) < 0;
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			comps++;
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Random rdm = new Random();
		int size = 40;
		Comparable<Integer>[] test = new Comparable[size];

		for (int i = 0; i < test.length; i++) {
			test[i] = rdm.nextInt(200);
			System.out.print(test[i] + " ");
		}

		System.out.println();

		Quick.sort(test);

		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}

		System.out.println("\n" +comps);
	}
}
