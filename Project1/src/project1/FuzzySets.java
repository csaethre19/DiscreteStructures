package project1;

import java.util.HashMap;

/**
 * Creates fuzzy sets <code>setA</code> and <code>setB</code> and performs set
 * operations on them. Set Operations: Union, Intersection, and Complement.
 * 
 * @author Marshall Ringwood & Charlotte Saethre
 *
 */
public class FuzzySets {
	private static HashMap<String, Double> setA;
	private static HashMap<String, Double> setB;

	/**
	 * Initializes fuzzy sets <code>setA</code> and <code>setB</code> with values
	 * representing key and degree of membership.
	 */
	public FuzzySets() {
		setA.put("A", .60);
		setA.put("B", .40);
		setA.put("C", .45);
		setA.put("D", .30);
		setB.put("A", .70);
		setB.put("B", .20);
		setB.put("C", .50);
		setB.put("D", .90);
	}

	/**
	 * Performs union operation on <code>setA</code> and <code>setB</code> and
	 * returns the result in a HashMap.
	 * 
	 * @param setA first set of union
	 * @param setB second set of union
	 * @return union of the two sets
	 */
	public static HashMap<String, Double> Union() {
		HashMap<String, Double> union = new HashMap<>();
		setA.forEach((k, v) -> {
			if (setB.get(k) < v) {
				union.put(k, v);
			}
			else {
				union.put(k, setB.get(k));
			}
		});
		return union;
	}

	/**
	 * Performs intersection operation on <code>setA</code> and <code>setB</code>
	 * and returns the result in a HashMap.
	 * 
	 * @param setA first set of intersection
	 * @param setB second set of intersection
	 * @return intersection of the two sets
	 */
	public static HashMap<String, Double> Intersection() {
		HashMap<String, Double> intersection = new HashMap<>();
		for (String key : setA.keySet()) {
			if (setA.get(key) < setB.get(key)) intersection.put(key, setA.get(key));
			else intersection.put(key, setB.get(key));
		}
		return intersection;
	}

	/**
	 * Computes complement of a <code>setA</code> and returns the result in a HashMap.
	 * 
	 * @param setA set to compute complement
	 * @return complement of set
	 */
	public static HashMap<String, Double> Complement() {
		// TODO
		return null;
	}

	/**
	 * Computes the set operations on the fuzzy sets and displays the results.
	 */
	public void printResults() {
		// TODO
	}
	
	private String convert(HashMap<String, Double> set) {
		return null; // TODO
	}

}
