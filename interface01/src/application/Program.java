/*
 * Uma locadora brasileira de carros cobra um valor por hora para locações de até 
 * 12 horas. Porém, se a duração da locação ultrapassar 12 horas, a locação será 
 * cobrada com base em um valor diário. Além do valor da locação, é acrescido no 
 * preço o valor do imposto conforme regras do país que, no caso do Brasil, é 20% 
 * para valores até 100.00, ou 15% para valores acima de 100.00. Fazer um 
 * programa que lê os dados da locação (modelo do carro, instante inicial e final da 
 * locação), bem como o valor por hora e o valor diário de locação. O programa 
 * deve então gerar a nota de pagamento (contendo valor da locação, valor do 
 * imposto e valor total do pagamento) e informar os dados na tela.
 * 
 * Exemplos:
 * 
 * Enter rental data
 * Car model: Civic
 * Pickup (dd/MM/yyyy hh:mm): 25/06/2018 10:30
 * Return (dd/MM/yyyy hh:mm): 25/06/2018 14:40
 * Enter price per hour: 10.00
 * Enter price per day: 130.00
 * INVOICE:
 * Basic payment: 50.00
 * Tax: 10.00
 * Total payment: 60.00
 * 
 * Calculations:
 * Duration = (25/06/2018 14:40) - (25/06/2018 10:30) = 4:10 = 5 hours
 * Basic payment = 5 * 10 = 50
 * Tax = 50 * 20% = 50 * 0.2 = 10
 * 
 * Enter rental data
 * Car model: Civic
 * Pickup (dd/MM/yyyy hh:mm): 25/06/2018 10:30
 * Return (dd/MM/yyyy hh:mm): 27/06/2018 11:40
 * Enter price per hour: 10.00
 * Enter price per day: 130.00
 * INVOICE:
 * Basic payment: 390.00
 * Tax: 58.50
 * Total payment: 448.50
 * 
 * Calculations:
 * Duration = (27/06/2018 11:40) - (25/06/2018 10:30) = 2 days + 1:10 = 3 days
 * Basic payment = 3 * 130 = 390
 * Tax = 390 * 15% = 390 * 0.15 = 58.50
 * 
 */

package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();

		// Inversion of Control by Dependency Injection
		// Up casting: BrazilTaxService implements TaxService
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		rentalService.processInvoice(carRental);

		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

		sc.close();
	}
}