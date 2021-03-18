package project2;

import java.util.Arrays;

/**
 * Test Driver
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, Cody Salmond, &
 *         Jeremiah Smith
 *
 */
public class Client {

	public static void main(String[] args) {
		// Example
		Integer[] a = { 3, 2, 0, 1, 12, 13, 20, 45, 99, 100, 101 };
		Integer[] b = { 33, 44, 55, 12, 1, 4, 56, 77, 12, 99 };

		Merge.sort(a);
		Quick.sort(a);

		// Testing Heap Counter
		Heap.sort(a);
		System.out.println("Heapsort Comparison a: " + Heap.count);
		Heap.clearCount();
		Heap.sort(b);
		System.out.println("Heapsort Comparison b: " + Heap.count);
		Heap.clearCount();
		
		System.out.println();
		
		// Testing array generator
		int n = 5;
		Integer[] perms = new Integer[n];

		for (int i = 0; i < n; i++) {
			perms[i] = i;
		}

		Permutations p = new Permutations(perms);
		
		// Using first permutation array and testing heap count on it
		Integer[] x = p.getArray(20);
		System.out.println("Array at index 20: " + Arrays.toString(x));
		
		Heap.sort(x);
		System.out.println("Heapsort Comparison x: " + Heap.count);
		
		Quick.sort(x);
		System.out.println("Quicksort Comparison x: " + Quick.comps);

		
		// Testing permutations
		Permutations p2 = new Permutations(4);
		System.out.print("Permutations of: " );
		p2.printArray(p2.getArray(0));
		System.out.println("Below----------------");
		p2.printPermutations();
		
		
	}

}
