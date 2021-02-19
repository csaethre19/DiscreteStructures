package project1;

/**
 * Creates multi sets <code>setA</code> and <code>setB</code> and performs set
 * operations on them. Set Operations: Union, Intersection, Subtraction, &
 * Addition.
 * 
 * @author Jeremiah Smith & William Norton
 *
 */
public class MultiSets {
	/**
	 * Performs union operation on <code>setA</code> and <code>setB</code> and
	 * returns the result as a Multiset.
	 * 
	 * @param setA first set of union
	 * @param setB second set of union
	 * @return union of the two sets
	 */
	public static Multiset Union(int[] universalSet, int[] setA, int[]  setB) {
		int[] unionSet = new int[universalSet.length];
		for(int i = 0; i < setA.length; i++) {
			unionSet[i] = Math.max(setA[i],setB[i]);
		}
		return new Multiset(universalSet,unionSet);
	}

	/**
	 * Performs intersection operation on <code>setA</code> and <code>setB</code>
	 * and returns the result as a Multiset.
	 * 
	 * @param setA first set of intersection
	 * @param setB second set of intersection
	 * @return intersection of the two sets
	 */
	public static Multiset Intersection(int[] universalSet, int[]  setA, int[]  setB) {
			int[] intersectionSet = new int[universalSet.length];
			for(int i = 0; i < setA.length; i++) {
				intersectionSet[i] = Math.min(setA[i],setB[i]);
			}
			return new Multiset(universalSet,intersectionSet);
		}


	/**
	 * Performs addition operation on <code>setA</code> and <code>setB</code> and
	 * returns the result as a Multiset.
	 * 
	 * @param setA first set of addition
	 * @param setB second set of addition
	 * @return the sum of the sets
	 */
	public static Multiset Add(int[] universalSet, int[]  setA, int[]  setB) {
		int[] sumSet = new int[universalSet.length];
		for(int i = 0; i < setA.length; i++) {
			sumSet[i] = setA[i] + setB[i];
		}
		return new Multiset(universalSet,sumSet);
	}

	/**
	 * Performs subtraction operation on <code>setA</code> and <code>setB</code> and
	 * returns the result as a Multiset.
	 * 
	 * @param setA first set of subtraction
	 * @param setB second set of subtraction
	 * @return the difference of the sets
	 */
	public static Multiset Subtract(int[] universalSet, int[]  setA, int[]  setB) {
		int[] sumSet = new int[universalSet.length];
		for(int i = 0; i < setA.length; i++) {
			sumSet[i] = Math.max(0,setA[i] - setB[i]);
		}
		return new Multiset(universalSet,sumSet);
	}



}
