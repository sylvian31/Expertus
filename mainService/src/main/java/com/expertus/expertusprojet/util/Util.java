package com.expertus.expertusprojet.util;

public class Util {

	/**
	 * Change value to decimal value
	 * 
	 * @param number
	 * @return decimale value
	 */
	public static String formatDecimal(float number) {
		float epsilon = 0.004f;
		if (Math.abs(Math.round(number) - number) < epsilon) {
			return String.format("%10.0f", number);
		} else {
			return String.format("%10.2f", number);
		}
	}
}
