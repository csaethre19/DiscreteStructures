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
			selection = System.in.read() - 47;// read an integer from the console
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
		int[] universalSet = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] setA = new int[] {10,4,6,4,5,0,1,2,3,4};
		int[] setB = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println("Universal Set");
		System.out.print("{" + universalSet[0]);
		for(int i = 1; i < universalSet.length; i++) {
			System.out.print(","+universalSet[i]);
		}
		System.out.println("}");
		
		Multiset unionSet = MultiSets.Union(universalSet, setA, setB);
		
		System.out.println("Union Multi Set");
		System.out.println(unionSet);
		
		Multiset intersectionSet = MultiSets.Intersection(universalSet, setA, setB);
		System.out.println("Intersection Multi Set");
		System.out.println(intersectionSet);
		
		Multiset sumSet = MultiSets.Add(universalSet, setA, setB);
		System.out.println("Sum Multi Set");
		System.out.println(sumSet);
		
		
		Multiset differenceSet = MultiSets.Subtract(universalSet, setA, setB);
		System.out.println("Difference Multi Set");
		System.out.println(differenceSet);
		
		
		
	}
	
	private static boolean isInteger(String str) {
		if(str == null) {
			return false;
		}
		int length = str.length();
		if(length == 0) {
			return false;
		}
		int i = 0;
		if(str.charAt(0) == '-') {
			if(length == 1) {
				return false;
			}
			i = 1;
		}
		for(; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
	

}
