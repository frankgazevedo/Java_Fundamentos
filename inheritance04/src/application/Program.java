/*
 * Suponha que em um negócio relacionado a banco, apenas
 * contas poupança e contas para empresas são permitidas.
 * Não existe conta comum.
 * 
 * Para garantir que contas comuns não possam ser
 * instanciadas, basta acrescentarmos a palavra "abstract" na
 * declaração da classe:
 * 
 * 	public abstract class Account {
 * 	(...)
 * 
 * Notação UML: itálico
 * 
 * Classes Abstratas: São classes que não podem ser instanciadas.
 * É uma forma de garantir HERANÇA TOTAL: somente SUBclasses não
 * abstratas podem ser instanciadas, mas nunca a SUPERclasse abstrata
 * 
 * QUESTIONAMENTO: Se a classe Account não pode ser instanciada, por
 * que simplesmente não criar somente SavingsAccount
 * e BusinessAccount?
 * 
 * RESPOSTA:
 * 01) Reuso
 * 02) Polimorfismo: a SUPERclasse classe genérica nos permite tratar
 * de forma fácil e uniforme todos os tipos de conta, inclusive
 * com polimorfismo se for o caso. 
 * Por exemplo, você pode colocar todos tipos de contas em uma 
 * mesma coleção (COLLECTION).
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		/* Boa prática: utilizar o tipo mais genérico possível na Lista (SUPERclasse).
		 * Isso garante reuso e manutenibilidade do código em caso de alteração
		 * das SUBclasses.
		 * 
		 * É possível instanciar uma Collection (List) de tipo ABSTRACT (SUPERclasse),
		 * desde que sejam instanciados objetos concretos (SUBclasses) posteriomente (UPCASTING).
		 */
		List<Account> list = new ArrayList<>();

		list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01)); // instanciação de objeto concreto (SUBclasse)
		list.add(new BusinessAccount(1002, "Maria", 1000.0, 400.0)); // instanciação de objeto concreto (SUBclasse)
		list.add(new SavingsAccount(1004, "Bob", 300.0, 0.01)); // instanciação de objeto concreto (SUBclasse)
		list.add(new BusinessAccount(1005, "Anna", 500.0, 500.0)); // instanciação de objeto concreto (SUBclasse)

		double sum = 0.0;
		for (Account acc : list) {
			sum += acc.getBalance();
		}

		System.out.printf("Total balance: %.2f%n", sum);

		for (Account acc : list) {
			acc.deposit(10.0);
		}
		for (Account acc : list) {
			System.out.printf("Updated balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
		}
	}
}
