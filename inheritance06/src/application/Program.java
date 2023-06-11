/*
 * Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), 
 * os quais podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do 
 * imposto pago por cada um, bem como o total de imposto arrecadado.
 * 
 * Os dados de pessoa física são: nome, renda anual e gastos com saúde. 
 * Os dados de pessoa jurídica são nome, renda anual e número de funcionários. 
 * As regras para cálculo de imposto são as seguintes:
 * 
 * # Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. 
 * Pessoas com renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve 
 * gastos com saúde, 50% destes gastos são abatidos no imposto. Exemplo: uma pessoa 
 * cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, 
 * o imposto fica: (50000 * 25%) - (2000 * 50%) = 11500.00
 * 
 * # Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa 
 * possuir mais de 10 funcionários, ela paga 14% de imposto. Exemplo: uma empresa 
 * cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica: 400000 * 14% = 56000.0
 * 
 * Exemplo:
 * 
 * Enter the number of tax payers: 3
 * Tax payer #1 data:
 * Individual or company (i/c)? i
 * Name: Alex
 * Anual income: 50000.00
 * Health expenditures: 2000.00
 * Tax payer #2 data:
 * Individual or company (i/c)? c
 * Name: SoftTech
 * Anual income: 400000.00
 * Number of employees: 25
 * Tax payer #3 data:
 * Individual or company (i/c)? i
 * Name: Bob
 * Anual income: 120000.00
 * Health expenditures: 1000.00
 * 
 * TAXES PAID:
 * Alex: $ 11500.00
 * SoftTech: $ 56000.00
 * Bob: $ 29500.00
 * 
 * TOTAL TAXES: $ 97000.00
 * 
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
package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		/* Boa prática: utilizar o tipo mais genérico possível na Lista (SUPERclasse).
		 * Isso garante reuso e manutenibilidade do código em caso de alteração
		 * das SUBclasses.
		 * 
		 * É possível instanciar uma Collection (List) de tipo ABSTRACT (SUPERclasse),
		 * desde que sejam instanciados objetos concretos (SUBclasses) posteriomente (UPCASTING).
		 */
		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double income = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, income, healthExpenditures)); // instanciação de objeto concreto (SUBclasse)
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, income, numberOfEmployees)); // instanciação de objeto concreto (SUBclasse)
			}
		}

		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer tp : list) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
			sum += tax;
		}

		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

		sc.close();
	}
}
