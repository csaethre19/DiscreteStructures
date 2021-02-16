package project1;

import java.util.Scanner;

public class ProgrammingProject1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int selection = 0;
		System.out.println("Welcome to Programming Project 1. Please enter '1', '2', or '3' to select a problem.");

		selection = input.nextInt();// read an integer from the console
		System.out.println("Selection: Problem " + selection);

		switch (selection) {// switch on console input
		case 1: {
			Problem1();// run problem number 1

			break;
		}
		case 2: {
			Problem2();// run problem number 2
			break;
		}
		case 3: {

			Problem3();// run problem number 3
			break;
		}

		default:
			throw new IllegalStateException("Sorry, invalid Input.");
		}
	}

	public static void Problem1() {
		/*
		 * Given subsets A and B of a set with n elements, use an array of booleans to
		 * ï¬�nd A, A âˆª B, A âˆ© B, A âˆ’ B, and A âŠ• B.
		 */

		/* Universal Set N = {1,2,3,4,5,6,7,8,9,10} */

		// Set A = {2,5,6,8,9}
		Boolean[] A = { false, true, false, false, true, true, false, true, true, false };
		// Set B = {4,5,6,10}
		Boolean[] B = { false, false, false, true, true, true, false, false, false, true };
		System.out.println("Set A");
		printBoolArray(A);
		System.out.println("Set B");
		printBoolArray(B);
		System.out.println("Find the Complement of A");
		Boolean[] Complement = BooleanSets.Complement(A);
		printBoolArray(Complement);

		System.out.println("Find the Union of A and B");
		Boolean[] Union = BooleanSets.Union(A, B);
		printBoolArray(Union);

		System.out.println("Find the Intersection of A and B");
		Boolean[] Intersection = BooleanSets.Intersection(A, B);
		printBoolArray(Intersection);

		System.out.println("Find the Difference of A and B");
		Boolean[] Difference = BooleanSets.Subtract(A, B);
		printBoolArray(Difference);

		System.out.println("Find the xOr of A and B");
		Boolean[] xOr = BooleanSets.Xor(A, B);
		printBoolArray(xOr);

	}

	public static void Problem2() {
		/*
		 * Given multi-sets A and B from the same universal set, ï¬�nd A âˆª B, A
		 * âˆ© B, Aâˆ’ B, and A+ B
		 */

	}

	public static void Problem3() {
		/*
		 * Given fuzzy sets A and B, ï¬�nd A, A âˆª B, and A âˆ© B
		 */

	}

	// Utility Methods
	public static void printBoolArray(Boolean[] array) {
		for (int i = 0; i < array.length; i++) {

			char toPrint;
			if (array[i]) {
				toPrint = '1';
			} else {
				toPrint = '0';
			}
			System.out.print(toPrint);
		}
		System.out.println();
	}
}
