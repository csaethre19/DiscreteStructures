package project3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Determines combination of pay-loads that gives the highest overall rating
 * using different methods.
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, Cody Salmond, &
 *         Jeremiah Smith
 *
 */

public class Client {

	public static void main(String[] args) {
		// Initialize the set of all our experiments
		ExperimentSet experimentSet = new ExperimentSet(createInitialExperimentsList());

		// Question 1 Prompt
		System.out.println(
				"1) If you select experiments based on weight, what is the subset of experiments that you select, "
						+ "and what is the total rating of the experiments?\n");
		//configurable weight budget
		int weightBudget = 700;
		// sort set by weight
		experimentSet.SortBy(Exp.BY_WEIGHT);
		
		//build a new experiment set using the buildListByWeight method
		ExperimentSet weightSet = new ExperimentSet(buildListByWeight(experimentSet.experiments, weightBudget));
		
		//Print out our elements of the new set
		System.out.println("Elements of set: \n" + weightSet.toString());
		//print out our total Rating
		System.out.println("Total Rating: " + weightSet.getTotalRating());
		//print out our total Weight
		System.out.println("Total Weight: " + weightSet.getTotalWeight());
		System.out.println();
		
		// Question 2
		
	
		System.out.println("2) If you select experiments based on rating, "
				+ "what is the subset of experiments that you select and what is the total rating?\n");
		// Sorting by ratings
		experimentSet.SortBy(null);		
		ExperimentSet ratingsSet = new ExperimentSet(buildListByWeight(experimentSet.experiments, weightBudget));
		
		//Print out our elements of the new set
				System.out.println("Elements of set: \n" + ratingsSet.toString());
				//print out our total Rating
				System.out.println("Total Rating: " + ratingsSet.getTotalRating());
				//print out our total Weight
				System.out.println("Total Weight: " + ratingsSet.getTotalWeight());
				System.out.println();

		System.out.println();

		// Question 3
		System.out.println("3. Select experiments based on the ratio of rating to mass\n");
		// Sorting by ratings
				experimentSet.SortBy(Exp.BY_RATIO);		
				ExperimentSet ratioSet = new ExperimentSet(buildListByWeight(experimentSet.experiments, weightBudget));
				
				//Print out our elements of the new set
						System.out.println("Elements of set: \n" + ratioSet.toString());
						//print out our total Rating
						System.out.println("Total Rating: " + ratioSet.getTotalRating());
						//print out our total Weight
						System.out.println("Total Weight: " + ratioSet.getTotalWeight());
						System.out.println();

				System.out.println();

		// Question 4
		System.out.println("4. Brute force method to find maximum rating of 4096 possible subsets.");
		List<Exp> bruteForcedExperiments = Experiment.bruteForce();
		ExperimentSet bruteForcedSet = new ExperimentSet(bruteForcedExperiments);
		
		System.out.println("Elements of set: \n" + bruteForcedSet.toString());
		//print out our total Rating
		System.out.println("Total Rating: " + bruteForcedSet.getTotalRating());
		//print out our total Weight
		System.out.println("Total Weight: " + bruteForcedSet.getTotalWeight());
		System.out.println();
		
		//Question 5
		
		//Dumps out a text file with the answer to question 5
		 BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/question5.txt"));
			String line;

			 while ((line = br.readLine()) != null) {
				   System.out.println(line);
				 }
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't find question5.txt");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem reading question5.txt");

			e.printStackTrace();
		}
		

System.out.println();	}



	
	
	

	// Creates the list of experiments based on provided data
	private static List<Exp> createInitialExperimentsList() {
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
	 * Determines optimal combination of experiments not exceeding 700 kg based on
	 * specified list of experiments sorted accordingly.
	 * 
	 * @param sorted list of experiments
	 * @return list of experiments based by weight
	 */
	public static List<Exp> buildListByWeight(List<Exp> sorted, int weightLimit) {
		List<Exp> experiments = new ArrayList<>();
		int currentWeight = 0;

		for (Exp x : sorted) {
			if (currentWeight + x.getWeight() <= weightLimit) {
				experiments.add(x);
				currentWeight += x.getWeight();
			}
		}
		return experiments;

	}

}
