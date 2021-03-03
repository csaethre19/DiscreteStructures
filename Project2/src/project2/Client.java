package project2;

/**
 * Test Driver
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, 
 * Cody Salmond, & Jeremiah Smith
 *
 */
public class Client {

	public static void main(String[] args) {
		// Example
		Integer[] a = {3, 2, 0, 1};
		Merge.sort(a);
		Quick.sort(a);
		Heap.sort(a);
		// TODO
		// Need Shaker Sort class code
		// Need array generator for all permutations based on N
		// Need to add methods to sort classes that keeps track of comparisons made
	}

}
