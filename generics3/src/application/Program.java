/*
 * Uma empresa de consultoria deseja avaliar a performance de produtos,
 * funcionários, dentre outras coisas. Um dos cálculos que ela precisa é encontrar
 * o maior dentre um conjunto de elementos. Fazer um programa que leia um
 * conjunto de produtos a partir de um arquivo, conforme exemplo, e depois
 * mostre o mais caro deles.
 * 
 * Exemplo:
 * Computer,890.50
 * IPhone X,910.00
 * Tablet,550.00
 * 
 * Most expensive:
 * IPhone, 910.00
 */

package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		// List<Object> is not the SUPERtype of any List type
		// List<Object> myObjs = new ArrayList<Object>();
		// List<Integer> myNumbers = new ArrayList<Integer>();
		// myObjs = myNumbers; // Compilation error: cannot make Object to Integer cast

		// The SUPERtype of any list type is List<?>. This is a WILDCARD type.
		List<?> myObjs = new ArrayList<Object>();
		List<Integer> myNumbers = new ArrayList<Integer>();
		myObjs = myNumbers; // allowed operation
		
		myNumbers.add(1);
		myNumbers.add(5);
		myNumbers.add(7);
		
		printList(myObjs); // print: 1 5 7

		// With wildcard types we can make methods that receive a Generic of "any type"
		List<Integer> myInts = Arrays.asList(5, 2, 10);
		printList(myInts); // print: 5 2 10

		List<String> myStrs = Arrays.asList("Frank", "Nicks", "Drix");
		printList(myStrs); // print: Frank Nicks Drix
	}

	/*
	 * When instantiating, we need to provide a concrete type (type argument). 
	 * We can’t use wildcards to define a generic class or interface. 
	 * We can’t use wildcards directly to specify the type of a parameter in a method. 
	 * 
	 * unbounded GENERICS: <T>
	 * public static <T> void swap(List<T> list, int src, int des);
	 * 
	 * unbouded WILDCARD: <?>
	 * public static void swap(List<?> list, int src, int des);
	 * 
	 * Without upper or lower bounds, the wildcard represents “any type” (like JS), or a type of unknown. 
	 * Its purpose is to allow a variety of actual argument types to be used at different method invocations. 
	 * Moreover, wildcards are designed to support flexible subtyping.
	 */
	
	// Her a wildcard type in use: List<?>
	public static void printList(List<?> list) {

		/*
		 *  Cannot add elements to a collection of wildcard type
		 *  Compilation error: the compiler does not know which the specific type 
		 *  the list was instantiated from 
		 */
		// list.add(3);
		
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
}