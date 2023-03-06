package account.management;

public class Account {
	private String id;
	private String name;
	private int balance = 0;

	public Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public void credit(int amount) {
		if (validateParam(amount)) {
			balance += amount;
			System.out.println("Credit successfully");
		} else {
			System.out.println("Credit failed");
		}
	}

	public void debit(int amount) {
		if (validateParam(amount) && checkBalance(amount)) {
			balance -= amount;
			System.out.println("Debit successfully");
		} else {
			System.out.println("Debit failed");
		}
	}

	public void transferTo(Account account, int amount) {
		if (validateParam(amount) && checkBalance(amount)) {
			balance -= amount;
			account.balance += amount;
			System.out.println("Transfer successfully");
		} else {
			System.out.println("Transfer failed");
		}
	}

	public boolean validateParam(int param) {
		if (param < 0) {
			System.out.println("Invalid param");
			return false;
		}

		return true;
	}

	public boolean checkBalance(int amount) {
		if (amount > balance) {
			System.out.println("Balance is not enough");
			return false;
		}

		return true;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}
}
