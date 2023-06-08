package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Program03 {

	public static void main(String[] args) {

		// Imprimindo os ZoneIDs disponíveis
		// for (String s : ZoneId.getAvailableZoneIds())
		// System.out.println(s);

		LocalDate d04 = LocalDate.parse("2022-07-20");
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

		LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault()); // converte um Global Date (Instant) para um
																			// Local Date com a ZoneID do sistema do
																			// usuário
		LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
		LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
		LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

		System.out.println("r1 = " + r1); // o Instant d06 em Londres (GMT) é dia 20, no sistema local (GMT-4: Manaus),
											// é dia 19
		System.out.println("r2 = " + r2); // o Instant d06 em Londres (GMT) é dia 20, em Portugal (GMT+1: Portugal), é
											// dia 20
		System.out.println("r3 = " + r3); // o Instant d06 em Londres (GMT) é 01:30, no sistema local (GMT-4: Manaus), é
											// 21:30 (do dia 19)
		System.out.println("r4 = " + r4); // o Instant d06 em Londres (GMT) é 01:30, em Portugal (GMT+1: Portugal), é
											// 02:30 (do dia 20)

		System.out.println("d04 dia = " + d04.getDayOfMonth());
		System.out.println("d04 mês = " + d04.getMonthValue());
		System.out.println("d04 ano = " + d04.getYear());

		System.out.println("d05 hora = " + d05.getHour());
		System.out.println("d05 minutos = " + d05.getMinute());

	}

}
