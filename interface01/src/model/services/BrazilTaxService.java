package model.services;

public class BrazilTaxService implements TaxService {

	private static final double TAX_PERCENTAGE_UP_TO_100 = 0.2;
	private static final double TAX_PERCENTAGE_AFTER_100 = 0.15;

	public double tax(double amount) {
		if (amount <= 100.0)
			return amount * TAX_PERCENTAGE_UP_TO_100;
		else
			return amount * TAX_PERCENTAGE_AFTER_100;
	}
}