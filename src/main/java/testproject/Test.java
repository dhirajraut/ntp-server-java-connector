package testproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int numberOfRecords = sc.nextInt();
//        for (int recordCounter = 0; recordCounter < numberOfRecords; recordCounter ++) {
//            int numeratorOfRecord = sc.nextInt();
//            int denominatorOfRecord = sc.nextInt();
			int numberOfRecords = 1;
            int numeratorOfRecord = 4;
            int denominatorOfRecord = 10;
//            System.out.println("Processing " + numeratorOfRecord + " " + denominatorOfRecord);
            
            /* Loop for finding smallest denominator. */
            for (long processingDenominator = 2; processingDenominator <= 50000; processingDenominator ++) {
            	//long resilientFactor = 0;
            	long resilientFactor = processingDenominator % 2 == 0 ? (processingDenominator / 2) - 1 : (processingDenominator / 2) ;
            	long loopLimit = resilientFactor;
	            for (long processingNumerator = 1; processingNumerator <= loopLimit; processingNumerator ++) {
            		System.out.println("Checking " + processingNumerator + "/" + processingDenominator);

	            	if (!hasCommonFactor(processingNumerator, processingDenominator)) {
	            		resilientFactor ++;
	            	}
	            }
//	            System.out.println("For denominator " + processingDenominator + ", there are " + resilientFactor + " resilient factors");
	            if (new Double(resilientFactor)/(processingDenominator - 1) < new Double(numeratorOfRecord)/denominatorOfRecord) {
//	            	System.out.println(resilientFactor + "/" + (processingDenominator - 1) + "<" + numeratorOfRecord +"/" + denominatorOfRecord);
	            	System.out.println(processingDenominator);
	            	break;
	            }
	            else {
	//            	System.out.println("Otherwize");
	            }
            }
//        }
	}
	
	private static boolean hasCommonFactor (long number1, long number2) {
    	for (int commonFactor = 2;
    			(commonFactor <= new Double(number1) / 2) || (commonFactor <= number1);
    			commonFactor ++) {
//    		System.out.println("Checking common factor " + commonFactor);
			if (number1 % commonFactor == 0 && number2 % commonFactor == 0) {
				return true;
			}
    	}
    	return false;
	}
	
	/*
	public static void main(String[] args) {
		 long a = 10, b = 15;
	        Scanner in = new Scanner(System.in);
	        String line = in.nextLine();
	        String[] split = line.split(" ");
	        if (split.length == 2) {
		        a = Long.parseLong(split[0]); b = Long.parseLong(split[1]);
		        long returnCount = 0;
		        System.out.println(Math.min(a, b));
		        for (long counter = 1; counter <= Math.min(a, b) / 2; counter ++) {
		        	if (a % counter == 0 && b % counter == 0) {
		        		returnCount ++;
		        	}
		        }
		        System.out.println(returnCount);
	        }
	}
	*/
}
