/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5        Comment: yes, tried to name everything as comprehensible as possible 
 2. Did I indent the code appropriately?
        Mark out of 5: 5        Comment: yes, everything should be properly indented
 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:   20       Comment: yes, passed through everything correctly, I get the right output and return value
 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:   20      Comment: yes, invoked everything correctly, works fine
 5. Did I calculate and/or check triangle numbers correctly?
       Mark out of 15:    15      Comment:yes, everything checked correctly i get the right output
 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
       Mark out of 10:  10        Comment:yes, MAX_VALUE tells it when to stop
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20: 20       Comment: yes, all 5 of them print correctly
 8. How well did I complete this self-assessment?
        Mark out of 5:  5      Comment: excellently, there is nothing else I can possibly think of adding to this
 Total Mark out of 100 (Add all the previous marks): 100
*/
public class TriangStars {
	public static void main(String[] args) {
		long triangleNumber = 0;
		for (long number = 1; triangleNumber >= 0; number++) {
			triangleNumber = triangleNumber(number, triangleNumber);
			if (triangleNumber > Integer.MAX_VALUE) {
				System.exit(0);
			}
			if (isStarNumber(triangleNumber) == true) {
				System.out.println(triangleNumber);
			}

		}

	}

	public static boolean isStarNumber(long possibleStarNumber) {
		long starNumber = 0;
		for (int n = 1; starNumber < possibleStarNumber; n++) {
			starNumber = (((6 * n) * (n - 1)) + 1);
		}
		if (possibleStarNumber == starNumber) {
			return true;
		} else {
			return false;
		}

	}

	public static long triangleNumber(long i, long previous) {
		return previous + i;
	}
}
