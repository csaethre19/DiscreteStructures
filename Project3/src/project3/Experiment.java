package project3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 
 * @author William Norton
 *
 */
public class Experiment {

	public static final Exp CLOUD_PATTERNS = new Exp(1, "Cloud Patterns", 5, 36);
	public static final Exp SOLAR_FLARES = new Exp(2, "Solar Flares", 9, 264);
	public static final Exp SOLAR_POWER = new Exp(3, "Solar Power", 6, 188);
	public static final Exp BINARY_STARS = new Exp(4, "Binary Stars", 8, 203);
	public static final Exp RELATIVITY = new Exp(5, "Relativity", 8, 104);
	public static final Exp SEED_VIABILITY = new Exp(6, "Seed Viability", 4, 7);
	public static final Exp SUN_SPOTS = new Exp(7, "Sun Spots", 2, 90);
	public static final Exp MICE_TUMORS = new Exp(8, "Mice Tumors", 8, 65);
	public static final Exp MICROGRAVITY = new Exp(9, "Microgravity Plant Growth", 5, 75);
	public static final Exp MICROMETERORITES = new Exp(10, "Micrometeorites", 9, 170);
	public static final Exp COSMIC_RAYS = new Exp(11, "Cosmic Rays", 7, 80);
	public static final Exp YEAST_FERMENTATION = new Exp(12, "Yeast Fermentation", 4, 27);
	public static final Exp REMOVE_THIS = new Exp(12, "REMOVE_THIS", 100, 27);
	public static final int WEIGHT_LIMIT = 700;

//	public static final int CLOUD_PATTERNS = 1;
//	public static final int SOLAR_FLARES = 2;
//	public static final int SOLAR_POWER = 3;
//	public static final int BINARY_STARS = 4;
//	public static final int RELATIVITY = 5;
//	public static final int SEED_VIABILITY = 6;
//	public static final int SUN_SPOTS = 7;
//	public static final int MICE_TUMORS = 8;
//	public static final int MICROGRAVITY = 9;
//	public static final int MICROMETERORITES = 10;
//	public static final int COSMIC_RAYS = 11;
//	public static final int YEAST_FERMENTATION = 12;
//	
//	
//	
//	
//	/**
//	 * Enter experiment number for its name
//	 * 
//	 * @param num
//	 * @return Experiment Name
//	 */
//	public static String getName(int num) {
//		switch(num) {
//		case CLOUD_PATTERNS:
//			return "Cloud Patterns";
//		case SOLAR_FLARES:
//			return "Solar Flares";
//		case SOLAR_POWER:
//			return "Solar Power";
//		case BINARY_STARS:
//			return "Binary Stars";
//		case RELATIVITY:
//			return "Relativity";
//		case SEED_VIABILITY:
//			return "Seed Viability";
//		case SUN_SPOTS:
//			return "Sun Spots";
//		case MICE_TUMORS:
//			return "Mice Tumors";
//		case MICROGRAVITY:
//			return "Microgravity";
//		case MICROMETERORITES:
//			return "Micrometerorites";
//		case COSMIC_RAYS:
//			return "Cosmic Rays";
//		case YEAST_FERMENTATION:
//			return "Yeast Fermentation";
//		default:
//			return "Invalid Number in getName";
//
//		}
//	}
//	
//	/**
//	 * Enter experiment number for its rating
//	 * 
//	 * @param num
//	 * @return rating
//	 */
//	public static int getRating(int num) {
//		switch(num) {
//		case CLOUD_PATTERNS:
//			return 5;
//		case SOLAR_FLARES:
//			return 9;
//		case SOLAR_POWER:
//			return 6;
//		case BINARY_STARS:
//			return 8;
//		case RELATIVITY:
//			return 8;
//		case SEED_VIABILITY:
//			return 4;
//		case SUN_SPOTS:
//			return 2;
//		case MICE_TUMORS:
//			return 8;
//		case MICROGRAVITY:
//			return 5;
//		case MICROMETERORITES:
//			return 9;
//		case COSMIC_RAYS:
//			return 7;
//		case YEAST_FERMENTATION:
//			return 4;
//		default:
//			return -1;
//
//		}
//	}
//
//	/**
//	 * Enter experiment number for its weight
//	 * 
//	 * @param num
//	 * @return weight
//	 */
//	public static int getWeight(int num) {
//		switch(num) {
//		case CLOUD_PATTERNS:
//			return 36;
//		case SOLAR_FLARES:
//			return 264;
//		case SOLAR_POWER:
//			return 188;
//		case BINARY_STARS:
//			return 203;
//		case RELATIVITY:
//			return 104;
//		case SEED_VIABILITY:
//			return 7;
//		case SUN_SPOTS:
//			return 90;
//		case MICE_TUMORS:
//			return 65;
//		case MICROGRAVITY:
//			return 75;
//		case MICROMETERORITES:
//			return 170;
//		case COSMIC_RAYS:
//			return 80;
//		case YEAST_FERMENTATION:
//			return 27;
//		default:
//			return -1;
//
//		}
//	}

