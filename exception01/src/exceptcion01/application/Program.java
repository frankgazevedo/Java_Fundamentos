/*
 * Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data 
 * de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em 
 * dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar 
 * novamente a reserva com os dados atualizados. O programa não deve aceitar dados 
 * inválidos para a reserva, conforme as seguintes regras: 
 * - Alterações de reserva só podem ocorrer para datas futuras 
 * - A data de saída deve ser maior que a data de entrada.
 * 
 * Exemplos:
 * 
 * Room number: 8021
 * Check-in date (dd/MM/yyyy): 23/09/2019
 * Check-out date (dd/MM/yyyy): 26/09/2019
 * Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
 * Enter data to update the reservation:
 * Check-in date (dd/MM/yyyy): 24/09/2019
 * Check-out date (dd/MM/yyyy): 29/09/2019
 * Reservation: Room 8021, check-in: 24/09/2019, check-out: 29/09/2019, 5 nights
 * 
 * Room number: 8021
 * Check-in date (dd/MM/yyyy): 23/09/2019
 * Check-out date (dd/MM/yyyy): 21/09/2019
 * Error in reservation: Check-out date must be after check-in date
 * 
 * Room number: 8021
 * Check-in date (dd/MM/yyyy): 23/09/2019
 * Check-out date (dd/MM/yyyy): 26/09/2019
 * Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
 * Enter data to update the reservation:
 * Check-in date (dd/MM/yyyy): 24/09/2015
 * Check-out date (dd/MM/yyyy): 29/09/2015
 * Error in reservation: Reservation dates for update must be future dates
 * 
 * Room number: 8021
 * Check-in date (dd/MM/yyyy): 23/09/2019
 * Check-out date (dd/MM/yyyy): 26/09/2019
 * Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
 * Enter data to update the reservation:
 * Check-in date (dd/MM/yyyy): 24/09/2020
 * Check-out date (dd/MM/yyyy): 22/09/2020
 * Error in reservation: Check-out date must be after check-in date 
 * 
*/

package exceptcion01.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exception01.model.entities.Reservation;
import exception01.model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room Number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}

		catch (ParseException e) {
			System.out.println("Invalid date format");
		}

		// Method 01
		/*
		 * catch (IllegalArgumentException e) {
		 * System.out.println("Error in reservation: " + e.getMessage()); }
		 */

		// Method 02
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
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