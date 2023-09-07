package application;

import entities.devices.ComboDevice;
import entities.devices.ConcretePrinter;
import entities.devices.ConcreteScanner;

public class Program {

	public static void main(String[] args) {

		ConcretePrinter p = new ConcretePrinter("1080");
		p.processDoc("My Letter");
		p.print("My Letter");

		System.out.println();

		ConcreteScanner s = new ConcreteScanner("2003");
		s.processDoc("My E-mail");
		System.out.println("Scan result: " + s.scan());

		System.out.println();

		/*
		 * Multiple inheritance can generate the diamond problem: an ambiguity caused by
		 * the existence of the same method in more than one superclass.
		 * 
		 * In the case of this project, WE DO NOT USE MULTIPLE INHERITANCE, as there is
		 * no reuse in the relationship between the ComboDevice and the Printer and the
		 * Scanner interfaces.
		 * 
		 * The ComboDevice class does not inherit, but rather implements the interfaces
		 * (fulfills the contract).
		 */

		ComboDevice c = new ComboDevice("2081");
		c.processDoc("My dissertation");
		c.print("My dissertation");
		System.out.println("Scan result: " + c.scan());

	}

}
