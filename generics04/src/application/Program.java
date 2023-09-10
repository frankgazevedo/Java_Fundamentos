/*
 * Construir um método para retornar a soma das áreas de uma lista de figuras geométricas.
 */
package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.Circle;
import model.entities.Rectangle;
import model.entities.Shape;

public class Program {

	public static void main(String[] args) {

		// The SUPERtype of any list type is List<?>. This is a unbounded WILDCARD type.
		List<Shape> myShapes = new ArrayList<Shape>();
		myShapes.add(new Rectangle(3.0, 2.0));
		myShapes.add(new Circle(2.0));
		System.out.println("Total area: " + totalArea(myShapes));
		
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		System.out.println("Total area: " + totalArea(myCircles));
		
	}
	
	/*
	 * IMPROPER SOLUTION: list of interface Shape (SUPERclass): List<Shape>
	 *  
	public static double totalArea(List<Shape> list) {
		double sum = 0.0;
		for (Shape s : list) {
			sum += s.area();
		}
		return sum;
	}
	 */
	
	/*
	 * IMPROPER SOLUTIONS: list of unbounded wildcard type: List<?>
	 *  
	public static double totalArea(List<?> list) {
		double sum = 0.0;
		for (Shape s : list) {
			sum += s.area();
		}
		return sum;
	}
	 */

	/*
	 * PROPER SOLUTION: list of bounded wildcard type: List<? extends Shape >
	 * This means that the List parameter 
	 * can be the Shape class OR any SUBclass of Shape
	 * <? extends T>): some type which is a SUBclass of T
	 */
	public static double totalArea(List<? extends Shape> list) {

		/*
		 * Cannot add elements to a collection of bounded wildcard type
		 * Compilation error: the compiler does not know from which the specific type 
		 * the list was instantiated
		 */
		// list.add(new Rectangle(3.0, 4.0));

		double sum = 0.0;

		for (Shape shape : list) {
			sum += shape.area();
		}

		return sum;
	}
}