package com.code.leetcode;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
	public static void main(String[] args) {
		IntegerToRoman o = new IntegerToRoman();
		System.out.println(o.intToRoman(3724));
	}

	public String intToRoman(int num) {
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] integers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(num != 0) {
			if(num - integers[i] < 0) {
				// do nothing. check for next number from array
				i++;
			} else {
				sb.append(roman[i]);
				num -= integers[i];
			}
		}
		return sb.toString();
	}
}
