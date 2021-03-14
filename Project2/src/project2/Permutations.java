package project2;

import java.util.Arrays;

public class Permutations {
	private Integer[][] arrays;
	private int n;
	private int index = 0;
	
	public Permutations(int n) {
		if (n < 0) throw new IllegalArgumentException();
		this.n = n;
		arrays = new Integer[factorial(n)][n];
	}
	
	public Integer[] getArray(int index) {
		return arrays[index];
	}

	public void permutations(Integer[] a, int size, int n) {
		if (size == 1) {
			for (int i = 0; i < a.length; i++) {
				arrays[index][i] = a[i];
			}
			//System.out.println("Index: " + index + " Array: " + Arrays.toString(arrays[index]));
			index++;
		}

		for (int i = 0; i < size; i++) {

			permutations(a, size - 1, n);

			if (size % 2 == 1) {
				int temp = (int) a[0];
				a[0] = a[size - 1];
				a[size - 1] = temp;
			}

			if (size % 2 == 0) {
				int temp = (int) a[i];
				a[i] = a[size - 1];
				a[size - 1] = temp;
			}
		}
	}

	public void printArray(Integer[] a, int n) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int factorial(int n) {
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}
}
