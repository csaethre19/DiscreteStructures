package project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The question you are to investigate is what combination of payloads gives the
 * highest overall rating
 * 
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, Cody Salmond, &
 *         Jeremiah Smith
 *
 */

public class Client {

	public static void main(String[] args) {
		// Initialize array
		List<Exp> experiments = createExperimentsList();

		// 1) If you select experiments based on weight, what is the subset of
		// experiments that you select, and what is the total rating of the experiments?
		System.out.println("Question 1:");
		System.out.println(optimizeRatingsByWeight(experiments));

		// Sorting by ratings
		sortByRatings(experiments);

		System.out.println();

		// Sorting by weight
		sortByWeight(experiments);

		System.out.println();
		// 3. select experiments based on the ratio of rating to mass

		// 4. brute force method using all the subsets
		
		Experiment.bruteForce();

	}

	private static void sortByRatings(List<Exp> experiments) {
		Collections.sort(experiments);
		displayExperiments(experiments);
	}

	private static void sortByWeight(List<Exp> experiments) {
		experiments.sort(Exp.BY_WEIGHT);
		// Display experiments by weight
		displayExperiments(experiments);
	}

	private static void displayExperiments(List<Exp> experiments) {
		for (Exp x : experiments) {
			System.out.println(x);
		}
	}

	private static List<Exp> createExperimentsList() {
		List<Exp> experiments = new ArrayList<Exp>();

		experiments.add(new Exp(1, "Cloud Patterns", 5, 36));
		experiments.add(new Exp(2, "Solar Flares", 9, 264));
		experiments.add(new Exp(3, "Solar Power", 6, 188));
		experiments.add(new Exp(4, "Binary Stars", 8, 203));
		experiments.add(new Exp(5, "Relativity", 8, 104));
		experiments.add(new Exp(6, "Seed Viability", 4, 7));
		experiments.add(new Exp(7, "Sun Spots", 2, 90));
		experiments.add(new Exp(8, "Mice Tumors", 8, 65));
		experiments.add(new Exp(9, "Microgravity", 5, 36));
		experiments.add(new Exp(10, "Micrometerorites", 9, 170));
		experiments.add(new Exp(11, "Cosmic Rays", 7, 80));
		experiments.add(new Exp(12, "Yeast Fermentation", 4, 27));
		return experiments;
	}

	/**
	 * 
	 * @param sorted
	 * @return
	 */
	public static List<Exp> optimizeRatingsByWeight(List<Exp> sorted) {
		List<Exp> experiments = new ArrayList<>();
		int weightLimit = 700;
		int currentWeight = 0;

		for (Exp x : sorted) {
			if (currentWeight + x.getWeight() <= weightLimit) {
				experiments.add(x);
				currentWeight += x.getWeight();
			}
		}
		System.out.println("Weight: " + currentWeight);
		return experiments;
		
	}

}
