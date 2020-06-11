package model.entities;

import model.exception.DomainException;

public class Account {

	private Integer number;
	private String holder;;
	private Double balance;
	private Double withDrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {

		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
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

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public Double deposit(Double ammount) {

		return getBalance() + ammount;
	}

	public void withDraw(Double ammount) throws DomainException {

		if (ammount > getBalance()) {
			throw new DomainException("Not enough balance");

		} else if (ammount > withDrawLimit) {
			throw new DomainException("The Ammount exceeds withdraw limit");
		} else {
			balance -= ammount;
		}
	}

	public String toString() {
		return "Account: " + getNumber() + " Holder: " + getHolder() + " Initial Balance: " + getBalance()
				+ " Withdraw Limit: " + getWithDrawLimit();
	}

}
