package ATM;

import java.util.*;
import customer.Customer;
import account.AccountStatus;
import account.AccountTransactionType;
import app.CustomerManagement;

public class Atm {

private int userPin;
private double transactionAmount;
private int choice;
private boolean isRunning = true;
private AccountTransactionType transactionType;
private Customer customer;

public static void startATM(){

Atm atm = new Atm();

String line = "*********************************";

Scanner sc = new Scanner (System.in);

//abstraction and Anonymous inner class
ATMOperation operation = new ATMOperation(){
   
    @Override
    public void performOperation(){
        
        //enum with switch 
        switch(atm.transactionType) {

            case CHECKBALANCE -> {
                switch(atm.customer.getAccountStatus()){

                  case ACTIVE,FROZEN -> {
                  System.out.println("Current Balance: " + atm.customer.getBalance());
                  }
                  case BLOCKED ->{
                  System.out.println("Account is BLOCKED.");
                  System.out.println("Balance inquiry is not allowed.");
                  }   
                
                }
            }

            case DEPOSIT -> {
                switch(atm.customer.getAccountStatus()){

                    case ACTIVE,FROZEN ->{
                        
                        //enum with IF statement
                        if(atm.customer.getAccountStatus() == AccountStatus.FROZEN){

                            System.out.println("Account is Frozen but Deposit is Permitted.");

                        }

                        System.out.print("Enter the Deposit Amount: ");
                        atm.transactionAmount = sc.nextDouble();

                        if(atm.transactionAmount<=0){

                            System.out.println("Invaild Amount");
                            System.out.println("You cannot enter negative or zero");

                        }
                        else{

                            double newBalance = atm.customer.getBalance() + atm.transactionAmount;
                            atm.customer.setBalance(newBalance);
                            System.out.println("Deposit Successful.");
                            System.out.println("Current Balance : " + atm.customer.getBalance());
                            
                        }
                    }
                    case BLOCKED ->{

                        System.out.println("Account is Blocked.");
                        System.out.println("Deposit is not allowed.");
                    }
                }
            }

            case WITHDRAW -> {
                switch (atm.customer.getAccountStatus()) {

                    case ACTIVE ->{

                        System.out.print("Enter the Withdrawal Amount: ");
                        atm.transactionAmount = sc.nextDouble();
                        
                        if(atm.transactionAmount <= 0){

                            System.out.println("Invalid Amount");
                            System.out.println("You cannot enter negative or zero");

                        }
                        else if(atm.transactionAmount > atm.customer.getBalance()){

                            System.out.println("Insufficient Balance");

                        }
                        else{

                            double newBalance = atm.customer.getBalance() - atm.transactionAmount;
                            atm.customer.setBalance(newBalance);
                            System.out.println("Withdrawal Successful.");
                            System.out.println("Current Balance : " + atm.customer.getBalance());

                        }
                    }
                    case FROZEN,BLOCKED ->{
                      
                        //enum with IF statement
                        if(atm.customer.getAccountStatus() == AccountStatus.FROZEN){

                            System.out.println("Account is FROZEN.");
                            System.out.println("Withdrawal is not allowed.");

                        }else if(atm.customer.getAccountStatus() == AccountStatus.BLOCKED){

                            System.out.println("Account is BLOCKED.");
                            System.out.println("Withdrawal is not allowed.");

                        } 
                    }
                }
            }

        }
    }
};

System.out.println(line);
System.out.println("WELCOME TO KAVI BANK ATM");
System.out.println(line);

System.out.print("Enter ATM PIN:");
atm.userPin = sc.nextInt();

atm.customer = CustomerManagement.getCustomerByPin(atm.userPin);

if(atm.customer != null){

while(atm.isRunning) {

System.out.println(line);
System.out.println("KAVI BANK ATM");
System.out.println(line);

System.out.println("1. " + AccountTransactionType.CHECKBALANCE);
System.out.println("2. " + AccountTransactionType.DEPOSIT);
System.out.println("3. " + AccountTransactionType.WITHDRAW);
System.out.println("4. EXIT \n" + line);

System.out.print("Enter Your Choice: ");
atm.choice = sc.nextInt();

switch(atm.choice){

case 1 -> {
    atm.transactionType = AccountTransactionType.CHECKBALANCE;
    operation.performOperation();}

case 2 -> {
    atm.transactionType = AccountTransactionType.DEPOSIT;
    operation.performOperation();}

case 3 -> {
    atm.transactionType = AccountTransactionType.WITHDRAW;
    operation.performOperation();}

case 4 -> {System.out.println("Thank you for using KAVI BANK ATM.");
            atm.isRunning = false;}

default -> System.out.println("Invalid User Input");

}
}
}else{
System.out.println("Incorrect PIN");
}

sc.close();
}
}

// public void deposit(double amount){
// if(amount <= 0){
// System.out.println("Invaild Input");
// }else if ( amount > 10000){
// System.out.println("Maxmium Deposit limit is 10K only.");
// }else if(amount >= 100){
// System.out.println("Enter the Deposit Amount: ");
// balance += amount;
// System.out.println("Current Balance: " + balance);
// }else{
// System.out.println("Minimum Deposit amount must be 100rs. ");
// }
// }
// public void withdraw(double amount){
// if(amount > balance){
// System.out.println("Insufficient Balance.");
// }else if( amount > 10000){
// System.out.println("Maxmium Withdrawal limit is 10K only.");
// }else if (amount >= 100 && amount < balance){
// System.out.println("Enter the Withdrawal Amount: ");
// balance -= amount;
// System.out.println("Current Balance: " + balance);
// }else{
// System.out.println("Minimum Withdrawal amount must be 100rs. ");
// }
// }
