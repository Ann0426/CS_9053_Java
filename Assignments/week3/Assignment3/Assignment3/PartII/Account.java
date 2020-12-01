 
public class Account {
	private static int account_count = 0;
	private double balance = 1000;
	private int id = 0;
	
	public Account() {
		this.id = Account.account_count;
		Account.account_count++;
		
	}
	public Account(double startingBalance) {
		this();
		this.balance = startingBalance;
		
	}
	public boolean withdraw (double amount) {
		this.balance -= amount;
		if (this.balance >0 )
			return true ;
		else {
			this.balance += amount;
			return false;
		}	
	}
	public void deposit (double amount) {
		this.balance += amount;
		
	}
	public int getId() {
		return this.id;
	}
	public double getBalance() {
		return this.balance;
	}

}
