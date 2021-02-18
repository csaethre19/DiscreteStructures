package project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Creates multi sets <code>setA</code> and <code>setB</code> and performs set
 * operations on them. Set Operations: Union, Intersection, Subtraction, &
 * Addition.
 * 
 * @author Jeremiah Smith & William Norton
 *
 */
public class Multisets {

	private int[] universalSet = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5 };

	int[] setA = {1, 2, 3, 3, 5, 5, 5,7};
	int[] setB = {2, 3, 4, 4, 4, 4, 5, 5,};

	public static void main(String[] args) {

		Multisets ms = new Multisets();

		System.out.println("Union: ");
		System.out.println(ms.union());

		System.out.println("Intersect: ");
		System.out.println(ms.intersect());
		
		System.out.println("subtraction: ");
		System.out.println(ms.subtraction());

		System.out.println("addition: ");
		System.out.println(ms.addition());
	}

	// AUB FINISHED
	public ArrayList<Integer> union() {
		ArrayList<Integer> union = new ArrayList<Integer>();

		for (int i = 0; i < setA.length; i++) {
			union.add(setA[i]);
		}

		for (int j = 0; j < setB.length; j++) {
			union.add(setB[j]);
		}

		Collections.sort(union);
		return union;
	}

	//AnB ISSUE Nmbers are getting comapred twice and then duplicated 
	public ArrayList<Integer> intersect() {
		
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < setA.length; i++) {

			for (int j = 0; j < setB.length; j++) {
				if(setA[i] == setB[j]) {
					result.add(setA[i]); //maybe after set value to bad value
					setA[i] = 0;
					setB[j] = 0;
					break;
				}
			}
		}
		return result;
	}

	// A-B FINISHED
	public ArrayList<Integer> subtraction() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean truthValue;
		for (int i = 0; i < setA.length; i++) {
			truthValue = false;
			for (int j = 0; j < setB.length; j++) {
				if (setA[i] == setB[j])
					truthValue = true;
			}
			if (!truthValue)
				result.add(setA[i]);
		}
		return result;
	}

	// Finished?
	public ArrayList<Integer> addition() {
		ArrayList<Integer> addition = new ArrayList<Integer>();

		for (int i = 0; i < setA.length; i++) {
			addition.add(setA[i]);
		}

		for (int j = 0; j < setB.length; j++) {
			addition.add(setB[j]);
		}

		Collections.sort(addition);
		return addition;
	}

	public void printSets() {
		System.out.println("Universal Set: " + Arrays.toString(universalSet));
		System.out.println("Set A: " + Arrays.toString(setA));
		System.out.println("Set B: " + Arrays.toString(setB));
	}
}
