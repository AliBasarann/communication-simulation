
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	private double limitingAmount;
	private double currentDebt;
	double totalMoneySpent = 0;
	
	Bill(double limitingAmount){
		this.limitingAmount = limitingAmount;
		currentDebt = 0;
	}
	
	boolean check(double amount){
		return limitingAmount > (currentDebt + amount);
	}
	
	void add(double amount) {
		currentDebt += amount;
	}
	
	void pay(double amount) {
		if (amount <= currentDebt) {
			currentDebt -= amount;
			totalMoneySpent += amount;
		}
		else if (amount > currentDebt) {
			totalMoneySpent += currentDebt;
			currentDebt = 0;
			}
	}

	void changeTheLimit(double amount) {
		if (currentDebt < amount) {
			limitingAmount = amount;
		}
	}
	
	public double getLimitingAmount(){
		return limitingAmount;
	}
	
	public double getCurrentDebt() {
		return currentDebt;
	}

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

