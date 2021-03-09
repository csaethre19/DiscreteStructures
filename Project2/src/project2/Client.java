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
		Integer[] a = {3, 2, 0, 1, 12, 13, 20, 45, 99, 100, 101};
		Integer[] b = {33, 44, 55, 12, 1, 4, 56, 77, 12, 99};
		
		Merge.sort(a);
		Quick.sort(a);
		
		Heap heap = new Heap();
		heap.sort(a);
		System.out.println("Comparison a: " + heap.getCount());
		heap.clearCount();
		heap.sort(b);
		System.out.println("Comparison b: " + heap.getCount());
		// TODO
		// Need Shaker Sort class code
		// Need array generator for all permutations based on N
		// Need to add methods to sort classes that keeps track of comparisons made
	}

}
