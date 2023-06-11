/*
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

package entities;

import entities.enums.Color;

public abstract class Shape {
	private Color color;

	public Shape() {
	}

	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract double area();
}
