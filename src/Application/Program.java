package Application;

import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter Account Data");
			System.out.println("Account Number: ");
			int number = sc.nextInt();
			System.out.println("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.println("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.println("Withdraw limit: ");
			Double withDrawLimit = sc.nextDouble();
			Account account = new Account(number, holder, initialBalance, withDrawLimit);
			System.out.println("Account: " + account);
			System.out.println("Enter Ammount for withdraw: ");
			Double ammount = sc.nextDouble();
			account.withDraw(ammount);
			System.out.println("New Balance: " + String.format("%.2f",account.getBalance()));

		} catch (DomainException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
		sc.close();

	}

}
