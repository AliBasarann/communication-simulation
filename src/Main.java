
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		int operatorID = 0;
		int customerID = 0;
		
		//outstream for writing file
		PrintStream outstream1;
		try {
			outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		    e2.printStackTrace();
		    return;
		}
		
		
		// t represents the action that customer made
		for (int i = 0; i<N ; i++) {
			int t = reader.nextInt();
			//creating a customer
			if (t==1) {
				Customer customer = new Customer(customerID, reader.next(), reader.nextInt(), operators[reader.nextInt()], reader.nextDouble());
				customers[customerID] = customer;
				customerID += 1;
			}
			//creating an operator
			else if (t==2) {
				Operator operator = new Operator(operatorID,reader.nextDouble(),reader.nextDouble(),reader.nextDouble(),reader.nextInt());
				operators[operatorID] = operator;
				operatorID += 1;
			}
			//calling
			else if (t==3) {
				int calID = reader.nextInt();
				int otherID = reader.nextInt();
				int minute = reader.nextInt();
				if (calID<customerID && otherID <customerID) {
					Customer callingCustomer = customers[calID];
					Customer other = customers[otherID];
					callingCustomer.talk(minute, other);}
			}
			//send message
			else if (t==4) {
				int sendID = reader.nextInt();
				int otherID = reader.nextInt();
				int quantity = reader.nextInt();
				if (sendID<customerID && otherID<customerID) {
					Customer sender = customers[sendID];
					Customer other = customers[otherID];
					sender.message(quantity, other);}
			}
			//connect internet
			else if (t==5) {
				int id = reader.nextInt();
				double amount = reader.nextDouble();
				if (id<customerID) {
					Customer connectedCustomer = customers[id];
					connectedCustomer.connection(amount);}
			}
			// pay bills
			else if (t==6) {
				int id = reader.nextInt();
				double amount = reader.nextDouble();
				if (id < customerID){
				Customer payer = customers[id];
				payer.getBill().pay(amount);}
			}
			//change operator
			else if (t==7) {
				int cusID = reader.nextInt();
				int opID = reader.nextInt();
				if (cusID < customerID && opID<operatorID) {
				    Customer customer = customers[cusID];
				    Operator operator = operators[opID];
					customer.setOperator(operator);}
			}
			//change limit
			else if (t==8) {					
				int id = reader.nextInt();
				double newLimit = reader.nextDouble();
				if (id <customerID ) {
					Customer customer = customers[id];
					customer.getBill().changeTheLimit(newLimit);
				}
				
			}
		}
		// finding most talked, most messaged and most connected persons
		String mostTalkName = "";
		int mostTalkMinute = -1;
		String mostMessageName = "";
		int mostMessageQuantity = -1;
		String mostInternetName = "";
		double mostInternetAmount = -1;
		for (int i = 0 ; i<C ; i++) {
			if (customers[i].talkingMinutes > mostTalkMinute){
				mostTalkName = customers[i].name;
				mostTalkMinute = customers[i].talkingMinutes;
			}
		}	
		for (int i = 0 ; i<C ; i++) {
			if (customers[i].messageQuantity > mostMessageQuantity){
				mostMessageName = customers[i].name;
				mostMessageQuantity = customers[i].messageQuantity;
			}
		}	
		for (int i = 0 ; i<C ; i++) {
			if (customers[i].networkAmount > mostInternetAmount){
				mostInternetName = customers[i].name;
				mostInternetAmount = customers[i].networkAmount;
			}
		}	
		
		//printer for operator
		for (int i = 0 ; i<O; i++) {
			outstream1.print("Operator " + i + " : "+ operators[i].totalTalkingMinutes + " "+operators[i].totalMessagingQuantity + " ");
			outstream1.printf("%.2f", operators[i].totalNetworkAmount);
			outstream1.print("\n");
		}
		//printer for customers
		for (int i = 0; i<C ; i++) {
			outstream1.print("Customer "+i+" : ");
			outstream1.printf("%.2f",customers[i].getBill().totalMoneySpent);
			outstream1.print(" ");
			outstream1.printf("%.2f", customers[i].getBill().getCurrentDebt());
			outstream1.print("\n");
		}
		//printer for most talked, most messaged and most connected persons
		if (mostTalkName != "") {
			outstream1.print(mostTalkName + " : " + mostTalkMinute);
			outstream1.print("\n");
		}
		if (mostMessageName != "") {
			outstream1.print(mostMessageName + " : "+ mostMessageQuantity);
			outstream1.print("\n");
		}
		if (mostInternetName != "") {
			outstream1.print(mostInternetName + " : "); outstream1.printf("%.2f", mostInternetAmount);
		}
		outstream1.close();
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

