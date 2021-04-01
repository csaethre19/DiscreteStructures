package project3;

import java.util.Comparator;

public class Exp implements Comparable<Exp> {
	private String name;
	private int rating;
	private int weight; 
	private int number;
	private double ratio;
	
	public static final Comparator<Exp> BY_WEIGHT = new CompareByWeight();
	public static final Comparator<Exp> BY_RATIO = new CompareByRatio();

	
	public Exp(int number, String name, int rating, int weight) {
		this.name = name;
		this.rating = rating;
		this.weight = weight;
		this.number = number;
		this.ratio = generateRatio();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the ratio
	 */
	public double getRatio() {
		return ratio;
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
		return this.name + " " + "Rating: " + this.rating + " Weight: " + this.weight + " Ratio: " + this.ratio;
	}
	
	public double generateRatio() {
		double ratio = (double) rating / (double) weight;
		ratio = Math.round(ratio * 1000.0) / 1000.0;
		return ratio; 
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
	
	private static class CompareByRatio implements Comparator<Exp>{
		
		@Override
		public int compare(Exp first, Exp second) {
			if(first.ratio < second.ratio)return -1;
			if(first.ratio == second.ratio)return 0;
			else return 1;

		}
	}

	
}
