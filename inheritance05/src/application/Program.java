/*
 * Fazer um programa para ler os dados de N figuras (N fornecido
 * pelo usuário), e depois mostrar as áreas destas figuras na
 * mesma ordem em que foram digitadas.
 * 
 * Exemplo:
 * 
 * Enter the number of shapes: 2
 * Shape #1 data:
 * Rectangle or Circle (r/c)? r
 * Color (BLACK/BLUE/RED): BLACK
 * Width: 4.0
 * Height: 5.0
 * Shape #2 data:
 * Rectangle or Circle (r/c)? c
 * Color (BLACK/BLUE/RED): RED
 * Radius: 3.0
 * 
 * SHAPE AREAS:
 * 20.00
 * 28.27
 * 
 * Como a classe Shape é genérica ao ponto de não sermos capazes de
 * definir um método de cálculo de área default, declaramos na SUPERclasse
 * que tal método seria ABSTRATO, assim obrigando as SUBclasses 
 * a implementarem o método de acordo com suas especificidades.
 * 
 * Métodos abstratos: métodos que não possuem implementação na SUPERclasse.
 * 
 * Se uma classe possuir pelo menos um MÉTODO ABSTRATO, 
 * então esta CLASSE também é ABSTRATA.
 * 
 * Classes Abstratas: São classes que não podem ser instanciadas.
 * É uma forma de garantir HERANÇA TOTAL: somente SUBclasses não
 * abstratas podem ser instanciadas, mas nunca a SUPERclasse abstrata.
 * 
 * Notação UML: itálico
 */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		/* Boa prática: utilizar o tipo mais genérico possível na Lista (SUPERclasse).
		 * Isso garante reuso e manutenibilidade do código em caso de alteração
		 * das SUBclasses.
		 * 
		 * É possível instanciar uma Collection (List) de tipo ABSTRACT (SUPERclasse),
		 * desde que sejam instanciados objetos concretos (SUBclasses) posteriomente (UPCASTING).
		 */
		List<Shape> list = new ArrayList<>();

		System.out.print("Enter the number of shapes: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Shape #" + i + " data:");
			System.out.print("Rectangle or Circle (r/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());
			if (ch == 'r') {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				list.add(new Rectangle(color, width, height)); // instanciação de objeto concreto (SUBclasse)
			} else {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				list.add(new Circle(color, radius)); // instanciação de objeto concreto (SUBclasse)
			}
		}

		System.out.println();
		System.out.println("SHAPE AREAS:");
		for (Shape shape : list) {
			System.out.println(String.format("%.2f", shape.area()));
		}

		sc.close();
	}
}
