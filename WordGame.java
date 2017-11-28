
import java.util.Arrays;
import java.util.Scanner;

import wordGame.In;

public class WordGame {
	boolean isOver;
	boolean isUnique;
	boolean isEnglish;
	// boolean isDif;

	// boolean isWordChain = true;

	public static void main(String[] args) {
		boolean hasEnteredExit = false;

		boolean isWordChain = false;
		Scanner inputScanner = new Scanner(System.in);
		while (hasEnteredExit == false) {

			System.out.println("please enter list of words seperated by a comma, type '' to exit game");
			if (inputScanner.hasNext(".")) {
				hasEnteredExit = true;
				// System.exit(0);
				System.out.println("Goodbye");
			}

			else if (inputScanner.hasNextLine()) {
				String inputString = inputScanner.nextLine();

				String[] splitString = readWordList(inputString);
				if (isWordChain(splitString)) {
					System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
				} else if (!isWordChain) {
					System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
				}
				// boolean isWordChain = false;
			}

		}
	}

	public static String[] readDictionary() {
		In dictionary = new In("words.txt");
		String[] dictionaryArray = dictionary.readAllLines();
		// System.out.println(dictionaryArray.length);
		return dictionaryArray;
	}

	public static String[] readWordList(String inputString) {

		String[] splitString = inputString.split(", ");
		return splitString;

	}

	public static boolean isUnqiue(String[] splitString) {
		for (int i = 0; i < splitString.length - 1; i++) {
			for (int j = i + 1; j < splitString.length; j++) {
				if (splitString[i].equals(splitString[j])) {
					// isUnique = false;
					return false;

				}

			}
		}

		return true;

	}

	public static boolean isEnglish(String[] splitString) {
		String[] dictionaryArray = readDictionary();
		Arrays.sort(dictionaryArray);
		for (int i = 0; i < splitString.length; i++) {
			int k = Arrays.binarySearch(dictionaryArray, splitString[i]);

			if (k < 0) {

				return false;
			}

		}

		return true;

	}

	public static boolean isDif(String[] splitString) {

		for (int i = 0; i < splitString.length - 1; i++) {
			int count = 0;

			if (splitString[i].length() == splitString[i + 1].length()) {

				for (int k = 0; k < splitString[i].length(); k++) {
					if (splitString[i].charAt(k) != splitString[i + 1].charAt(k)) {
						count++;
						if (count > 1) {

							return false;
						}

					}
				}
			}

		}

		return true;

	}

	public static boolean isWordChain(String[] splitString) {
		boolean isUnique = isUnqiue(splitString);
		if (isUnique == false) {
			System.out.println("not a unique String, please try again.");
			// System.exit(0);
		}

		boolean isEnglish = isEnglish(splitString);
		if (isEnglish == false) {
			System.out.println("not an English word, please try again.");
			// System.exit(0);
		}

		boolean isDif = isDif(splitString);

		
		if (isUnique && isDif && isEnglish) {
			// System.out.println("is valid");

			return true;

		}

		return false;

	}

}