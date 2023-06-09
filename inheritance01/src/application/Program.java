package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		// UPCASTING: Casting (implícito) da SUBclasse para SUPERclasse
		// Uso comum: polimorfismo

		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

		// DOWNCASTING: Casting (explícito) da SUPERclasse para SUBclasse
		// Uso comum: métodos que recebem parâmetros GENÉRICOS (ex: Equals)

		BusinessAccount acc4 = (BusinessAccount) acc2; // necessário forçar o casting
		acc4.loan(100.0);

		// Lança uma exceção ClassCastException
		// BusinessAccount acc5 = (BusinessAccount)acc3; // Só detectável em tempo de execução
		if (acc3 instanceof BusinessAccount) { // false
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}

		if (acc3 instanceof SavingsAccount) { // true
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}

		Account acc6 = new Account(1001, "Alex", 1000.0);
		acc6.withdraw(200.0);
		System.out.println(acc6.getBalance());

		Account acc7 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
		acc7.withdraw(200.0);
		System.out.println(acc7.getBalance());

		Account acc8 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		acc8.withdraw(200.0);
		System.out.println(acc8.getBalance());
	}
}
