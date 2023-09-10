package application;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Get/Put Principle: CONTRAVARIANCE");
		List<Object> myObjs = new ArrayList<Object>();
		myObjs.add("Frank");
		myObjs.add("Nicks");
		myObjs.add('c');
		
		/*
		 * A bounded wildcard type: List<? super Number>
		 * This means that the List parameter can be the Number class OR any SUPERclass of Number
		 * <? super T>: some type which is an ancestor (SUPERclass) of T
		 */
		List<? super Number> myNums = myObjs;
		/*
		 * Get/Put Principle: CONTRAVARIANCE:
		 * 01) GET operation: error 
		 * 02) PUT operation: allowed
		 * 
		 * Contravariance indicates that a more specific type can be used in place of a more general type.
		 * In a data collection, contravariance indicates that its elements can be referenced by their SUPERtypes
		 */		
		myNums.add(10);
		myNums.add(3.14);
		myObjs.add(7L);
		// Number x = myNums.get(0); // Compilation error
		
		printList(myNums);
		printList(myObjs);

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
	 * PROPER SOLUTION: list of bounded wildcard type: List<? super Number>
	 * This means that the List parameter can be the Number class OR any SUPERclass of Number
	 * <? super T>: some type which is an ancestor (SUPERclass) of T
	 */
	public static void printList(List<? super Number> list) {
		for (Object object : list) {
			System.out.print(object + " ");
		}
		System.out.println();
	}
}