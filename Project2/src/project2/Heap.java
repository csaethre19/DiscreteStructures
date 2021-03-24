package project2;

public class Heap {
	public static int count;

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param pq the array to be sorted
	 */
	public static void sort(Comparable[] pq) {
		int n = pq.length;

		// heapify phase
		for (int k = n / 2; k >= 1; k--) {
			sink(pq, k, n);
		}
		
		// sortdown phase
		int k = n;
		while (k > 1) {
			count++;
			exch(pq, 1, k--);
			sink(pq, 1, k);
		}
	}

	/**
	 * Resets the count.
	 */
	public static void clearCount() {
		count = 0;
	}

	/***************************************************************************
	 * Helper functions to restore the heap invariant.
	 ***************************************************************************/

	private static void sink(Comparable[] pq, int k, int n) {
		while (2 * k <= n) {
			count++;

			int j = 2 * k;
			count++;
			if (j < n && less(pq, j, j + 1)) {
				j++;
			}
			count++;
			if (!less(pq, k, j))
				break;
			exch(pq, k, j);
			k = j;
		}
	}

	/***************************************************************************
	 * Helper functions for comparisons and swaps. Indices are "off-by-one" to
	 * support 1-based indexing.
	 ***************************************************************************/
	private static boolean less(Comparable[] pq, int i, int j) {
		count++;
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}
}
