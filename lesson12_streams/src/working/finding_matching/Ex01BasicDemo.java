package working.finding_matching;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.function.Predicate;


public class Ex01BasicDemo {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 1, 4, 5, 8, 10, 4, 12 };
		
		// 1. is there any element that is divisible by 10
		boolean hasNumberDivisibleBy10 = Arrays.stream(numbers) // IntStream
				                               .anyMatch(number -> number % 10 == 0);
		System.out.println("1st hasNumberDivisibleBy10: " + Arrays.stream(numbers).anyMatch(n -> n % 10 == 0));
		
		// 2. find the first element that is divisible by 4
		OptionalInt optInt = Arrays.stream(numbers)
								   .filter(number -> number % 4 == 0)
								   .findFirst();
		optInt.ifPresent(value -> 
			System.out.println("2nd first element divisible by 4 --> " + value));
		System.out.println("2nd first element divisible by 4: " + optInt);
		Arrays.stream(numbers)
		      .filter(n -> n % 4 == 0) // IntStream
		      .findFirst()
			  .ifPresent(value -> System.out.println("2nd first element divisible by 4: " + value));
		findFirst(numbers, n -> n % 4 == 0)
			  .ifPresent(value -> System.out.println("2nd first element divisible by 4: " + value));
		
		// 3. find the element that is divisible by 5 in the list
		Arrays.stream(numbers)
			  .filter(number -> number % 5 == 0)
			  .findAny()
			  .ifPresent(value -> System.out.println("3rd elements divisible by 5: " + value));
		
		System.out.print("3rd elements divisible by 5: ");
		Arrays.stream(numbers)
		      .filter(n -> n % 5 == 0)
		      .forEach(System.out::println);
		
		// 4. does all elements less than 100
		boolean isAllLessThan100 = Arrays.stream(numbers)
										 .allMatch(number -> number < 100);
		System.out.println("4th all elements less than 100 --> " + isAllLessThan100);
		System.out.println("4th all < 100: " + Arrays.stream(numbers)
		          .allMatch(n -> n < 100));
		
		// 5. does no element greater than 0
		boolean isNoElementsGreaterThan0 = Arrays.stream(numbers)
												 .noneMatch(number -> number > 0);
		System.out.println("5th no elements greater than 0 --> " + isNoElementsGreaterThan0);
		System.out.println("5th no elements greater than 0: " + Arrays.stream(numbers)
		          .noneMatch(n -> n > 0));
	}

	private static <T> Optional<T> findFirst(Collection<T> collections, Predicate<T> predicate) {
		return collections.stream().filter(predicate).findFirst();
	}

	// Int Arrays
	private static OptionalInt findFirst(int[] elements, IntPredicate predicate) {
		return Arrays.stream(elements).filter(predicate).findFirst();
	}
	
	// Common Array Object
	private static <T> Optional<T> findFirst(T[] elements, Predicate<T> predicate){
		return Arrays.stream(elements).filter(predicate).findFirst();
	}
}
