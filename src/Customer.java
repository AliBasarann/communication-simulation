
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	int ID;
	String name;
	private int age;
	private Operator operator;
	private Bill bill;
	int talkingMinutes = 0;
	double networkAmount = 0;
	int messageQuantity = 0;
	
	
	// constructor of customer
	Customer(int ID, String name, int age, Operator operator, double limitingAmount){
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.operator = operator;
		this.bill = new Bill(limitingAmount);
		
	}
	
	// customer actions
	void talk(int minute, Customer other) {
		if (this.bill.check(this.operator.calculateTalkingCost(minute, this)) && (other != this)) {
			this.bill.add(this.operator.calculateTalkingCost(minute, this));
			this.operator.totalTalkingMinutes += minute;
			other.operator.totalTalkingMinutes += minute;
			this.talkingMinutes += minute;
			other.talkingMinutes += minute;
		}
	}
	
	void message(int quantity, Customer other) {
		if (this.bill.check(this.operator.calculateMessageCost(quantity, this, other)) && (other!=this)) {
			this.bill.add(this.operator.calculateMessageCost(quantity, this, other));
			this.operator.totalMessagingQuantity += quantity;
			this.messageQuantity += quantity;
		}
	}
	
	void connection(double amount) {
		if (this.bill.check(this.operator.calculateNetworkCost(amount))) {
			this.bill.add(this.operator.calculateNetworkCost(amount));
			this.operator.totalNetworkAmount += amount;
			this.networkAmount += amount;
		}
	}
	
	
	// getters and setters for customer informations
	int getAge() {
		return age;
	}
	
	Operator getOperator() {
		return operator;
	}
	
	Bill getBill() {
		return bill;
	}

	void setAge(int age) {
		this.age = age;
	}
	void setOperator(Operator operator) {
		this.operator = operator;
	}
	void setBill(Bill bill) {
		this.bill = bill;
	}
	
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