	/**
	 * Checks every possible set of experiments and prints out the maximum rating
	 * and the experiments to send up to get that rating
	 * 
	 */
	public static List<Exp> bruteForce() {

		Exp[] set = { CLOUD_PATTERNS, SOLAR_FLARES, SOLAR_POWER, BINARY_STARS, RELATIVITY, SEED_VIABILITY, SUN_SPOTS,
				MICE_TUMORS, MICROGRAVITY, MICROMETERORITES, COSMIC_RAYS, YEAST_FERMENTATION };
		Exp[] bestRatingSubSet = bestRatingSubSet(set);
		int maxRating = totalRating(bestRatingSubSet);
		int totalWeight = totalWeight(bestRatingSubSet);	
		
		List<Exp> bruteForceList = Arrays.asList(bestRatingSubSet);


		/*
		System.out.println("Max Rating: " + maxRating);
		System.out.println("Total Weight: " + totalWeight);
		System.out.println("Experiment set below--------");
		for (int j = 0; j < bestRatingSubSet.length; j++) {

			System.out.println(bestRatingSubSet[j].getNumber() + " " + bestRatingSubSet[j].getName() + " Weight: "
					+ bestRatingSubSet[j].getWeight() + " Rating: " + bestRatingSubSet[j].getRating());

		}
		 */
		
		return bruteForceList;
	}

	public static Exp[] bestRatingSubSet(Exp[] set) {
		boolean[][] powerSet = PowerSet.createPowerSet(set.length);

		int[] weights = new int[powerSet.length];
		int[] ratings = new int[powerSet.length];

		for (int i = 0; i < powerSet.length; i++) {
			int weight = 0;
			int rating = 0;
			for (int j = 0; j < set.length; j++) {
				if (powerSet[i][j]) {
					weight += set[j].getWeight();
					if (weight > WEIGHT_LIMIT) {
						rating = 0;
						break;
					} else {
						rating += set[j].getRating();
					}
				}

			}
			weights[i] = weight;
			ratings[i] = rating;

		}
		int maxI = maxIndex(ratings);
		int sum = 0;

		for (int j = 0; j < set.length; j++) {
			if (powerSet[maxI][j]) {
				sum += 1;
			}
		}

		Exp[] newSet = new Exp[sum];
		int elementCount = 0;
		for (int j = 0; j < set.length; j++) {
			if (powerSet[maxI][j]) {
				newSet[elementCount] = new Exp(set[j].getNumber(), set[j].getName(), set[j].getRating(),
						set[j].getWeight());
				elementCount += 1;
			}
		}

		return newSet;
	}

	public static int totalWeight(Exp[] e) {
		int sum = 0;
		for (int i = 0; i < e.length; i++) {
			sum += e[i].getWeight();
		}
		return sum;
	}

	public static int totalRating(Exp[] e) {
		int sum = 0;
		for (int i = 0; i < e.length; i++) {
			sum += e[i].getRating();
		}
		return sum;
	}
	
	

	/**
	 * Searches array for maximum element and returns its index
	 * 
	 * @param a
	 * @return max index
	 */
	public static int maxIndex(int[] a) {
		if (a.length == 0) {
			return -1;
		}
		int max = a[0];
		int index = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				index = i;
			}
		}
		return index;
	}

}
