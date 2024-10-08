package designpatterns.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import model.DataModel;

public class AppleMethodReference {
	public static void main(String[] args) {
		// get list of countries from inventory
		List<Apple> inventory = DataModel.getApples();
		
//		getCountries(inventory).forEach(System.out::println);
		
		// apple -> apple.getWeight() ---> Apple::getWeight -> non static method
		// (Apple apple) -> apple.getWeight() ---> Apple::getWeight -> non static method
		// (Apple apple) -> apple.getWeight() --> AppleMethodReference::getStaticWeight
		
//		map(inventory, apple -> apple.getOriginal()).forEach(System.out::println);
//		map(inventory, Apple::getWeight).forEach(System.out::println);
		
//		map(inventory, Apple::getWeight, (element, function, result) -> {
//			result.add(function.apply(element));
//		}).forEach(System.out::println);
		map(inventory, AppleMethodReference::getStaticWeight)
		.forEach(System.out::println);
	}
	
	// Common hơn
	private static <T, R> Set<R> map(List<T> elements, Function<T, R> function) {
		Set<R> result = new HashSet<>();
		// Apple --> X
		// T -> R
//		for(T t : elements) {
//			result.add(function.apply(t));
//		}
		elements.forEach(element -> {
			// apple.getOriginal()
			// apple.getWeight()
			result.add(function.apply(element));
		});
		
		return result;
	}
	
//	private static <T, R> Set<R> map(List<T> elements, Function<T, R> function, Test<T, R> test) {
//		Set<R> result = new HashSet<>();
////		elements.forEach(e -> consumer.accept(e));
////		elements.forEach(consumer::accept);
//		elements.forEach(element -> test.accept(element, function, result));
//		
//		return result;
//	}
	
	interface Test<T, R> {
		void accept(T t, Function<T, R> f, Set<R> set);
	}
	
	public static Double getStaticWeight(Apple apple) {
		return apple.getWeight();
	}
	
//	private static Set<String> getCountries(List<Apple> inventory){
//	Set<String> result = new HashSet<>();
//	// Apple --> X
//	// T --> R
//	for(Apple apple : inventory) {
//// List:	apple.getOriginal();
//		result.add(apple.getOriginal());
//	}
//	return result;
//}
//
//  private static Set<Double> getWeights(List<Apple> inventory){
//	Set<Double> result = new HashSet<>();
//	for(Apple apple : inventory) {
//		result.add(apple.getWeight());
//	}
//	return result;
//}
}
