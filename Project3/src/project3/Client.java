package project3;

/**
 * The question you are to investigate is what combination of payloads gives the
 * highest overall rating
 * 
 * DATA:
 * 
 * Number	Experiment			Weight	Rating
 * ------------------------------------------
 * 1		Cloud Patterns		36		5
 * 2		Solar Flares		264		9
 * 3		Solar Power			188		6
 * 4		Binary Stars		203		8
 * 5		Relativity			104		8
 * 6		Seed Viability		7		4
 * 7		Sun Spots			90		2
 * 8		Mice Tumors			65		8
 * 9		Microgravit...		75		5
 * 10		Micrometerorites	170		9
 * 11		Cosmic Rays			80		7
 * 12		Yeast Fermentation	27		4
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, Cody Salmond, &
 *         Jeremiah Smith
 *
 */

public class Client {

	public static void main(String[] args) {
		// 1. chose items with the highest rating first
		// 2. select items from the lightest to the most massive
		// 3. select experiments based on the ratio of rating to mass
		// 4. brute force method using all the permutations
		
		int[] set = {1,2,3,4,5,6,7,8,9,10,11,12};
		boolean[][] powerSet = PowerSet.createPowerSet(12);
		for(int i = 0; i < powerSet.length; i++) {
			for(int j = 0; j < powerSet[0].length; j++) {
				if(powerSet[i][j]) {
					System.out.print(1);
				}
				else {
					System.out.print(0);
				}
				
			}
			System.out.println();
		}
		
		
	}

}
