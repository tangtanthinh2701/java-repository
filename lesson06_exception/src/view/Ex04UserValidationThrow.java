package view;

import java.util.Scanner;

public class Ex04UserValidationThrow {
	public static void main(String[] args) {
		// Password requirements
		// 1. At least 8 characters
		// 2. At most 256 characters
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		
		boolean isPassed = false;
		try {
			isPassed = validate(password);
		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
//		if(validate(password)) {
//			System.out.println("Create account successful");
//		}
		
		if(isPassed) {
			System.out.println("Create account successful");
		}
		
		System.out.println("Finished.....");
		sc.close();
	}
	
	// throw new X
	// X: compile exception
	//    --> Vị trí khai báo hàm bắt buộc throws X
	// X: runtime exception
	//    --> Vị trí khai báo hàm không cần throws X
	private static boolean validate(String password) {
		int length = password.length();
		if(length < 8) {
			throw new IllegalArgumentException("At least 8 characters");
//			System.out.println("At least 8 characters");
//			return false;
		}
		if(length > 256) {
			throw new IllegalArgumentException("At most 256 characters");
//			System.out.println("At most 256 characters");
//			return false;
		}
		
		// at least one lower character
		boolean atLeastOneLowerLetter = false;
		for(int i = 0; i < length; i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				atLeastOneLowerLetter = true;
				break;
			}
		}
		if(!atLeastOneLowerLetter) {
			throw new IllegalArgumentException("At least one lower letter");
//			System.out.println("At least one lower letter");
		}
		return atLeastOneLowerLetter;
	}
}
