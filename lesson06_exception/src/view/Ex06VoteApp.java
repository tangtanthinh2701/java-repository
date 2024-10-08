package view;

import java.util.Random;

import exception.InvalidAgeException;

public class Ex06VoteApp {
	public static void main(String[] args) {
		int age = 15 + new Random().nextInt(6);
		
		try {
			boolean isValid = validate(age);
			
			System.out.println("isValid: " + isValid);
		} catch (InvalidAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished");
	}

	// Khi throw new ra 1 compile exception thì bắt buộc phải throws
	// => Bắt buộc xử lý try catch
	private static boolean validate(int age) throws InvalidAgeException {
		if(age < 18) {
//			throw new IllegalArgumentException("Age must be greater or equal 18");
			throw new InvalidAgeException("Age must be greater or equal 18");
		}
		
		return true;
	}
}
