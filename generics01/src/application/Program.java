/*
 * Deseja-se fazer um programa que leia uma quantidade N, e depois N números
 * inteiros. Ao final, imprima esses números de forma organizada conforme
 * exemplo. Em seguida, informar qual foi o primeiro valor informado.
 * 
 * Exemplo:
 * How many values? 3
 * 10
 * 8
 * 23
 * [10, 8, 23]
 * First: 10
 */

package application;

import java.util.Scanner;

import model.services.PrintService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PrintService<Integer> ps = new PrintService<>();

		System.out.print("How many values? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			Integer value = sc.nextInt();
			ps.addValue(value);
		}

		ps.print();
		Integer x = ps.first();
		System.out.println("First: " + x);

		sc.close();
	}
}