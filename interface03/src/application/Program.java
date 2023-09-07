package application;

import model.entities.AbstractShape;
import model.entities.Circle;
import model.entities.Rectangle;
import model.entities.enums.Color;

public class Program {
	public static void main(String[] args) {

		/*
		 * Inheritance x Interface fundamental difference • Inheritance => reuse •
		 * Interface => contract to be fulfilled
		 * 
		 * Aspects in common between inheritance and interfaces • Is-a relationship •
		 * Generalization/specialization • Polymorphism
		 * 
		 * What if I need to implement an abstraction as an interface, but I also want
		 * to define a common reusable framework for all derived abstractions?
		 * 
		 * Abstract classes with interfaces can solve this situation. In this case, we
		 * use interfaces to provide behaviors (methods) to abstract classes which, in
		 * turn, provide behaviors (methods) and/or common reusable attributes to their
		 * subclasses (due to inheritance).
		 */

		AbstractShape circle = new Circle(Color.BLACK, 2.0);
		AbstractShape rectangle_with_color = new Rectangle(Color.WHITE, 3.0, 4.0);

		AbstractShape rectangle_no_color = new Rectangle(5.0, 4.0);

		System.out.println("Circle color: " + circle.getColor());
		System.out.println("Circle area: " + String.format("%.3f", circle.area()));
		System.out.println("Rectangle color: " + rectangle_with_color.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", rectangle_with_color.area()));

		System.out.println("Rectangle color: " + rectangle_no_color.getColor()); // print null
		System.out.println("Rectangle area: " + String.format("%.3f", rectangle_no_color.area()));
	}

}