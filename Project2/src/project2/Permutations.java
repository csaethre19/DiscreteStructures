package project2;

/**
 * Generates every permutation of an array and stores each permutation as an
 * array
 * 
 * @author Jeremiah Smith and William N
 *
 */
public class Permutations {
	private Integer[][] arrays;
	private int n;
	private int index = 0;

	public Permutations(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		this.n = n;
		arrays = new Integer[factorial(n)][n];
		Integer[] a = new Integer[n];
		loadArray(a);
		permutations(a, n, n);
	}

	/**
	 * Loads array with whole numbers increasing in size starting at 0
	 * 
	 * @param a
	 */
	public static void loadArray(Integer[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
	}

	public Integer[] getArray(int index) {
		return arrays[index];
	}

	public Integer[][] getPermutations() {
		return this.arrays;
	}

	public void permutations(Integer[] a, int size, int n) {
		if (size == 1) {
			for (int i = 0; i < a.length; i++) {
				arrays[index][i] = a[i];
			}
			index++;
		}
		for (int i = 0; i < size; i++) {

			permutations(a, size - 1, n);

			if (size % 2 == 1) {
				int temp = a[0];
				a[0] = a[size - 1];
				a[size - 1] = temp;
			}

			if (size % 2 == 0) {
				int temp = a[i];
				a[i] = a[size - 1];
				a[size - 1] = temp;
			}
		}
	}

	/**
	 * 
	 * @param a
	 */
	public void printArray(Integer[] a) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * prints out permutations
	 * 
	 */
	public void printPermutations() {
		for (int i = 0; i < arrays.length; i++) {
			printArray(getArray(i));
		}
	}

	public static int factorial(int n) {
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}
}
