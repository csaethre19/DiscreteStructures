package project3;

import java.util.Comparator;

/**
 * Describes an experiment based on the data provided for Project 3.
 * 
 * @author Jeremiah Smith
 *
 */
public class Exp implements Comparable<Exp> {
	private String name;
	private int rating;
	private int weight;
	private int number;
	private double ratio;

	public static final Comparator<Exp> BY_WEIGHT = new CompareByWeight();
	public static final Comparator<Exp> BY_RATIO = new CompareByRatio();

	/**
	 * Initializes the fields <code>number</code>, <code>name</code>,
	 * <code>rating</code>, <code>weight></code>, and generates the ratio of a
	 * given experiment.
	 * 
	 * @param number
	 * @param name
	 * @param rating
	 * @param weight
	 */
	public Exp(int number, String name, int rating, int weight) {
		this.name = name;
		this.rating = rating;
		this.weight = weight;
		this.number = number;
		this.ratio = generateRatio();
	}

	/**
	 * Returns the name of the experiment.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the ratio of rating to weight of the experiment.
	 * 
	 * @return the ratio
	 */
	public double getRatio() {
		return ratio;
	}

	/**
	 * Returns the rating specified by the experiment.
	 * 
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Returns the weight specified by the experiment.
	 * 
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Returns the number associated with the experiment.
	 * 
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Compares one experiment to another based on rating.
	 */
	@Override
	public int compareTo(Exp o) {
		if (this.rating < o.rating)
			return -1;
		if (this.rating == o.rating)
			return 0;
		else
			return 1;
	}

	@Override
	public String toString() {
		return this.name + " " + "Rating: " + this.rating + " Weight: " + this.weight + " Ratio: " + this.ratio;
	}

	/**
	 * Generates ratio of rating to weight.
	 * 
	 * @return the ratio
	 */
	public double generateRatio() {
		double ratio = (double) rating / (double) weight;
		ratio = Math.round(ratio * 1000.0) / 1000.0;
		return ratio;
	}

	private static class CompareByWeight implements Comparator<Exp> {

		/**
		 * Compares two experiments based on their weights.
		 */
		@Override
		public int compare(Exp first, Exp second) {
			return first.weight - second.weight;
		}

	}

	private static class CompareByRatio implements Comparator<Exp> {

		/**
		 * Compares two experiments based on their ratios.
		 */
		@Override
		public int compare(Exp first, Exp second) {
			if (first.ratio < second.ratio)
				return -1;
			if (first.ratio == second.ratio)
				return 0;
			else
				return 1;

		}
	}

}
