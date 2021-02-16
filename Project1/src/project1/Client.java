package project1;

import java.io.IOException;
/**
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
			selection = System.in.read();// read an integer from the console
		} catch (IOException e) {
			System.out.println("Invalid Input");
		}
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
			throw new IllegalStateException("Something Horrible has Happened");
		}
		
	}

	/**
	 * Performs set operations on given subsets A and B of a set with n elements.
	 * Set Operations: Complement, Union, Intersection, Difference, and Xor.
	 * 
	 */
	public static void Problem1() {
		// TODO
	}

	/**
	 * Performs set operations on multisets A and B from same universal set.
	 * Set Operations: Union, Intersection, Difference, and Addition.
	 * 
	 */
	public static void Problem2() {
		// TODO
	}

	/**
	 * Performs set operations on fuzzy sets A and B.
	 * Set Operations: Complement, Union, and Intersection.
	 * 
	 */
	public static void Problem3() {
		FuzzySets sets = new FuzzySets();
		sets.printResults();
	}

}
