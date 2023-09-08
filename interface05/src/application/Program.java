/*
 * Faça um programa para ler um arquivo contendo funcionários (nome e salário) no 
 * formato .csv, armazenando-os em uma lista. Depois, ordenar a lista por nome e mostrar 
 * o resultado na tela. Nota: o caminho do arquivo pode ser informado "hardcode".
 * 
 * Dados de entrada do arquivo In_Comparable.csv:
 * Maria Brown,4300.00
 * Alex Green,3100.00
 * Bob Grey,3100.00
 * Anna White,3500.00
 * Alex Black,2450.00
 * Eduardo Rose,4390.00
 * Willian Red,2900.00
 * Marta Blue,6100.00
 * Alex Brown,5000.00
 * 
 * Resultado do processamento:
 * Alex Black, 2450.0
 * Alex Brown, 5000.0
 * Alex Green, 3100.0
 * Anna White, 3500.0
 * Bob Grey, 3100.0
 * Eduardo Rose, 4390.0
 * Maria Brown, 4300.0
 * Marta Blue, 6100.0
 * Willian Red, 2900.0
 */

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Employee;

public class Program {
	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();

		String path = "/home/frankazevedo/Workspaces/java_fundamental/interface05/resources/In_Comparable.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// Reading one line
			String employeeCsv = br.readLine();

			while (employeeCsv != null) {
				// Separating the line in two fields: field 0 equals "name" and field 1 equals
				// "salary"
				String[] fields = employeeCsv.split(",");
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}

			// Alphabetical Sorting
			Collections.sort(list);

			for (Employee emp : list) {
				System.out.println(emp.getName() + ", " + emp.getSalary());
			}
		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
