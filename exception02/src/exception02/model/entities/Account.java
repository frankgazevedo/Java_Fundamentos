package exception02.model.entities;

import exception02.model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws DomainException {
		super();

		if (balance < 0)
			throw new DomainException("Negative balance");

		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(double amount) throws DomainException {
		if (amount < 0)
			throw new DomainException("Negative amount");
		else
			setBalance(balance += amount);
	}

	public void withdraw(double amount) throws DomainException {
		if (getWithdrawLimit() == 0 || amount > getBalance())
			throw new DomainException("Not enough balance");
		else if (amount > getWithdrawLimit())
			throw new DomainException("The amount exceeds withdraw limit");
		else
			setBalance(balance -= amount);
	}
}