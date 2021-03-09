package project2;

public class Heap {
	private int count;

	public Heap() {
		this.count = 0;
	}

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param pq the array to be sorted
	 */
	public void sort(Comparable[] pq) {
		int n = pq.length;

		// heapify phase
		for (int k = n / 2; k >= 1; k--)
			sink(pq, k, n);

		// sortdown phase
		int k = n;
		while (k > 1) {
			exch(pq, 1, k--);
			sink(pq, 1, k);
		}
	}

	/**
	 * Returns count of comparisons made during sorting procedure.
	 * 
	 * @return comparison count
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Resets the count.
	 */
	public void clearCount() {
		this.count = 0;
	}

	/***************************************************************************
	 * Helper functions to restore the heap invariant.
	 ***************************************************************************/

	private void sink(Comparable[] pq, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			this.count++;
			if (j < n && less(pq, j, j + 1))
				j++;
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
	private boolean less(Comparable[] pq, int i, int j) {
		this.count++;
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}
}
