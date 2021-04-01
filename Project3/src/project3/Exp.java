package project3;

import java.util.Comparator;

public class Exp implements Comparable<Exp> {
	private String name;
	private int rating;
	private int weight; 
	private int number;
	public static final Comparator<Exp> BY_WEIGHT = new CompareByWeight();
	
	public Exp(int number, String name, int rating, int weight) {
		this.name = name;
		this.rating = rating;
		this.weight = weight;
		this.number = number;
	}

	
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	
	@Override
    public int compareTo(Exp o) {
        if(this.rating < o.rating) return -1;
        if(this.rating == o.rating) return 0;
        else return 1;
    }

	@Override
	public String toString() {
		return this.name + " " + "Rating: " + this.rating + " Weight: " + this.weight;
	}
	
	private static class CompareByWeight implements Comparator<Exp> {

		/**
		 * Compares two rectangles based on area.
		 */
		@Override
		public int compare(Exp first, Exp second) {
			return first.weight - second.weight;
		}

	}

	
}
