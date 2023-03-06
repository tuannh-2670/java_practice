package account.management;

public class Main {

	public static void main(String[] args) {
		Account ac1 = new Account("A1", "Nguyen Van A", 50000);
		Account ac2 = new Account("A2", "Nguyen Van B", 10000);

		System.out.println("Balance of ac1: " + ac1.getBalance());
		System.out.println("Balance of ac2: " + ac2.getBalance());
		System.out.println("Add 20.000 to ac1:");
		ac1.credit(20000);
		System.out.println("Balance of ac1 after adding money: " + ac1.getBalance());
		System.out.println("Debit 50.000 to ac1:");
		ac1.debit(50000);
		System.out.println("Balance of ac1 after debiting money: " + ac1.getBalance());
		System.out.println("Add 50.000 to ac2:");
		ac2.credit(50000);
		System.out.println("Balance of ac2 after adding money: " + ac2.getBalance());
		System.out.println("ac2 transfer to ac1 15.000:");
		ac2.transferTo(ac1, 15000);
		System.out.println("Balance of ac1 after transfer money: " + ac1.getBalance());
		System.out.println("Balance of ac2 after transfer money: " + ac2.getBalance());
	}
}
