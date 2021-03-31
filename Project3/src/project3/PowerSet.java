package project3;

import java.lang.Math;

public class PowerSet {

	static boolean[][] createPowerSet(int cardinality) {

		if (cardinality < 0) {
			return new boolean[0][0];
		}

		boolean[][] powerSet = new boolean[(int) Math.pow(2, cardinality)][cardinality];
		if (cardinality == 0) {
			return powerSet;
		}

		for (int i = 0; i < powerSet[0].length; i++) {
			powerSet[0][i] = false;

		}

		for (int i = 1; i < powerSet.length; i++) {

			for (int j = 0; j < powerSet[0].length; j++) {
				powerSet[i][j] = powerSet[i - 1][j];
			}
			if (powerSet[i][powerSet[0].length - 1] == true) {
				powerSet[i][powerSet[0].length - 1] = false;
				boolean carry = true;
				int iterator = powerSet[0].length - 2;
				while (carry) {
					if (powerSet[i][iterator] == true) {
						powerSet[i][iterator] = false;
						iterator -= 1;
					} else {
						powerSet[i][iterator] = true;
						carry = false;
					}
				}

			} else {
				powerSet[i][powerSet[0].length - 1] = true;
			}

		}

		return powerSet;

	}

}
