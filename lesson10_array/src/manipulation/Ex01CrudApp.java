package manipulation;

import java.util.Arrays;

import common.Tuple;

// Create/Read/Update/Delete
/*
 Ex01: Give an array int[] = {1, 9, 5, 36, 12, 33};
	With k from 0 - (length-1)
	+ Calculate sum of odd numbers 
	+ Find max, min in array(one loop)
	
	+ Add element at index k
	+ Remove element from index k
	+ Update element at index k = newValue
	+ Get element at index k
 */

public class Ex01CrudApp {
	public static void main(String[] args) {
		int[] numbers = {9, 1, 5, 36, 12, 33};
		
		int sumOfOddElements = sum(numbers);
		System.out.println("sumOfOddElements: " + sumOfOddElements);
	
		// Không cần new Tuple vì trong getMinMax đã làm rồi
		Tuple tuple = getMinMax(numbers); 
		System.out.println("tuple: " + tuple);
		
		int[] newAddedArray = add(numbers, 18, 3);
		System.out.println("newAddedArray: " + Arrays.toString(newAddedArray));
	
		int[] newInsertedArray = insert(newAddedArray, 77, 2);
		System.out.println("newInsertedArray: " + Arrays.toString(newInsertedArray));
		
		int[] newRemovedArray = remove(numbers, 2);
		System.out.println("newRemovedArray: " + Arrays.toString(newRemovedArray));
	}
	
	private static int sum(int[] numbers) {
		int sum = 0;
		for (int number: numbers) {
			if (number % 2 != 0) {
				sum += number;
			}
		}
		return sum;
	}
	
	private static Tuple getMinMax(int[] numbers) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int number: numbers) {
			if (max < number) {
				max = number;
			}
			if (min > number) {
				min = number;
			}
		}
		// C1
//		Tuple result = new Tuple(max, min);
//		return result;
		
		// C2
//		Tuple result = new Tuple();
//		result.setLeft(max);
//		result.setRight(min);	
//		return result;
		
		// C3
		return new Tuple(max, min);
	}
	
	private static int[] add(int[] source, int newValue, int k) {
		int[] result = new int[source.length + 1];
		for (int i = 0; i < k; i++) {
			result[i] = source[i];
		}
		result[k] = newValue;
		for (int i = k+1; i < result.length; i++) {
			result[i] = source[i-1];
		}
		return result;
	}
	
	private static int[] insert(int[] source, int newValue, int k) {
		int[] result = new int[source.length+1];
		
		for (int i = 0 ; i < source.length; i++) {
			result[i] = source[i];
		}
		
		for (int i = result.length-1; i > k; i--) {
			result[i] = result[i-1];
		}
		
		result[k] = newValue;
		return result;
	}
	
	private static int[] remove(int[] source, int k) {
		for (int i = k; i < source.length-1; i++) {
			source[i] = source[i+1];
		}
		return Arrays.copyOfRange(source, 0, source.length-1);
	}
}
