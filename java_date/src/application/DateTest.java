package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
	public static void main(String[] args) throws ParseException {

		// Specifying date formats
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		// Modifying the date format
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

		// Instantiating some dates
		Date y1 = sdf1.parse("01/02/2022");
		Date y2 = sdf2.parse("01/02/2022 13:06:54");

		// ISO 8601 format and Instant Class
		// The Z letter indicates the UTC standard
		Date y3 = Date.from(Instant.parse("2022-02-01T13:06:54Z"));

		// Printing some dates applying JVM date format
		System.out.println("Printing some dates applying JVM date format");
		System.out.println(y1);
		System.out.println(y2);
		System.out.println(y3);
		System.out.println();

		// Printing some dates applying specific date formats
		System.out.println("Printing some dates applying specific date formats");
		System.out.println(sdf1.format(y1));
		System.out.println(sdf1.format(y2));
		System.out.println(sdf1.format(y3));
		System.out.println();

		System.out.println("----------------------------------------");
		System.out.println(sdf2.format(y1));
		System.out.println(sdf2.format(y2));
		System.out.println(sdf2.format(y3));
		System.out.println();

		System.out.println("----------------------------------------");
		System.out.println(sdf3.format(y1));
		System.out.println(sdf3.format(y2));
		System.out.println(sdf3.format(y3));
		System.out.println();

		// Instantiating a date from the JVM
		Date x1 = new Date();
		Date x2 = new Date(System.currentTimeMillis());

		// Printing a date from the JVM applying JVM date format
		System.out.println("Printing a date from the JVM applying JVM date format");
		System.out.println(x1);
		System.out.println(x2);
		System.out.println();

		// Printing a date from the JVM applying specific date formats
		System.out.println("Printing a date from the JVM applying specific date formats");
		System.out.println(sdf1.format(x1));
		System.out.println(sdf1.format(x2));
		System.out.println();

		System.out.println("----------------------------------------");
		System.out.println(sdf2.format(x1));
		System.out.println(sdf2.format(x2));
		System.out.println();

		System.out.println("----------------------------------------");
		System.out.println(sdf3.format(x1));
		System.out.println(sdf3.format(x2));
		System.out.println();

	}

}