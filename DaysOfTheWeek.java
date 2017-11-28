package daysOfTheWeek;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Math;

public class DaysOfTheWeek {

	public static final int DAYS_IN_SOME_MONTHS = 30;
	public static final int DAYS_IN_FEBRUARY_NOT_LEAP_YEAR = 28;
	public static final int DAYS_IN_FEBRUARY_IF_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;
	public static final double NUMBER_IN_FORMULA_TWO_POINT_SIX = 2.6;
	public static final int NUMBER_IN_FORMULA_TWELVE = 12;
	public static final double NUMBER_IN_FORMULA_ZERO_POINT_TWO = 0.2;
	public static final int NUMBER_IN_FORMULA_FOUR = 4;
	public static final int NUMBER_IN_FORMULA_TWO = 2;

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("Enter date (day/month/year):");
		Scanner inputDate = new Scanner(input);
		inputDate.useDelimiter("/");
		int day = inputDate.nextInt();
		int month = inputDate.nextInt();
		int year = inputDate.nextInt();
		String dayOfWeek = dayOfWeekWritten(day, month, year);
		String nameOfMonth = monthName(month);
		String suffex = numberEnding(day);

		if (validDate(day, month, year)) {
			JOptionPane.showMessageDialog(null,
					"" + dayOfWeek + " the" + day + suffex + "/" + nameOfMonth + "/" + year );
		} else {
			JOptionPane.showMessageDialog(null, "" + day + "/" + month + "/" + year + " is not a valid date.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static String dayOfWeekWritten(int day, int month, int year) {
		int dayOfTheWeekNumerical;
		String dayOfWeekWritten = "";
		int y;
		int c;
		if (month == 1 || month == 2) {
			c = ((year - 1) - ((year - 1) % 100)) / 100;
			y = (year - 1) % 100;
		} else {
			c = (year - (year % 100)) / 100;
			y = year % 100;

			dayOfTheWeekNumerical = Math.floorMod((day
					+ (int) Math.floor(NUMBER_IN_FORMULA_TWO_POINT_SIX * (((month + 9) % NUMBER_IN_FORMULA_TWELVE) + 1)
							- NUMBER_IN_FORMULA_ZERO_POINT_TWO)
					+ y + (int) Math.floor(y / NUMBER_IN_FORMULA_FOUR) + (int) Math.floor(c / NUMBER_IN_FORMULA_FOUR)
					- (NUMBER_IN_FORMULA_TWO * c)), 7);

			switch (dayOfTheWeekNumerical) {
			case 0:
				dayOfWeekWritten = "Sunday";
				break;
			case 1:
				dayOfWeekWritten = "Monday";
				break;
			case 2:
				dayOfWeekWritten = "Tuesday";
				break;
			case 3:
				dayOfWeekWritten = "Wednesday";
				break;
			case 4:
				dayOfWeekWritten = "Thursday";
				break;
			case 5:
				dayOfWeekWritten = "Friday";
				break;
			case 6:
				dayOfWeekWritten = "Saturday";
				break;
			}
		}
		return dayOfWeekWritten;

	}

	public static String monthName(int month) {

		String monthName = "";

		switch (month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
			break;

		}
		return monthName;

	}

	public static String numberEnding(int day) {
		String numberEnding = "";

		switch (day) {
		case 1:
			numberEnding = "st";
			break;
		case 2:
			numberEnding = "nd";
			break;
		case 3:
			numberEnding = "rd";
			break;
		case 21:
			numberEnding = "st";
			break;
		case 22:
			numberEnding = "nd";
			break;
		case 23:
			numberEnding = "rd";
			break;
		case 31:
			numberEnding = "st";
			break;
		default:
			numberEnding = "th";
			break;
		}

		return numberEnding;

	}

	public static boolean validDate(int day, int month, int year) {
		return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) && (day >= 1)
				&& (day <= daysInMonth(month, year))); // function taken from
														// ValidDate code,
														// written by Dr.
														// Kenneth Dawson Holme
	}

	public static int daysInMonth(int month, int year) {
		int numberOfDays = DAYS_IN_MOST_MONTHS;
		switch (month) {
		case 2:
			if (isLeapYear(year) == true) {
				numberOfDays = DAYS_IN_FEBRUARY_IF_LEAP_YEAR;
			}

			else {
				numberOfDays = DAYS_IN_FEBRUARY_NOT_LEAP_YEAR;
			}
			break;
		case 4:
			numberOfDays = DAYS_IN_SOME_MONTHS;
			break;
		case 6:
			numberOfDays = DAYS_IN_SOME_MONTHS;
			break;
		case 8:
			numberOfDays = DAYS_IN_SOME_MONTHS;
			break;
		case 11:
			numberOfDays = DAYS_IN_SOME_MONTHS;
			break;
		default:
			numberOfDays = DAYS_IN_MOST_MONTHS;
			break;

		}
		return numberOfDays;
	}

	public static boolean isLeapYear(int year) {
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)); // function
																				// taken
																				// from
																				// ValidDate
																				// code,
																				// written
																				// by
																				// Dr.
																				// Kenneth
																				// Dawson
																				// Holme
	}

}