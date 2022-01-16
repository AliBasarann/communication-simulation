
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	int totalTalkingMinutes = 0;
	int totalMessagingQuantity = 0;
	double totalNetworkAmount = 0;
	
	
	Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate){
		this.ID = ID;
		this.talkingCharge = talkingCharge;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.discountRate = discountRate;
		
	}
	
	//calculate methods for helping to calculate total charges
	
	double calculateTalkingCost(int minute, Customer customer) {
		if ((customer.getAge() < 18) || (customer.getAge() > 65)) {
			return  minute * talkingCharge*(1-((double)discountRate/100));
		} 
		else {
			return minute * talkingCharge;
		}
	}
	double calculateMessageCost(int quantity, Customer customer, Customer other) {
		if (customer.getOperator() == other.getOperator()) 
			return (1- ((double)discountRate/100))* quantity * messageCost;
		else 
			return quantity * messageCost;
	}
	double calculateNetworkCost(double amount) {
		return amount * networkCharge;
	}
	
	// getter and setter methods for operator informations
	
	double getTalkingCharge() {
		return talkingCharge;
	}
	double getMessageCost() {
		return messageCost;
	}
	double getNetworkCharge() {
		return networkCharge;
	}
	int getDiscountRate() {
		return discountRate;
	}
	void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}
	void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}
	void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}
	void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

