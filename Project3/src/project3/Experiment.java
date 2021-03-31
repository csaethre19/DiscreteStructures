package project3;

/**
 * The question you are to investigate is what combination of payloads gives the
 * highest overall rating
 * 
 * DATA:
 * 
 * Number Experiment Weight Rating ------------------------------------------ 1
 * Cloud Patterns 36 5 2 Solar Flares 264 9 3 Solar Power 188 6 4 Binary Stars
 * 203 8 5 Relativity 104 8 6 Seed Viability 7 4 7 Sun Spots 90 2 8 Mice Tumors
 * 65 8 9 Microgravit... 75 5 10 Micrometerorites 170 9 11 Cosmic Rays 80 7 12
 * Yeast Fermentation 27 4
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, Cody Salmond, &
 *         Jeremiah Smith
 *
 */
public class Experiment {
	public static final int CLOUD_PATTERNS = 1;
	public static final int SOLAR_FLARES = 2;
	public static final int SOLAR_POWER = 3;
	public static final int BINARY_STARS = 4;
	public static final int RELATIVITY = 5;
	public static final int SEED_VIABILITY = 6;
	public static final int SUN_SPOTS = 7;
	public static final int MICE_TUMORS = 8;
	public static final int MICROGRAVITY = 9;
	public static final int MICROMETERORITES = 10;
	public static final int COSMIC_RAYS = 11;
	public static final int YEAST_FERMENTATION = 12;
	
	public static final int WEIGHT_LIMIT = 700;
	
	
	/**
	 * Enter experiment number for its name
	 * 
	 * @param num
	 * @return Experiment Name
	 */
	public static String getName(int num) {
		switch(num) {
		case CLOUD_PATTERNS:
			return "Cloud Patterns";
		case SOLAR_FLARES:
			return "Solar Flares";
		case SOLAR_POWER:
			return "Solar Power";
		case BINARY_STARS:
			return "Binary Stars";
		case RELATIVITY:
			return "Relativity";
		case SEED_VIABILITY:
			return "Seed Viability";
		case SUN_SPOTS:
			return "Sun Spots";
		case MICE_TUMORS:
			return "Mice Tumors";
		case MICROGRAVITY:
			return "Microgravity";
		case MICROMETERORITES:
			return "Micrometerorites";
		case COSMIC_RAYS:
			return "Cosmic Rays";
		case YEAST_FERMENTATION:
			return "Yeast Fermentation";
		default:
			return "Invalid Number in getName";

		}
	}
	
	/**
	 * Enter experiment number for its rating
	 * 
	 * @param num
	 * @return rating
	 */
	public static int getRating(int num) {
		switch(num) {
		case CLOUD_PATTERNS:
			return 5;
		case SOLAR_FLARES:
			return 9;
		case SOLAR_POWER:
			return 6;
		case BINARY_STARS:
			return 8;
		case RELATIVITY:
			return 8;
		case SEED_VIABILITY:
			return 4;
		case SUN_SPOTS:
			return 2;
		case MICE_TUMORS:
			return 8;
		case MICROGRAVITY:
			return 5;
		case MICROMETERORITES:
			return 9;
		case COSMIC_RAYS:
			return 7;
		case YEAST_FERMENTATION:
			return 4;
		default:
			return -1;

		}
	}

	/**
	 * Enter experiment number for its weight
	 * 
	 * @param num
	 * @return weight
	 */
	public static int getWeight(int num) {
		switch(num) {
		case CLOUD_PATTERNS:
			return 36;
		case SOLAR_FLARES:
			return 264;
		case SOLAR_POWER:
			return 188;
		case BINARY_STARS:
			return 203;
		case RELATIVITY:
			return 104;
		case SEED_VIABILITY:
			return 7;
		case SUN_SPOTS:
			return 90;
		case MICE_TUMORS:
			return 65;
		case MICROGRAVITY:
			return 75;
		case MICROMETERORITES:
			return 170;
		case COSMIC_RAYS:
			return 80;
		case YEAST_FERMENTATION:
			return 27;
		default:
			return -1;

		}
	}
	
	/**
	 * Checks every possible set of experiments and
	 * prints out the maximum rating and the experiments 
	 * to send up to get that rating
	 * 
	 */
	public static void bruteForce() {
		System.out.println("Brute force method to find maximum rating.");
		
		int[] set = {CLOUD_PATTERNS,SOLAR_FLARES,SOLAR_POWER,BINARY_STARS, RELATIVITY,
				SEED_VIABILITY,SUN_SPOTS,MICE_TUMORS,MICROGRAVITY,MICROMETERORITES,
				COSMIC_RAYS,YEAST_FERMENTATION};
		boolean[][] powerSet = PowerSet.createPowerSet(set.length);
		
		int[] weights = new int[powerSet.length];
		int[] ratings = new int[powerSet.length];
		
		for(int i = 0; i < powerSet.length; i++) {
			int weight = 0;
			int rating = 0;
			for(int j = 0; j < set.length; j++) {
				if(powerSet[i][j]) {
					weight += getWeight(set[j]);
					if(weight > WEIGHT_LIMIT) {
						rating = 0;
						break;
					}
					else {
						rating += getRating(set[j]);
					}
				}
				
			}
			weights[i] = weight;
			ratings[i] = rating;
		}
		
		
		int maxI = maxIndex(ratings);
		
		int maxRating = ratings[maxI];
		int totalWeight = weights[maxI];
		
		
		System.out.println("Max Rating: " + maxRating);
		System.out.println("Total Weight: " + totalWeight);
		System.out.println("Experiment set below--------");
		for(int j = 0; j < set.length; j++) {
			if(powerSet[maxI][j]) {
				System.out.println(set[j] + " " + getName(set[j]) + " Weight: " +
				getWeight(set[j]) + " Rating: " + getRating(set[j]));
			}
		
			
		}

	}

	/**
	 * Searches array for maximum element and returns its index
	 * 
	 * @param a
	 * @return max index
	 */
	public static int maxIndex(int[] a) {
		if(a.length == 0) {
			return -1;
		}
		int max = a[0];
		int index = 0;
		for(int i = 1; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
				index = i;
			}
		}
		return index;
	}

}
