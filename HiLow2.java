
package hiLow2;

import java.util.Random;
import java.util.Scanner;

public class HiLow2 {

	public static void main(String[] args) {

		boolean hasEnteredExit = false;

		int numberOfWins = 0;
		Scanner inputScanner = new Scanner(System.in);

		String cards[] = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		int currentCardNumber = new Random().nextInt(13);
		String currentCardName = cards[currentCardNumber];
		System.out.println(
				"You will be given a card, please guess if the next card will be higher, lower, or equal to that card.");
		System.out.println("You must guess correctly 4 times to win. PLease enter exit to exit the program.");
		System.out.println("Card is " + currentCardName);

		while (!hasEnteredExit) {
			while (numberOfWins < 4) {

				int secondCardNumber = new Random().nextInt(13);
				String secondCardName = cards[secondCardNumber];
				String guess = inputScanner.nextLine();

				if (guess.equals("exit")) {
					hasEnteredExit = true;
					System.out.println("Goodbye.");
					System.out.close();
				}

				if (secondCardNumber > currentCardNumber && guess.equals("higher")
						|| (secondCardNumber == currentCardNumber && guess.equals("equal"))
						|| (secondCardNumber < currentCardNumber && guess.equals("lower"))) {

					numberOfWins++;
					if (numberOfWins < 4) {

						System.out.println("congrats, you were right, three more correct gueses to win! "
								+ "You next card is " + secondCardName);
					}
					if (numberOfWins == 4) {
						System.out.println("CONGRATS YOU WON!!!!!!");
						System.out.close();
					}

					currentCardNumber = secondCardNumber;

				} else if (((!guess.equals("higher") && (!guess.equals("lower")) && (!guess.equals("equal"))))) {
					System.out.println(" Invalid input: Please enter 'higher', 'lower' or 'equal', Your next card is "
							+ secondCardName);
				}

				else {
					int thirdCardNumber = new Random().nextInt(13);
					String thirdCardName = cards[thirdCardNumber];
					currentCardNumber = thirdCardNumber;

					System.out.println("Sorry, incorrect answer. Four more correct guesses to win. Your next card is "
							+ thirdCardName);
				}

			}

		}
		inputScanner.close();

	}

}
