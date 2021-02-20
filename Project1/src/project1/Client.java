package project1;

import java.util.Scanner;

/**
 * Utilizes classes <code>BooleanSets</code>, <code>FuzzySets</code>, and
 * <code>Multisets</code> to perform the computations of the specified set
 * operations for each problem of Project 1.
 * 
 * Discrete Structures CSIS 2430
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, 
 * Cody Salmond, Jeremiah Smith, & Alvaro Zarate
 * 
 */
public class Client {

	public static void main(String[] args) {

		int selection = 0;
		System.out.println("Welcome to Programming Project 1. Please enter '1', '2', or '3' to select a problem.");
		try {
			selection = System.in.read() - 48;// read an integer from the console
		} catch (IOException e) {
			System.out.println("Invalid Input");
		}
		switch (selection) {// switch on console input
		case 1: {
			Problem1();// run problem number 1
		Scanner input = new Scanner(System.in);
		String selection = "";
		System.out.println("Welcome to Programming Project 1.\n");
		do {
			System.out.println("Please enter '1', '2', or '3' to select a problem. Enter 'q' to quit.");
			selection = input.next();// read in user input from the console
			if (selection.equals("1"))
				Problem1();
			else if (selection.equals("2"))
				Problem2();
			else if (selection.equals("3"))
				Problem3();
			else if (selection.equals("q"))
				break;
			else
				System.out.println("\nPlease enter a valid response\n");
			System.out.println();
		} while (!selection.equals("q"));
		input.close();

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

		default:{
			throw new IllegalStateException("Something Horrible has Happened");
		}
		}

	}

	/**
	 * Performs set operations on given subsets A and B of a set with n elements.
	 * Set Operations: Complement, Union, Intersection, Difference, and Xor.
	 * 
	 */
	public static void Problem1() {
		System.out.println("Problem 1:");
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
	 * Performs set operations on multisets A and B from same universal set.
	 * Set Operations: Union, Intersection, Difference, and Addition.
	 * 
	 */
	public static void Problem2() {
		System.out.println("Problem 2:");
		Multisets ms = new Multisets();
		ms.printSets();
		System.out.println("Union: ");
		System.out.println(ms.union());

		System.out.println("Intersect: ");
		System.out.println(ms.intersect());

		System.out.println("subtraction: ");
		System.out.println(ms.subtraction());

		System.out.println("addition:");
		System.out.println(ms.addition());
		
		int[] universalSet = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] setA = new int[] {10,4,6,4,5,0,1,2,3,4};
		int[] setB = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println("Universal Set");
		System.out.print("{" + universalSet[0]);
		for(int i = 1; i < universalSet.length; i++) {
			System.out.print(","+universalSet[i]);
		}
		System.out.println("}");
		System.out.println("Set A Multiplicities of Universal Set");
		System.out.print("{" + setA[0]);
		for(int i = 1; i < setA.length; i++) {
			System.out.print(","+setA[i]);
		}
		System.out.println("}");
		
		System.out.println("Set B Multiplicities of Universal Set");
		System.out.print("{" + setB[0]);
		for(int i = 1; i < setB.length; i++) {
			System.out.print(","+setB[i]);
		}
		System.out.println("}");
		
		Multiset unionSet = MultiSets.Union(universalSet, setA, setB);
		
		System.out.println("Union Multiset");
		System.out.println(unionSet);
		
		Multiset intersectionSet = MultiSets.Intersection(universalSet, setA, setB);
		System.out.println("Intersection Multiset");
		System.out.println(intersectionSet);
		
		Multiset sumSet = MultiSets.Add(universalSet, setA, setB);
		System.out.println("Sum Multiset");
		System.out.println(sumSet);
		
		
		Multiset differenceSet = MultiSets.Subtract(universalSet, setA, setB);
		System.out.println("Difference Multiset");
		System.out.println(differenceSet);
	}

	/**
	 * Performs set operations on fuzzy sets A and B.
	 * Set Operations: Complement, Union, and Intersection.
	 * 
	 */
	public static void Problem3() {
		System.out.println("Problem 3:");
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
