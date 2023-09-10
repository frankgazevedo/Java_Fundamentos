/*
 * Construir um método que copia os elementos de uma lista para uma 
 * outra lista que pode ser mais genérica que a primeira.
 * 
 * Exemplo:
 * List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
 * List<Double> myDoubles = Arrays.asList(3.14, 6.28);
 * List<Object> myObjs = new ArrayList<Object>();
 * 
 * copy(myInts, myObjs);
 * copy(myDoubles, myObjs);
 */
package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		
		// Applying covariance and contravariance
		System.out.println("Applying covariance and contravariance");
		
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();
		
		copy(myInts, myObjs);
		printList(myObjs);
		copy(myDoubles, myObjs);
		printList(myObjs);		
	}
	
	/*
	 * PROPER SOLUTION: lists of bounded wildcard types: List<? extends Number> and List<? super Object>

	 * First List parameter can be the Number class OR any SUBclass of Number (Covariance)
	 * <? extends T>): some type which is a SUBclass of T
	 * 
	 * Second List parameter can be the Object class OR any SUPERclass of Object (Contravariance)
	 * <? super T>: some type which is an ancestor (SUPERclass) of T 
	 * 
	 * Read more:
	 * https://medium.com/@leonardohzapp/propriedades-de-vari%C3%A2ncia-no-java-df2e7bc9f76a
	 */
	public static void copy(List<? extends Number> source, List<? super Object> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
	}
	
	/*
	 * IMPROPER SOLUTIONS: list of unbounded wildcard type: List<?>
	 * It works, but it is not safe: we can receive a invalid type as argument.
	 */
	public static void printList(List<?> list) {
		for (Object object : list) {
			System.out.print(object + " ");
		}
		System.out.println();
	}
}