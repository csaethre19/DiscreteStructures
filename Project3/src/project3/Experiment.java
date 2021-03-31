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
	public static final int CLOAD_PATTERNS = 1;
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

	public static String getName(int num) {
		switch (num) {
		case CLOAD_PATTERNS:
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

	public static int getRating(int num) {
		switch (num) {
		case CLOAD_PATTERNS:
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

	public static int getWeight(int num) {
		switch (num) {
		case CLOAD_PATTERNS:
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

}
