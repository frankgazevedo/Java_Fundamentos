package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Program04 {

	public static void main(String[] args) {
		LocalDate d04 = LocalDate.parse("2022-07-20");
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

		LocalDate pastWeekDate = d04.minusDays(7); // local date d04 minus 07 days
		LocalDate nextWeekDate = d04.plusDays(7); // local date d04 plus 07 days

		System.out.println("pastWeekDate = " + pastWeekDate);
		System.out.println("nextWeekDate = " + nextWeekDate);

		LocalDateTime pastWeekLocalDate = d05.minusDays(7); // local date Time d05 minus 07 days
		LocalDateTime nextWeekLocalDate = d05.plusDays(7); // Local Date Time d05 plus 07 days

		System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
		System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

		Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS); // Instant d06 minus 07 days
		Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);// Instant d06 plus 07 days

		System.out.println("pastWeekInstant = " + pastWeekInstant);
		System.out.println("nextWeekInstant = " + nextWeekInstant);

		// Duration t1 = Duration.between(pastWeekDate.atTime(0, 0), d04.atTime(0, 0));
		// // atStartOfDay() e atTime() produzem resultados similares
		Duration t1 = Duration.between(pastWeekDate.atStartOfDay(), d04.atStartOfDay()); // atStartOfDay() e atTime()
																							// produzem resultados
																							// similares
		Duration t2 = Duration.between(pastWeekLocalDate, d05);
		Duration t3 = Duration.between(pastWeekInstant, d06);
		Duration t4 = Duration.between(d06, pastWeekInstant);

		System.out.println("t1 dias = " + t1.toDays());
		System.out.println("t2 dias = " + t2.toDays());
		System.out.println("t3 dias = " + t3.toDays());
		System.out.println("t4 dias = " + t4.toDays());

	}

}
