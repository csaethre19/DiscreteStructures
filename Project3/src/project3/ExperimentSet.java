package project3;

import java.util.Comparator;
import java.util.List;

public class ExperimentSet {

	private int totalWeight;
	private int totalRating;
	public List<Exp> experiments;

	public ExperimentSet(List<Exp> experiments) {
		this.experiments = experiments;
		this.totalWeight = sumExperimentsWeight(experiments);
		this.totalRating = sumExperimentsRating(experiments);
	}

	/** @return total Weight of every Experiment */
	public int getTotalWeight() {
		return totalWeight;
	}

	/** @return total Rating of every Experiment */
	public int getTotalRating() {
		return totalRating;
	}

	/**
	 * Sorts the Experiment List by the given Comparator
	 * 
	 * @param comparator to sort by
	 * @return the experiments list
	 */
	public List<Exp> SortBy(Comparator t) {
		experiments.sort(t);
		return experiments;
	}

	/**
	 * Adds the rating of every experiment in the set and returns it
	 * 
	 * @param List of Experiments
	 * @return Total Rating
	 */
	private int sumExperimentsRating(List<Exp> experiments) {

		int totalRating = 0;
		for (Exp exp : experiments) {
			totalRating += exp.getRating();
		}
		return totalRating;

	}

	/**
	 * Adds the weight of every experiment in the set and returns it
	 * 
	 * @param List of Experiments
	 * @return Total Weight
	 */
	private int sumExperimentsWeight(List<Exp> experiments) {
		int totalWeight = 0;
		for (Exp exp : experiments) {
			totalWeight += exp.getWeight();
		}
		return totalWeight;

	}

	/**
	 * @return Formatted Table of all experiments in addition to the total rating
	 *         and weight
	 */
	@Override
	public String toString() {
		String outputString  = "Experiment              |Rtng |Weight  |Ratio\n";

		outputString        += "==============================================\n";

		for (Exp x : experiments) {

			outputString += String.format("%-15s \t| %3d |\t %5d | %.3f\n",
					x.getName(), x.getRating(), x.getWeight(), x.getRatio());

		}
		return outputString;

	}
}
