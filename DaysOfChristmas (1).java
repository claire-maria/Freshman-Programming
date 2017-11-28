package daysOfChristmas;

public class DaysOfChristmas {
	public static void main(String[] args) {
		int verse;
		String day = "";
		for (verse = 1; verse <= 12; verse++) {

			switch (verse) {
			case 1:
				day = "first";
				break;
			case 2:
				day = "second";
				break;
			case 3:
				day = "third";
				break;
			case 4:
				day = "fourth";
				break;
			case 5:
				day = "fifth";
				break;
			case 6:
				day = "sixth";
				break;
			case 7:
				day = "seventh";
				break;
			case 8:
				day = "eighth";
				break;
			case 9:
				day = "ninth";
				break;
			case 10:
				day = "tenth";
				break;
			case 11:
				day = "eleventh";
				break;
			case 12:
				day = "twelvth";
				break;

			}
			System.out.println("\nOn the " + day);
			System.out.println("day of Christmas, my true love sent to me");

			switch (verse) {
			case 12:
				System.out.println("twelve drummers drumming");
			case 11:
				System.out.println("eleven pipers playing");
			case 10:
				System.out.println("ten lords a leaping");
			case 9:
				System.out.println("nine ladies dancing");
			case 8:
				System.out.println("eight maids a milking");
			case 7:
				System.out.println("seven swans a swimming");
			case 6:
				System.out.println("six geese a laying");
			case 5:
				System.out.println("five gold rings");
			case 4:
				System.out.println("four calling birds");
			case 3:
				System.out.println("three French hens");
			case 2:
				System.out.println("two turtle doves");
			case 1:
				if (verse > 1)
					System.out.print("and ");

				System.out.println("a partridge in a pear tree");

			}

		}

	}

}
