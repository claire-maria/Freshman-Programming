package highScores;

import java.util.Arrays;
import java.util.Scanner;

public class HighScores {
	public static int usedNumbers = 0 ;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println(
				"How many scores do you want to keep track of?. Please enter 'exit' to exit the program at any time.");
		if (input.hasNext("exit")) {
			System.exit(0);
		}

		int numberOfScores = input.nextInt();
		int[] array = new int[numberOfScores];

		initialiseHighScores(array); // This only sorts the digits entered until
										// the specified amount of digits is
										// reached
		for (int count = 0; ; count++) {
			System.out.println(" What is the score?");
			if (input.hasNext("exit")) {
				System.exit(0);
			}

			int score = input.nextInt();

			array = insertScore(array, count, score);
			Arrays.sort(array);
			reverseArray(array);

			printHighScores(array);
		}
		

	}

	public static int[] reverseArray(int[] array) {
		for (int index = 0; index < array.length / 2; index++) {
			int temporary = array[index];
			array[index] = array[array.length - index - 1];
			array[array.length - index - 1] = temporary;
		}
		return array;
	}

	public static int[] insertScore(int[] array, int count, int score) {
		int lowestValueLocation = 0 ;
		usedNumbers += 1;
		if(usedNumbers < array.length){
		array[count] = score;
		}
		else{
			for(int index = 0 ; index < array.length ; index++){
				if(array[lowestValueLocation] > array[index]){
					lowestValueLocation = index;
				}
			}
			if(array[lowestValueLocation] < score){
				array[lowestValueLocation] = score;
			}
			
		}
		return array;
		
	}

	public static void initialiseHighScores(int[] array) {
		if (array != null) {
			Arrays.fill(array, 0);
		} else {
			System.out.println("Null array.");
		}
	}

	public static boolean isHigherThan(int score, int previousScore) {

		if (score > previousScore) {
			return true;

		} else {
			return false;
		}

	}

	public static void printHighScores(int[] array) {
		if (array[array.length - 1] != 0) {
			System.out.print("The high scores are ");
			for (int i = 0; i < array.length; i++) {

				if (i > 0) {
					System.out.print(",");

				}
				System.out.print(" " + array[i] + ".");
			}

		} else {
			System.out.print("The high scores are ");
			for (int index = 0; index < array.length; index++) {
				if (array[index] > 0) {
					if (index > 0) {
						System.out.print(",");
					}
					System.out.print("" + array[index] + ".");
				}
			}
		}

	}
}
