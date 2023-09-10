package application;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Get/Put Principle: COVARIANCE");
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(5);
		
		/*
		 * A bounded wildcard type: List<? extends Number>
		 * This means that the List parameter can be the Number class OR any SUBclass of Number
		 * <? extends T>): some type which is a SUBclass of T
		 */
		List<? extends Number> list = intList;
		/*
		 * Get/Put Principle: COVARIANCE
		 * 01) GET operation: allowed 
		 * 02) PUT operation: error
		 * 
		 * Covariance indicates that a more generic type can be used in place of a more specific type.
		 * In a data collection, covariance indicates that its elements can be referenced by their SUBtypes
		 */
		Number x = list.get(0);
		// list.add(20); // Compilation error
		
		System.out.println("Number x = " + x);
		
		printList(intList);
		printList(list);

	}
	
	/*
	 * IMPROPER SOLUTIONS: list of unbounded wildcard type: List<?>
	 * It works, but it is not safe: we can receive a invalid type as argument.
	 *  
	public static void printList(List<?> list) {
		for (Object object : list) {
			System.out.print(object + " ");
		}
		System.out.println();
	}	
	 */
	
	/*
	 * PROPER SOLUTION: list of bounded wildcard type: List<? extends Number>
	 * This means that the List parameter can be the Number class OR any SUBclass of Number
	 * <? extends T>): some type which is a SUBclass of T
	 */
	public static void printList(List<? extends Number> list) {
		for (Object object : list) {
			System.out.print(object + " ");
		}
		System.out.println();
	}
}