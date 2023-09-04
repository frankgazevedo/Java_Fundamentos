package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		super();
		
		if (!checkOut.after(checkIn))
			throw new DomainException("Check-out date must be after check-in");

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public long duration() {

		// getTime() returns the time in milliseconds
		long diff = checkOut.getTime() - checkIn.getTime();

		// Transforming the time in milliseconds to days
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now))
			// Method 01
			//throw new IllegalArgumentException("Reservation dates for update must be future dates");
			
			// Method 02
			throw new DomainException("Reservation dates for update must be future dates");
		
		if (!checkOut.after(checkIn))
			throw new DomainException("Check-out date must be after check-in");

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Room: " + getRoomNumber() + ", ");
		sb.append("check-in: " + sdf.format(getCheckin()) + ", ");
		sb.append("check-out: " + sdf.format(getCheckout()) + ", ");
		sb.append(duration() + " nigths");

		return sb.toString();
	}

}