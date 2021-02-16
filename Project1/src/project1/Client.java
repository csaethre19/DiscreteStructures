package project1;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, Cody Salmond, &
 *         Jeremiah Smith
 * 
 */
public class Client {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int selection = 0;

		do {
			System.out.println(
					"\nWelcome to Programming Project 1. Please enter '1', '2', or '3' to select a problem. Enter 0 to quit.");

			selection = input.nextInt();// read an integer from the console
			System.out.println("Selection: Problem " + selection + "\n");
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
				System.out.println("Goodbye");
			}
		} while (selection != 0);
		input.close();

	}

	/**
	 * Performs set operations on given subsets A and B of a set with n elements.
	 * Set Operations: Complement, Union, Intersection, Difference, and Xor.
	 * 
	 */
	public static void Problem1() {
		Boolean[] A = { false, true, false, false, true, true, false, true, true, false };
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

	/**
	 * Performs set operations on multisets A and B from same universal set. Set
	 * Operations: Union, Intersection, Difference, and Addition.
	 * 
	 */
	public static void Problem2() {
		// TODO
	}

	/**
	 * Performs set operations on fuzzy sets A and B. Set Operations: Complement,
	 * Union, and Intersection.
	 * 
	 */
	public static void Problem3() {
		FuzzySets sets = new FuzzySets();
		sets.printResults();
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
