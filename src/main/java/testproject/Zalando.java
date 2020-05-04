package testproject;

import java.util.ArrayList;
import java.util.List;

public class Zalando {
	public static void main (String args[]) {
		
		//System.out.println(solution1 (1000));
		//System.out.println(solution2 (new int[]{1, 4, 2, -2, 5}, new int[] {7, -2, -2, 2, 5}));
		System.out.println(solution3 (3, 2, new int[] {2,1,1,0,1}));
	}
	
	
    public static String solution3(int U, int L, int[] C) {
        int[][] matrix = new int[2][C.length];
        int upperRowSum = 0;
        int lowerRowSum = 0;
        StringBuffer sbUpper = new StringBuffer();
        StringBuffer sbLower = new StringBuffer();
        
        for (int columnCounter = 0; columnCounter < C.length; columnCounter ++) {
        	matrix = populateMatrixColumn(matrix, C, columnCounter);
        	sbUpper.append(matrix[0][columnCounter]);
        	sbLower.append(matrix[1][columnCounter]);
        	upperRowSum += matrix[0][columnCounter];
        	lowerRowSum += matrix[0][columnCounter];
        }
        
        if (U == upperRowSum && L == lowerRowSum) {
        	return sbUpper.toString() + "," + sbLower.toString();
        }
        
        return "IMPOSSIBLE";
    }
	
	
public static int[][] populateMatrixColumn (int[][] matrix, int[] C, int columnCounter) {
	if (C[columnCounter] == 2) {
		matrix[0][columnCounter] = 1;
		matrix[1][columnCounter] = 1;
	}
	else if (C[columnCounter] == 0) {
		matrix[0][columnCounter] = 0;
		matrix[1][columnCounter] = 0;
	}
	else if (C[columnCounter] == 1) {
		matrix[0][columnCounter] = 1;
		matrix[1][columnCounter] = 0;
	}
	return matrix;
}
	
	
	
	
	
	
	
	
	
    public static int solution2(int[] A, int[] B) {
    	
    	if (A.length != B.length) {
    		return -1;
    	}
    	int arraySize = A.length;
    	int fairCounter = 0;
    	
    	for (int demarker = 1; demarker < arraySize; demarker ++) {
    		int fairASum1 = 0, fairASum2 = 0, fairBSum1 = 0, fairBSum2 = 0;
    		for (int counter = 0; counter < demarker; counter ++) {
    			fairASum1 += A[counter];
    			fairBSum1 += B[counter];
    		}
    		for (int counter = demarker; counter < arraySize; counter ++) {
	    		fairASum2 += A[counter];
	    		fairBSum2 += B[counter];
    		}
    		if (isFair(fairASum1, fairASum2, fairBSum1, fairBSum2)) {
    			fairCounter ++;
    		}
    	}
    	return fairCounter;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean isFair(int sum1, int sum2, int sum3, int sum4) {
		if (sum1 == sum2 && sum2 == sum3 && sum3 == sum4) {
			return true;
		}
		return false;
	}
	
    public static int solution1(int N) {
    	
    	int originalNumber = N;
    	int originalNumberSum = getSum(originalNumber);
    	
    	for (int counter = originalNumber + 9; counter < 50000; counter += 9) {
    		if (getSum(counter) == originalNumberSum)
    			return counter;
    	}
    	return 0;

    	/*
    	if O digit is greater than 0, increment T position and decrement O position. (+9)
    	if O digit is 0, increment H potiion 
    	*/
//    	
//    	for (int positionCounter = 0; positionCounter < 5; positionCounter ++) {
//    		if (arr[positionCounter] > 0) {
//    			return N + 9;
//    		}
//    		int[] incrementBy10 = incrementBy10(arr, positionCounter ++);
//    		System.out.println(incrementBy10);
//    	}
//    	return 0;
    }
    
    public static int[] incrementBy10 (int arr[], int positionCounter) {
    	for (int counter = positionCounter; counter < 5; counter ++)
    	if (arr[positionCounter] == 0) {
    		return incrementBy10(arr, ++ positionCounter);
    	}
    	else {
    		arr[positionCounter] += 1;
    	}
    	return null;
    }
    
    public static int getSum(int number) {
    	int sum = 0;
    	while (number > 0) {
    		int reminder = number % 10;
    		sum += reminder;
    		number = number / 10;
    	}
    	return sum;
    }
}
