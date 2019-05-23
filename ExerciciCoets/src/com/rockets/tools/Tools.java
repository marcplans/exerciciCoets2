package com.rockets.tools;

import java.util.ArrayList;

public class Tools {

	// Rounds given number to closest divisor by ten
	public static int roundToClosestTenDivisor(double num) {
		int output = (int) Math.round(num);
		int a = output / 10 * 10;
		int b = a + 10;
		return (output - a < b - output) ? a : b;
	}

	// Rounds double number with a given decimal precision
	public static double myRound(double numToRound,
			int decimalPlaces) {
		double prec = Math.pow(10, decimalPlaces);
		double roundedNum = Math.round(numToRound * prec) / prec;
		return roundedNum;
	}

	// method that delays time a given number of milliseconds
	public static void myDelay(int milliseconds) {
		long initialTime = System.currentTimeMillis();
		while (System.currentTimeMillis() < initialTime
				+ milliseconds) {
		}
	}

	// returns the sum of all integers in array list
	public static int sumIntegerArrayList(
			ArrayList<Integer> arrayToSum) {
		int output = 0;
		for (int i = 0; i < arrayToSum.size(); i++) {
			output += arrayToSum.get(i);
		}
		return output;
	}

	// Returns a given string repeated a number of times
	public static String repeatString(String toRepeat,
			int repetitions) {
		String output = "";
		for (int i = 0; i < repetitions; i++) {
			output += toRepeat;
		}
		return output;
	}

	// Returns a given number as a string with trailing spaces
	// so that matches a desired string length
	public static String formatNum(Double numToFormat,
			int desiredLength) {
		int currentLength = numToFormat.toString().length();
		if (desiredLength <= currentLength) {
			return numToFormat.toString();
		}
		return repeatString(" ", desiredLength - currentLength)
				+ numToFormat.toString();
	}

	// Returns a given number as a string with trailing spaces
	// so that matches a desired string length
	public static String formatNum(String numToFormat,
			int desiredLength) {
		int currentLength = numToFormat.length();
		if (desiredLength <= currentLength) {
			return numToFormat;
		}
		return repeatString(" ", desiredLength - currentLength)
				+ numToFormat;
	}

	// Returns a given a string with leading spaces
	// so that matches a desired string length.
	public static String leadingString(String inputString,
			int desiredLength) {
		int currentLength = inputString.length();
		if (desiredLength <= currentLength) {
			return inputString;
		}
		return repeatString(" ", desiredLength - currentLength)
				+ inputString;
	}

	// Returns a given string with trailing spaces
	// so that matches a desired string length.
	public static String trailingString(String inputString,
			int desiredLength) {
		int currentLength = inputString.length();
		if (desiredLength <= currentLength) {
			return inputString;
		}
		return inputString
				+ repeatString(" ", desiredLength - currentLength);
	}

	// Returns a given string with trailing spaces
	// so that matches a desired string length.
	public static String sandwichString(String firstString,
			String secondString, int desiredLength) {
		int length1 = firstString.length();
		int length2 = secondString.length();

		if (desiredLength <= length1 + length2) {
			return firstString + secondString;
		}
		return firstString
				+ repeatString(" ", desiredLength - length1 - length2)
				+ secondString;
	}

}
