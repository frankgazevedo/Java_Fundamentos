package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class DateWithCalendar {
	public static void main(String[] args) throws ParseException {

		// Specifying date formats
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		// ISO 8601 format and Instant Class
		// The Z letter indicates the UTC standard
		Date d = Date.from(Instant.parse("2022-02-01T18:32:54Z"));

		// Printing a date from the JVM applying specific date formats
		System.out.println("Printing a date from the JVM applying specific date formats");
		System.out.println(sdf.format(d));
		System.out.println();

		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY, 4);
		d = cal.getTime();

		// Printing a date from the JVM applying specific date formats
		System.out.println("Printing a date from the JVM applying specific date formats");
		System.out.println(sdf.format(d));
		System.out.println();

		// Get date parts
		int minutes = cal.get(Calendar.MINUTE);
		System.out.println(minutes);
		System.out.println();

		int days = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		System.out.println();

		days = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(days);
		System.out.println();

		days = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println(days);
		System.out.println();

		days = cal.get(Calendar.DAY_OF_YEAR);
		System.out.println(days);
		System.out.println();

		int month = 1 + cal.get(Calendar.MONTH);
		System.out.println(month);
		System.out.println();

		// Printing some dates applying JVM date format
		System.out.println("Printing some dates applying JVM date format");
		System.out.println(sdf);
		System.out.println();

		// Printing some dates applying specific date formats
		System.out.println("Printing some dates applying specific date formats");
		System.out.println(sdf.format(d));
		System.out.println();

		// Printing a date from the JVM applying JVM date format
		System.out.println("Printing a date from the JVM applying JVM date format");
		System.out.println(d);
		System.out.println();
	}

}