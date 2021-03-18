package project2;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * Test Driver
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, Cody Salmond, &
 *         Jeremiah Smith
 *
 */
public class Client {

	public static void main(String[] args) {
		computeSortComparisons(4);
		computeSortComparisons(6);
		computeSortComparisons(8);

	}

	private static void computeSortComparisons(int n) {
		Permutations p = new Permutations(n);

		// Loop through all arrays, call each sort method on them, and save the
		// comparison counts into array
		// Determine best 10 cases, worst 10 cases, and average compares and display
		// information

		// HEAP
		List<Integer> heapComparisons = collectHeapComparisons(p);
		Queue<Integer> best10 = deteremineBest10(heapComparisons);
		Queue<Integer> worst10 = determineWorst10(heapComparisons);
		System.out.println("Best 10 comparisons for HeapSort for n = " + n + ":");
		displayComparisons(best10);
		System.out.println();
		System.out.println("Worst 10 comparisons for HeapSort:");
		displayComparisons(worst10);
		System.out.println();
		System.out.println("Average comparisons for HeapSort: " + computeAverage(heapComparisons));
		System.out.println();

		// QUICK
		List<Integer> quickComparisons = collectQuickComparisons(p);
		best10 = deteremineBest10(quickComparisons);
		worst10 = determineWorst10(quickComparisons);
		System.out.println("Best 10 comparisons for QuickSort for n = " + n + ":");
		displayComparisons(best10);
		System.out.println();
		System.out.println("Worst 10 comparisons for QuickSort:");
		displayComparisons(worst10);
		System.out.println();
		System.out.println("Average comparisons for QuickSort: " + computeAverage(quickComparisons));
		System.out.println();

		// MERGE

		// SHAKER
	}

	private static void displayComparisons(Queue<Integer> q) {
		for (Integer item : q) {
			System.out.print(item + " ");
		}
	}

	private static List<Integer> collectHeapComparisons(Permutations p) {
		List<Integer> comparisons = new ArrayList<>();
		for (int i = 0; i < p.getPermutations().length; i++) {
			Heap.sort(p.getArray(i));
			comparisons.add(Heap.count);
			Heap.clearCount();
		}
		return comparisons;
	}

	private static List<Integer> collectQuickComparisons(Permutations p) {
		List<Integer> comparisons = new ArrayList<>();
		for (int i = 0; i < p.getPermutations().length; i++) {
			Quick.sort(p.getArray(i));
			comparisons.add(Quick.comps);
			Quick.clearCount();
		}
		return comparisons;
	}

	private static Queue<Integer> determineWorst10(List<Integer> comparisons) {
		MaxPQ<Integer> maxPq = new MaxPQ<Integer>();
		for (Integer i : comparisons) {
			maxPq.insert(i);
		}
		Queue<Integer> worst10 = new Queue<>();
		for (int i = 0; i < 10; i++) {
			worst10.enqueue(maxPq.delMax());
		}
		return worst10;
	}

	private static Queue<Integer> deteremineBest10(List<Integer> comparisons) {
		MinPQ<Integer> minPq = new MinPQ<Integer>();
		for (Integer i : comparisons) {
			minPq.insert(i);
		}
		Queue<Integer> best10 = new Queue<>();
		for (int i = 0; i < 10; i++) {
			best10.enqueue(minPq.delMin());
		}
		return best10;
	}

	private static int computeAverage(List<Integer> comparisons) {
		int avg = 0;
		for (int i = 0; i < comparisons.size(); i++) {
			avg += comparisons.get(i);
		}
		return avg / comparisons.size();
	}
}
