package testproject;

import java.util.Scanner;
import java.util.Stack;

public class LargeSum {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int numberOfRecords = sc.nextInt();
		String[] inputNumbersStringFormat = new String [numberOfRecords];
		for (int counter = 0; counter < numberOfRecords; counter ++) {
			//=inputNumbersStringFormat[counter] = sc.next();
//			inputNumbersStringFormat[counter] = "99999999999999999999999999999999999999999999999999";
//			inputNumbersStringFormat[counter] = "00000000000000000000000000000000000000000000000001";
		}
		/*
	 	5
		37107287533902102798797998220837590246510135740250
		46376937677490009712648124896970078050417018260538
		74324986199524741059474233309513058123726617309629
		91942213363574161572522430563301811072406154908250
		23067588207539346171171980310421047513778063246676
		 */


		inputNumbersStringFormat[0] = "37107287533902102798797998220837590246510135740250";
		inputNumbersStringFormat[1] = "46376937677490009712648124896970078050417018260538";
		inputNumbersStringFormat[2] = "74324986199524741059474233309513058123726617309629";
		inputNumbersStringFormat[3] = "91942213363574161572522430563301811072406154908250";
		inputNumbersStringFormat[4] = "23067588207539346171171980310421047513778063246676";
	
		int digitSum[] = new int[51];
		for (int reminderCounter = 50; reminderCounter > 0; reminderCounter --) {
			
			for (String inputNumberStringFormat: inputNumbersStringFormat) {
				char digitStringFormat = inputNumberStringFormat.charAt(reminderCounter - 1);
				digitSum[50 - reminderCounter] += Integer.parseInt(digitStringFormat + "");
			}
			digitSum[50 - reminderCounter + 1] = digitSum[50 - reminderCounter]  / 10;
			digitSum[50 - reminderCounter] = digitSum[50 - reminderCounter]  % 10;
			System.out.print(digitSum[50 - reminderCounter]);
		}
		System.out.print(digitSum[50]);
		System.out.println("\n10 Digits -");
		long tenDigit = 0;
		int upCounter = 0;
		boolean nonZeroDigitEncountered = false;
		for (int counter = 0; counter < digitSum.length && upCounter < 10; counter ++, upCounter ++) {
			int digit = digitSum[50 - counter];
			if (nonZeroDigitEncountered || digit != 0) {
				nonZeroDigitEncountered = true;
				tenDigit *= 10;
				tenDigit += digit;
			}
		}
		System.out.printf("%010d", tenDigit);
	}
}
