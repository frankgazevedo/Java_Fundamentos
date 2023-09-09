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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Product;
import model.services.CalculationService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();
		
		String path = "/home/frankazevedo/Workspaces/java_fundamental/generics02/resources/in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				// Separating the line in two fields: field 0 equals "name" and field 1 equals
				// "price"
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}

			Product x = CalculationService.max(list);
			System.out.println("Most expensive:");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}