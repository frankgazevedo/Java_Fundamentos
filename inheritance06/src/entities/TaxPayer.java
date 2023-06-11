/*
 * Como a classe TaxPayer é genérica ao ponto de não sermos capazes de
 * definir um método de cálculo de imposto (tax) default, declaramos na SUPERclasse
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

public abstract class TaxPayer {
	private String name;
	private Double anualIncome;

	public TaxPayer(String name, Double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnualIncome() {
		return anualIncome;
	}

	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}

	public abstract Double tax();
}
