    package ATM;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    import customer.Customer;
    import account.AccountStatus;
    import account.AccountTransactionType;
    import app.CustomerManagement;

    class cashRefill implements Runnable{
        private Atm atm;

        public cashRefill(Atm atm){
            this.atm = atm;
        }

        public void run(){

        atm.setAtmAmount();

        }
    }

    class receiptGenerator implements Runnable{

        private Customer customer;
        private AccountTransactionType transcationType;
        private double transactionAmount;
        private String line;
        

        public receiptGenerator(Customer customer, AccountTransactionType transactionType, double transactionAmount,String line){
            this.customer = customer;
            this.transcationType = transactionType;
            this.transactionAmount = transactionAmount;
            this.line = line;

        }

        public void run(){
    
            System.out.println("Receipt generation started...");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(line );
            System.out.println("KAVI BANK");
            System.out.println(line);

            System.out.println( 
                "Acoount Number   : " + customer.getAccountNumber() + "\n" +
                "Transcation Type : " + transcationType + "\n" +
                "Amount           : " + transactionAmount + "\n" +
                "Current Balance  : " + customer.getBalance()
            );

            System.out.println(line);
            System.out.println("Receipt generated");
            
        }
    }
    class depositThread extends Thread{

        private Atm atm;
        private double transactionAmount;

        public depositThread(Atm atm, double transactionAmount){
            this.atm = atm;
            this.transactionAmount = transactionAmount;
        }

        public void run(){
            try{
                System.out.println("Deposit processing...");
                Thread.sleep(3000);
                atm.calculateDeposit(transactionAmount);  
            }catch(InvalidAmountException e){
                System.out.println("Invalid Input. \"Amount should not be negative or Zero\"." + " | " + e);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }catch(Exception e){
                System.out.println("Something when wrong");
            }
        }
    }

    class withdrawThread extends Thread{
        private Atm atm;
        private double transactionAmount;

        public withdrawThread(Atm atm, double transactionAmount){
            this.atm = atm;
            this.transactionAmount = transactionAmount;
        }

        public void run(){
            try {
                System.out.println("Withdraw processing..");
                sleep(500);
                atm.calculateWithdraw(transactionAmount);
            }catch(InvalidAmountException e){
                System.out.println("Invalid Input. \"Amount should not be negative or Zero\"." + " | " + e);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e) {
                System.out.println("Something when wrong");
            }
        }
    }
    public class Atm {

    private String inputPin;
    private double transactionAmount;
    private int choice;
    private boolean isRunning = true;
    private AccountTransactionType transactionType;
    private Customer customer;
    private String line = "*********************************";
    private double atmAmount = 0;

    public void atmMenu(){

        System.out.println(line);
        System.out.println("WELCOME TO KAVI BANK ATM");
        System.out.println(line);

        System.out.println("1. " + AccountTransactionType.CHECKBALANCE);
        System.out.println("2. " + AccountTransactionType.DEPOSIT);
        System.out.println("3. " + AccountTransactionType.WITHDRAW);
        System.out.println("4. EXIT \n" + line);

        System.out.print("Enter Your Choice: ");

    }

    public void setInputPin(String inputPin){
        this.inputPin = inputPin;
    }

    public String  getInputPin(){
        return inputPin;
    }

    public synchronized void setAtmAmount(){

    if(atmAmount <= 0) {
        atmAmount += 10000;
        notifyAll();
    } 
    }

    //Throw and Throws Demonstrate 
    public void validatePin() throws InvalidPinException{
        
        if(getInputPin().isBlank()){ 
        throw new InvalidPinException("It can't be Blank.");
        }
        else if(getInputPin().startsWith("-")){
        throw new InvalidPinException("Pin can't be contain negative values.");
        }
        else if (!getInputPin().matches("\\d{4}")){
        throw new InvalidPinException("Pin doesn't exist 4 digits.");
        } 
    }

    public void calculateDeposit(double deposit) throws InvalidAmountException{

        if(deposit<=0){
            throw new InvalidAmountException();
        }else{
            double newBalance = customer.getBalance() + deposit;
            customer.setBalance(newBalance);
            System.out.println("Deposit Successful.");
            System.out.println("Current Balance : " + customer.getBalance());
        }
    }

    public synchronized void calculateWithdraw(double withdraw) throws InvalidAmountException{

        if(withdraw <= 0){
            throw new InvalidAmountException("Invaild Amount.");
        }
        else if(withdraw > customer.getBalance()){
            System.out.println("Insufficient Balance.");
        }else{
            if(atmAmount >= withdraw){
                atmAmount -= withdraw;
                double newBalance = customer.getBalance() - withdraw;
                customer.setBalance(newBalance);
                System.out.println("Withdrawal Successful.");
                System.out.println("Current Balance : " + customer.getBalance());

                receiptGenerator receipt = new receiptGenerator(customer,transactionType,transactionAmount,line);
                Thread withdrawreceipt  = new Thread(receipt);

                withdrawreceipt.start();      
                withdrawreceipt.setPriority(Thread.MIN_PRIORITY);

                try {
                    withdrawreceipt.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else{

                try {
                
                    if (atmAmount < withdraw) {
                        System.out.println(line);
                        System.out.println("Insufficient Cash in Atm Machine");
                        System.out.println("Sorry!, Unable to dispense cash");
                        System.out.println("Available only = " + atmAmount);
                        System.out.println("Try again later"); 
                        return ;
                    }

                   wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
            }
        }
    }

    public static void startATM(){

        Atm atm = new Atm();

        Scanner sc = new Scanner (System.in);


        // =====================================================================================================
        //abstraction and Anonymous inner class
        ATMOperation operation = new ATMOperation(){
        
            @Override
            public void performOperation() throws InvalidAmountException{
                
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

                            case ACTIVE ->{
                                
                                depositThread deposit = new depositThread(atm,atm.transactionAmount);

                                deposit.start();
                                deposit.setPriority(Thread.NORM_PRIORITY);

                                try {
                                    deposit.join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                receiptGenerator receipt = new receiptGenerator(atm.customer,atm.transactionType,atm.transactionAmount,atm.line);
                                Thread deopsitreceipt  = new Thread(receipt);

                                deopsitreceipt.start();
                                deopsitreceipt.setPriority(Thread.MIN_PRIORITY);

                                try {
                                    deopsitreceipt.join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            case FROZEN,BLOCKED ->{
                                
                                //enum with IF else statement
                                if(atm.customer.getAccountStatus() == AccountStatus.FROZEN){

                                    System.out.println("Account is Frozen");
                                    System.out.println("Transacton is not allowed.");

                                } else if(atm.customer.getAccountStatus() == AccountStatus.BLOCKED){

                                    System.out.println("Account is Blocked.");
                                    System.out.println("Transacton is not allowed.");

                                }
                            }
                        }
                    }

                    case WITHDRAW -> {
                        switch (atm.customer.getAccountStatus()) {

                            case ACTIVE ->{
                            
                            withdrawThread withdrawC1= new withdrawThread(atm,atm.transactionAmount);

                            withdrawC1.start();
                            withdrawC1.setPriority(Thread.MAX_PRIORITY);

                            withdrawThread withdrawC2 =  new withdrawThread(atm, atm.transactionAmount);
                            
                            withdrawC2.start();
                            withdrawC2.setPriority(Thread.MAX_PRIORITY);

                            cashRefill cashRefill = new cashRefill(atm);
                            Thread cash = new Thread(cashRefill);
                            cash.start();

                            try {
                                withdrawC1.join();
                                withdrawC2.join();
                                cash.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                            }
                            case FROZEN,BLOCKED ->{
                            
                                //enum with IF else statement
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

        // =====================================================================================================

        //Try without using finally to close the resources
        try{
            while(atm.isRunning){
                //try with resources it can auto closeable
                try(InputStreamReader in = new InputStreamReader(System.in);
                    BufferedReader bf = new BufferedReader(in);){

                    System.out.print("Enter The Pin Number: ");
                    atm.setInputPin(sc.nextLine());

                    atm.validatePin();
                    
                    //Convert the String into integer using Wrapper
                    int userPin = Integer.parseInt(atm.inputPin);
                    atm.customer = CustomerManagement.getCustomerByPin(userPin);

                    if(atm.customer != null){

                        while(atm.isRunning) {

                            //loop the enum using values and store in the array
                            AccountTransactionType[] transactionMethods = AccountTransactionType.values(); 

                            atm.atmMenu();
                            atm.choice = sc.nextInt();
                            sc.nextLine();
                            System.out.println(atm.line);

                            if (atm.choice == 4) {

                                System.out.println("Thank you for using KAVI BANK ATM." + "\n" + atm.line);
                                atm.isRunning = false;

                            }else if(atm.choice < 1 || atm.choice > transactionMethods.length){

                                System.out.println("Invaild Input");
                                continue;

                            }else{
                                
                                AccountTransactionType transactionType = transactionMethods[atm.choice -1];
                                switch(transactionType){

                                    case CHECKBALANCE -> {
                                        atm.transactionType = AccountTransactionType.CHECKBALANCE;
                                        operation.performOperation();}

                                    case DEPOSIT -> {
                                        System.out.print("Enter The Amount For Deposit = "); 
                                        atm.transactionAmount = Integer.parseInt(bf.readLine());

                                        atm.transactionType = AccountTransactionType.DEPOSIT;
                                        operation.performOperation();}

                                    case WITHDRAW -> {
                                        System.out.print("Enter The Amount For Withdraw = ");
                                        atm.transactionAmount = Integer.parseInt(bf.readLine());
                                        
                                        atm.transactionType = AccountTransactionType.WITHDRAW;
                                        operation.performOperation();}

                                    default -> System.out.println("Invalid User Input");

                                }
                            }
                            Thread.sleep(20);
                        }
                    }else{
                        System.out.println("Invalid Pin");
                        atm.isRunning = false;
                    }
                }//try and catch with default and cutsom exception    
                catch(InputMismatchException e){
                    System.out.println("Invalid Input. Please enter a number.");
                    sc.nextLine();
                }
                catch(NoSuchElementException e){
                    System.out.println("\n" + "User Terminated the Window" + "\n" + atm.line);
                    atm.isRunning = false;
                }
                catch(InvalidPinException e){
                    System.out.println("Invaild Pin" + " | " + e );
                    break;
                }catch(NumberFormatException e){
                    System.out.println("Invaild Input.");
                    break;
                }
                catch(IOException e){
                    System.out.println("Something Happen Because of IO");
                }
                catch(IllegalStateException e){
                    System.out.println("Something Went Wrong Because Of Scanner Closed");
                    break;
                }
                catch (InvalidAmountException e) {
                    System.out.println("Invalid Input. \"Amount should not be negative or Zero\"." + " | " + e);
                }
                catch(IllegalThreadStateException e){
                    System.out.println("Thread object can be started only once. | " + e );
                }
                catch(Exception e){
                    System.out.println("Something Went Wrong!" + e);
                }
            }
        }finally{

            System.out.println("ATM session ended.");
            sc.close();

        }

    }

    public static void main(String[] args) {
        CustomerManagement.startBank();
        Atm.startATM();
    }

    }

