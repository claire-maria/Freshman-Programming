import java.util.Scanner;

public class ChuckALuck {

	public static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {

		Wallet wallet = new Wallet();

		double cash = betMoney();
		wallet.put(cash);
		while (wallet.check() >= 0) {
			betType();
			resolveBet(betType(), wallet, cash);
		}
	}

	// How much the user will begin the game with

	public static double betMoney() {

		System.out.println("Welcome!");
		System.out.println("How much money do you want to add to your bankroll?");

		double cash = userInput.nextDouble();
		return cash;

	}

	public static String betType() {
		boolean isOver = false;
		System.out.println("What type of bet would you like to place? Or type exit.");
		if (userInput.hasNext("exit")) {
			isOver = true;
			System.out.println("Goodbye");
			System.exit(0);
		}

		String betType = userInput.nextLine();
		return betType;

	}

	public static void resolveBet(String betType, Wallet wallet, double cash) {
		// Wallet wallet = new Wallet();
		boolean isTriple = false;
		boolean isOver = false;
		boolean isField = false;
		boolean isLow = false;
		boolean isHigh = false;

		cash = wallet.check();
		System.out.println("How much would you like to bet");
		double bet = userInput.nextDouble();
		if (cash <= 0 || bet > cash) {
			System.out.println("You do not have enough money in your wallet.");
			System.exit(0);

		}
		Dice firstDice = new Dice();
		Dice secondDice = new Dice();
		Dice thirdDice = new Dice();

		int firstTop = firstDice.roll();
		int secondTop = secondDice.roll();
		int thirdTop = thirdDice.roll();
		int total = thirdTop + firstTop + secondTop;
		System.out.println("" + "First die = " + firstTop + " Second die = " + secondTop + " Third die = " + thirdTop);
	
		
		if ((firstTop != 1 || firstTop != 6) && (firstTop == secondTop) && (firstTop == thirdTop)) {
			isTriple = true;
		}
		if((total < 8) || (total > 12)){
			isField = true;
		}
		if((total > 10) && (isTriple == false)){
			isHigh = true;
		}
		if ((isTriple == false) && (total < 11)){
			isLow = true;
		}

		
		// triple
		if (betType.equals("triple") && isTriple == true) {

			double triplePayout = (30 * bet) + bet;
			//cash = triplePayout + cash;
			wallet.put(triplePayout);
			System.out.println("Congrats, you won a triple!, new balance is " + wallet.check());
		}
		// field
		if ((isField == true) && betType.equals("field")) {

			double fieldPayout = bet + bet;
			//cash = cash + fieldPayout;
			wallet.put(fieldPayout);
			System.out.println("Congrats you won a field, new balance is " + wallet.check());
		}
		// high
		if ((isHigh == true) && (betType.equals("high"))) {
			double highPayout = bet + bet;
			//cash = cash + highPayout;
			wallet.put(highPayout);
			System.out.println("Congrats you won a high, new balance is " + wallet.check());
			

		}
		// low
		if ((isLow == true) && (betType.equals("low"))) {
			double lowPayout = bet + bet;
			//cash = cash + lowPayout;
			wallet.put(lowPayout);
			System.out.println("Congrats you won a low, new balance is " + wallet.check());
			isLow = true;
		} 
		else {

			wallet.get(bet);
			System.out.println("You lost, your new balance is " + wallet.check());
			if (wallet.check() == 0) {
				System.out.println("You lose");
				System.exit(0);
			}
		}
	}

}