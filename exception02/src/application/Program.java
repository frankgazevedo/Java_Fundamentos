/*
 * Fazer um programa para ler os dados de uma conta bancária e depois realizar um 
 * saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer 
 * ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de 
 * saque da conta. Implemente a conta bancária conforme projeto abaixo:
 * 
 * Exemplos:
 * Enter account data
 * Number: 8021
 * Holder: Bob Brown
 * Initial balance: 500.00
 * Withdraw limit: 300.00
 * Enter amount for withdraw: 100.00
 * New balance: 400.00
 * 
 * Enter account data
 * Number: 8021
 * Holder: Bob Brown
 * Initial balance: 500.00
 * Withdraw limit: 300.00
 * Enter amount for withdraw: 400.00
 * Withdraw error: The amount exceeds withdraw limit
 * 
 * Enter account data
 * Number: 8021
 * Holder: Bob Brown
 * Initial balance: 500.00
 * Withdraw limit: 300.00
 * Enter amount for withdraw: 800.00
 * Withdraw error: The amount exceeds withdraw limit
 * 
 * Enter account data
 * Number: 8021
 * Holder: Bob Brown
 * Initial balance: 200.00
 * Withdraw limit: 300.00
 * Enter amount for withdraw: 250.00
 * Withdraw error: Not enough balance
 *  
 */
package exception02.application;

import java.util.Scanner;

import exception02.model.exceptions.DomainException;
import exception02.model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();			
			sc.nextLine();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			
			account.withdraw(amount);
			
			System.out.println();
			
			System.out.println("New balance: " + account.getBalance());

			}

		// Method 01
		/*
		 * catch (IllegalArgumentException e) {
		 * System.out.println("Error in reservation: " + e.getMessage()); }
		 */

		// Method 02
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}

		// For any other exception type (generic exception: RuntimeException)
		// Up casting
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		finally {
			sc.close();
			System.out.println("End of Program");
		}

	}

}