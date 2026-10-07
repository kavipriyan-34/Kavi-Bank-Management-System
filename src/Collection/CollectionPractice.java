package Collection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

import Collection.customer.cardNumbers;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Optional;

class customer implements Comparable<customer>{

    private int customerId;
    private double balance;
    private long cardNumber;

    private String name;
    private String number;

    protected static String line = "******************************************";

    private Scanner sc;
    private List<customer> clients;
    private List<Transaction> transactions;
    private Map<Integer,customer> customers;
    
    
    public static void welcome(){
        System.out.println(line + "\n" + "     Welcome to Kavi Bank       " + "\n" + line);
    }

    public void choice(){

        System.out.println(

            "1.  Search Customer By ID"  + "\n" + 
            "2.  List All Mobile Number" + "\n" +
            "3.  Update a Mobile Number" + "\n" +
            "4.  Transaction History"    + "\n" + 
            "5.  List All Customers"     + "\n" +
            "6.  Remove a Customer"      + "\n" +
            "7.  Loan Application"       + "\n" +
            "8.  Cash Deposit"           + "\n" +
            "9.  Audit List"             + "\n" +
            "10. Sorting"               + "\n" +  
            "11. Exit"                   + "\n" + 
            line

        );

    }

    public void subdisplay(){

        System.out.println(
            
            line                                       + "\n" +
            "1. Customers List Sort by Customer Id"    + "\n" +
            "2. Customers List Sort by Name order"     + "\n" +
            "3. Txt History Sort by Txt Id"            + "\n" + 
            "4. Txn History Sort by Txt Amt"           + "\n" +
            "5. Go to main menu"                       + "\n" + 
            "6. Exit"                                  + "\n" +
            line

        );

    }

    public List<customer> getClients() {
        return clients;
    }

    public void setClients(List<customer> clients) {
        this.clients = clients;
    }

    public void setCustomers(Map<Integer, customer> customers) {
        this.customers = customers;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public customer searchId(){
        
        System.out.print("Enter the Customer Id = ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(customer.line);

        customer client = customers.get(id);

        if(client != null){

            System.out.println("Account Details" + "\n" + customer.line);
            System.out.println(client);

            return client;  

        }else{

            System.out.println("Customer Not Found!");
            return null;

        }

    }

    public void deposit(customer client){
        
        System.out.print("Enter the Deposit Amount = ");
        double deposit = sc.nextDouble();
        System.out.println(line);

        double newBalance = deposit + client.getBalance();
        client.setBalance(newBalance);

        System.out.println(client);

    }

    public String accountVaildation(){
        
        while(true){

            System.out.println("Confrim The Customer Details");
            System.out.print("Enter Yes or No = ");

            String confrim = sc.nextLine();

            System.out.println(customer.line);

            if(confrim.equalsIgnoreCase("Yes")){
            
                return "Yes";

            }else if(confrim.equalsIgnoreCase("No")){

                System.out.println("Enter again the customerId correctly."+ "\n" + customer.line);

                if(searchId() == null){
                  return "";
                }

                continue;

            }else{

                System.out.println("Invaild Input! Try again." + "\n" + customer.line);
                continue;
                
            }

        }

    }

    public void updateNumber(customer client){

        System.out.print("Enter a new mobile number : ");
        client.setNumber(sc.nextLine());
        System.out.println("Mobile Number Updated Successfully.");

    }

    private int generateCustomerId(){
        Random random = new Random();
        return random.nextInt(900000) + 100000;
    }

    public void setCardNumber(long cardNumber){
        this.cardNumber = cardNumber;
    }

    public customer(){

    }

    public customer(String name, double balance,String number){

        this.customerId = generateCustomerId();
        this.name = name;
        this.balance = balance;
        this.number = number;
        this.transactions = new LinkedList<>();

    }

    public void addTranscation(Transaction transaction){
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getNumber() {
        return number;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return 
        "customerId    = "  + customerId + "\n" +
        "Name          = "  + name       + "\n" + 
        "Mobile Number = "  + number     + "\n" +
        "Balance       = "  + balance    + "\n" + 
        "Card Number   = "  + cardNumber + "\n" + line;
    }

    public int compareTo(customer that){

       return this.name.compareTo(that.name);
    
    }
 
    class cardNumbers{

        private long cardNumber;
        private int customerId;

        public cardNumbers(long cardNumber,int customerId){

            this.cardNumber = cardNumber;
            this.customerId = customerId;

        }

        public long getCardNumber(){
            return cardNumber;
        }

        public int getCustomerId(){
            return customerId;
        }

        @Override
        public boolean equals(Object obj) {

            if(this == obj)
                return true;

            if(!(obj instanceof cardNumbers))
                return false;

            cardNumbers other = (cardNumbers) obj;

            return this.cardNumber == other.cardNumber;
            
        }

        @Override
        public int hashCode() {

            return Long.hashCode(cardNumber);

        }

        
    }
}

class Transaction {

    private String transactionId;
    private LocalDate date;
    private double amount;
    private String type;
    protected static String line = "******************************************************";
    
    private String settransactionId(){

        Random rm = new Random();   
        int number = rm.nextInt(10000);
        return transactionId = "T" + number;

    }

    public String getType() {
        return type;
    }

    public void setTransaction(String[][] transactionList,customer client){
         
        for(int i=0;i<transactionList.length;i++){
    
            Transaction transaction = new Transaction(transactionList[i][0],Double.parseDouble(transactionList[i][1]), LocalDate.parse(transactionList[i][2]));

            client.addTranscation(transaction);

        }

    }

    public double getAmount() {
        return amount;
    }

    public Transaction getTransaction(Transaction transaction){
        return transaction;
    }

    public Transaction(){

    }

    public Transaction(String type, double amount, LocalDate date){

        this.transactionId = settransactionId();
        this.type = type;
        this.amount = amount;
        this.date = date;

    }

    public String getTransactionId() {
        return transactionId;
    }

    @Override 

    public String toString(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return String.format(
            "| %-5s | %-16s | %10.1f | %10s |",
            transactionId,
            type,
            amount,
            date.format(formatter)
        );

    }
    
}

class Loan{

    private String applicationId;
    private customer applicant;
    private double loanAmount;
    private String loanType;
    private String loanStatus;
    private Scanner sc;
        protected static String line = "*******************************************************************************";

    private String generateApplicationId(){
        Random rm = new Random();
        return "A" + (rm.nextInt(900000)+100000);
    }

    public Loan(){

    }

    public Loan(customer applicant, double loanAmount,String loanType,String loanStatus){

        this.applicationId = generateApplicationId();
        this.applicant = applicant;
        this.loanAmount = loanAmount;
        this.loanType = loanType;
        this.loanStatus = loanStatus;

    }

    public void display(){

        System.out.println(
            
            customer.line                      + "\n" +
            "1. View all Applications Details" + "\n" +
            "2. View all Pending Applications" + "\n" +
            "3. View next Application Details" + "\n" +
            "4. Process next Application"      + "\n" +
            "5. Add New Loan Application"      + "\n" +
            "6. Go to main menu"               + "\n" + 
            "7. Exit"                          + "\n" +
            customer.line

        );

    }

    public void displayFormat(){

        System.out.println(line);
        System.out.printf(
            "%-7s | %-16s | %-12s | %-24s | %-10s%n",
            "ID", "APPLICANT",  "AMOUNT",  "LOAN TYPE", "STATUS"
        );
        System.out.println(line);

    }

    public void listLoanTypes(){

        System.out.println(
            customer.line                  + "\n" +
            "1.  Gold Loan"                + "\n" +
            "2.  Home Loan"                + "\n" +
            "3.  Travel Loan"              + "\n" + 
            "4.  Medical Loan"             + "\n" +
            "5.  Vehicle Loan"             + "\n" +
            "6.  Wedding Loan"             + "\n" +
            "7.  Business Loan"            + "\n" +
            "8.  Consumer Loan"            + "\n" +
            "9.  Personal Loan"            + "\n" +    
            "10. Education Loan"           + "\n" +
            "11. Overdraft Loan"           + "\n" +
            "12. Agriculture Loan"         + "\n" +
            "13. Home Renovation Loan"     + "\n" +           
            "14. Loan Against Property"    + "\n" +
            "15. Debt Consolidation Loan"  + "\n" +
            customer.line 
        );
        
    }

    public String selectLoanType(int option){
 
        return switch (option) {

            case 1: yield "Gold Loan";
            case 2:  yield "Home Loan";
            case 3:  yield "Travel Loan";
            case 4:  yield "Medical Loan";
            case 5:  yield "Vehicle Loan";
            case 6:  yield "Wedding Loan";
            case 7:  yield "Business Loan";
            case 8:  yield "Consumer Loan";
            case 9:  yield "Personal Loan";
            case 10: yield "Education Loan";
            case 11: yield "Overdraft Loan";
            case 12: yield "Agriculture Loan";
            case 13: yield "Home Renovation Loan";
            case 14: yield "Loan Against Property";
            case 15: yield "Debt Consolidation Loan";    
        
            default: yield null;

        };
      
    }

    
    public String loanVaildation(){
        
        while(true){

            System.out.print("Enter Yes or No = ");

            String confrim = sc.nextLine();

            System.out.println(customer.line);

            if(confrim.equalsIgnoreCase("Yes")){
            
                return "Yes";

            }else if(confrim.equalsIgnoreCase("No")){

                return "No";

            }else{

                System.out.println("Invaild Input! Try again." + "\n" + customer.line);
                continue;
                
            }

        }

    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public customer getApplicant() {
        return applicant;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    @Override
    public String toString() {
      
        return String.format(

            "%-5s | %-16s | %-12.1f | %-24s | %-10s",
            applicationId,
            applicant.getName(),
            loanAmount,
            loanType,
            loanStatus

        );

    }

}

public class CollectionPractice {
    public static void main(String[] args){

        customer Customer = new customer();
        
        List<customer> clients = new ArrayList<>();
        clients.add(new customer("Kavi",25000,"9876543210"));
        clients.add(new customer("Arun",18000,"9123456789"));
        clients.add(new customer("Priya",45000,"8765432109"));
        clients.add(new customer("Rahul",12000,"9345678120"));

        Customer.setClients(clients);     
                
        Set<cardNumbers> cardNumbers = new HashSet<>();

        cardNumbers card1 = Customer.new cardNumbers(
            5831047296158304L,
            clients.get(0).getCustomerId()
        );

        cardNumbers card2 = Customer.new cardNumbers( 
            9274613058721946L,
            clients.get(1).getCustomerId()
        );

        cardNumbers card3 = Customer.new cardNumbers(
            4169382751046837L,
            clients.get(2).getCustomerId()
        );

        cardNumbers card4 = Customer.new cardNumbers(
            7502839461750291L,
            clients.get(3).getCustomerId()
        );

        cardNumbers[] cards = {
            card1,
            card2,
            card3,
            card4
        };

        for(cardNumbers card : cards){

            cardNumbers.add(card);
            
            for(customer client : clients){

                if(card.getCustomerId() == client.getCustomerId()){

                  client.setCardNumber(card.getCardNumber());

                }

            }
        }

        Map<Integer, customer> customers = new HashMap<>();
        
        for(customer client : clients){

            customers.put(client.getCustomerId(),client);

        }

        Customer.setCustomers(customers);

        Transaction Transaction1 = new Transaction();

        Transaction1.setTransaction(new String[][]{

            {"ATM Deposit",       "8500",  "2026-08-05"},
            {"ATM Withdrawal",    "4000",  "2026-08-12"},
            {"ATM Transfer",      "6750",  "2026-08-18"},
            {"UPI Deposit",       "1250",  "2026-08-08"},
            {"UPI Withdrawal",    "950",   "2026-09-02"},
            {"UPI Transfer",      "5500",  "2026-08-27"},
            {"Cash Deposit",      "12000", "2026-08-23"}

        }, clients.get(0));


        Transaction Transaction2 = new Transaction();

        Transaction2.setTransaction(new String[][]{

            {"ATM Deposit",       "7200",  "2026-07-15"},
            {"ATM Withdrawal",    "3500",  "2026-07-10"},
            {"ATM Transfer",      "5800",  "2026-07-21"},
            {"UPI Deposit",       "1450",  "2026-08-03"},
            {"UPI Withdrawal",    "2000",  "2026-09-01"},
            {"UPI Transfer",      "8000",  "2026-08-19"},
            {"Cash Deposit",      "9500",  "2026-08-11"}

        }, clients.get(1));


        Transaction Transaction3 = new Transaction();

        Transaction3.setTransaction(new String[][]{

            {"ATM Deposit",       "15000", "2026-06-14"},
            {"ATM Withdrawal",    "5500",  "2026-07-02"},
            {"ATM Transfer",      "8250",  "2026-07-18"},
            {"UPI Deposit",       "2300",  "2026-06-05"},
            {"UPI Withdrawal",    "1100",  "2026-09-05"},
            {"UPI Transfer",      "4600",  "2026-08-06"},
            {"Cash Deposit",      "6800",  "2026-08-22"}

        }, clients.get(2));


        Transaction Transaction4 = new Transaction();

        Transaction4.setTransaction(new String[][]{

            {"ATM Deposit",       "11500", "2026-07-07"},
            {"ATM Withdrawal",    "2800",  "2026-05-16"},
            {"ATM Transfer",      "3900",  "2026-06-20"},
            {"UPI Deposit",       "650",   "2026-06-03"},
            {"UPI Withdrawal",    "4200",  "2026-09-03"},
            {"UPI Transfer",      "7250",  "2026-08-14"},
            {"Cash Deposit",      "4750",  "2026-05-08"}

        }, clients.get(3));

        Queue<Loan> loans = new ArrayDeque<>();
        loans.add(new Loan(clients.get(0), 250000, "Home Loan", "Approved"));
        loans.add(new Loan(clients.get(1), 150000, "Personal Loan", "Pending"));
        loans.add(new Loan(clients.get(2), 500000, "Education Loan", "Approved"));
        loans.add(new Loan(clients.get(3), 300000, "Vehicle Loan", "Rejected"));
        
        int choice;
        boolean isRunning = false;

        Customer.setSc(new Scanner(System.in));
        Scanner sc = Customer.getSc();
        
        try(sc){
            while(!isRunning){
                try {
                    customer.welcome();
                    Customer.choice();

                    System.out.print("Enter the choice = ");
                    choice = sc.nextInt();  
                    System.out.println(customer.line);

                    switch (choice) {

                        case 1 -> {

                            Optional<customer> foundCustomer = Optional.ofNullable(Customer.searchId());

                            foundCustomer.ifPresentOrElse(client -> System.out.println("Customer Found Successfully."),() -> {});

                        }

                        case 2 -> {

                            System.out.printf(
                                "| %-6s | %-15s | %-10s |%n",
                                "ID",
                                "Customer Name",
                                "Number"
                            );

                            System.out.println(customer.line);

                            for(Map.Entry<Integer, customer> entry : customers.entrySet()){

                                System.out.printf(
                                    "| %-6d | %-15s | %-10s |%n",
                                    entry.getKey(),
                                    entry.getValue().getName(),
                                    entry.getValue().getNumber()
                                );

                            }

                            System.out.println(customer.line + "\n" + "List Generated Sucessfully.");

                        }

                        case 3 -> {     
                            
                            customer foundCustomer =  Customer.searchId();
                               
                            if(foundCustomer == null){

                                break;


                            }else{

                                if(Customer.accountVaildation().equalsIgnoreCase("Yes")){
                                    
                                    Customer.updateNumber(foundCustomer);
                                  
                                }

                            }

                            
                        }

                        case 4 -> {

                            customer foundCustomer =  Customer.searchId();
                               
                            if(foundCustomer == null){

                                break;


                            }else{

                                if(Customer.accountVaildation().equalsIgnoreCase("Yes")){

                                    System.out.println(Transaction.line);

                                    System.out.printf(
                                        "| %-5s | %-16s | %10s | %10s | %n",   
                                        "ID", "TYPE", "AMOUNT", "DATE"
                                    );

                                    System.out.println(Transaction.line);
                                    
                                    for(Transaction History : foundCustomer.getTransactions()){

                                        System.out.println(History);

                                    } 

                                    long depositCount =  foundCustomer.getTransactions().stream()
                                        .map(txt -> txt.getType())
                                        .filter(txt -> txt.endsWith("Deposit"))
                                        .count();

                                    long withdrawCount =  foundCustomer.getTransactions().stream()
                                        .map(txt -> txt.getType())
                                        .filter(txt -> txt.endsWith("Withdrawal"))
                                        .count();

                                    long transferCount =  foundCustomer.getTransactions().stream()
                                        .map(txt -> txt.getType())
                                        .filter(txt -> txt.endsWith("Transfer"))
                                        .count();

                                    double totalDeposit =  foundCustomer.getTransactions().stream()
                                        .filter(txt -> txt.getType().endsWith("Deposit"))
                                        .map(txt -> txt.getAmount())
                                        .reduce(0.0,(c,e) -> c+e);

                                    double totalWithdraw =  foundCustomer.getTransactions().stream()
                                        .filter(txt -> txt.getType().endsWith("Withdrawal"))
                                        .map(txt -> txt.getAmount())
                                        .reduce(0.0,(c,e) -> c+e);
                                        
                                    double totalTransfer =  foundCustomer.getTransactions().stream()
                                        .filter(txt -> txt.getType().endsWith("Transfer"))
                                        .map(txt -> txt.getAmount())
                                        .reduce(0.0,(c,e) -> c+e);

                                    System.out.println(Transaction.line); 

                                    System.out.println("Deposit  : " + depositCount  + " || Total Deposit  Amount = " + totalDeposit );
                                    System.out.println("Withdraw : " + withdrawCount + " || Total Withdraw Amount = " + totalWithdraw );
                                    System.out.println("Transfer : " + transferCount + " || Total Transfer Amount = " + totalTransfer );
                                    System.out.println(Transaction.line + "\n" + "Total Transactions =  " + foundCustomer.getTransactions().size());

                                }

                            }   

                        }

                        case 5 -> {
                            
                            clients.forEach(client -> System.out.println(client));
                            System.out.println("Total Customers = " + clients.size());                            
                            System.out.println("List Generated."); 

                        }

                        case 6 -> {
                            
                            customer foundCustomer =  Customer.searchId();

                            Iterator<customer> i = clients.iterator();

                            while (i.hasNext()) {
                               
                                if(foundCustomer == null){

                                    break;

                                }else{

                                    customer client = i.next();

                                    if(client == foundCustomer){

                                        if(Customer.accountVaildation().equalsIgnoreCase("Yes")){

                                            i.remove();
                                            System.out.println("Customer Removed Successfully.");

                                        }

                                        break;

                                    }

                                }

                            }
                            
                        }

                        case 7 ->{

                            Loan loanProcessing = new Loan();

                            boolean isLoanProcessing = false;
                            loanProcessing.setSc(sc);

                            System.out.println("Loan Applications");

                            while(!isLoanProcessing){
                                
                                loanProcessing.display();
                                System.out.print("Enter the choice = ");
                                
                                int loanChoice = sc.nextInt();
                                sc.nextLine();

                                System.out.println(customer.line);

                                switch (loanChoice) {

                                    case 1 -> {

                                       loanProcessing.displayFormat();

                                       loans.forEach(loan -> System.out.println(loan));
                    
                                       System.out.println(Loan.line);
                                       System.out.println("List Generated.");
                                       System.out.println("Total Applications = " + loans.size());

                                    }

                                    case 2 -> {

                                        loanProcessing.displayFormat();

                                        long pendingCount = loans.stream()
                                            .filter(loan -> loan.getLoanStatus().equals("Pending"))
                                            .peek(loan -> System.out.println(loan))
                                            .count();
            
                                        System.out.println(Loan.line);
                                        System.out.println("Total Pending Applications = " + pendingCount);
                                      
                                    }
                                        
                                    case 3 ->{

                                        Loan applicant = loans.peek();
                                        System.out.println(Loan.line + "\n" + applicant + "\n" + Loan.line);
                                        System.out.println(applicant.getApplicant());

                                    }

                                    case 4 ->{

                                        Loan loan = loans.peek();

                                        if (loan == null) {
                                            System.out.println("No loan applications available.");
                                            break;
                                        }

                                        if(loan.getLoanStatus().equalsIgnoreCase("Pending")){

                                            
                                            System.out.println(Loan.line + "\n" + loan + "\n" + Loan.line);
                                            System.out.println("Confrimation for processing");

                                            String validation = loanProcessing.loanVaildation();

                                            if(validation.equals("Yes")){

                                                loan.setLoanStatus("Approved");
                                                
                                                System.out.println(Loan.line + "\n" + loan + "\n" + Loan.line);
                                                System.out.println("Loan Application Processed.");

                                            }else if(validation.equals("No")){

                                                System.out.println("Loan does not Processed.");

                                            }

                                        }else if (loan.getLoanStatus().equalsIgnoreCase("Approved") || loan.getLoanStatus().equalsIgnoreCase("Rejected")) {

                                            System.out.println(Loan.line + "\n" + loan + "\n" + Loan.line);
                                            System.out.println(loan.getApplicant());
                                            System.out.println("This application is not pending.");    
                                            System.out.println("So Application is Removed from  list.");
                                            loans.poll();

                                        }

                                    }

                                    case 5 ->{

                                        System.out.println("Enter the Application Details");

                                        customer foundCustomer = Customer.searchId();

                                        System.out.print("Loan Amount : ");
                                        int amount = sc.nextInt();
                                        sc.nextLine();

                                        System.out.println(customer.line + "\n" + "Select Loan Type ");
                                        loanProcessing.listLoanTypes();
                                        
                                        System.out.print("Enter the Option : ");
                                        int option = sc.nextInt();
                                        sc.nextLine(); 

                                        String type = loanProcessing.selectLoanType(option);
                                        
                                        if(type == null){
                                            System.out.println("Invalid Loan Type.");
                                            continue;
                                        }else{
                                            System.out.println(customer.line + "\n" + "Application Applied Successfully.");
                                        }

                                        Loan newLoan = new Loan(foundCustomer, amount, type, "Pending");
                                        loans.offer(newLoan);

                                    }

                                    case 6 ->{

                                        System.out.println("Redirecting To Main Menu");
                                        isLoanProcessing = true;

                                    }

                                    case 7 ->{

                                        System.out.println("Thank you." + "\n" + customer.line);
                                        isLoanProcessing = true;
                                        isRunning = true;

                                    }
                                
                                    default -> System.out.println("Invaild Input try again.");
                                    
                                }

                            }

                        }

                        case 8 -> {

                            customer foundCustomer =  Customer.searchId();    
                                
                            if(foundCustomer == null){

                                break;

                            }else{

                                if(Customer.accountVaildation().equalsIgnoreCase("Yes")){
                                    
                                    Customer.deposit(foundCustomer);
                                    System.out.println("Deposited Successfully.");

                                }

                            }   

                        }


                        case 9 ->{

                            List<String> auditReports = clients.parallelStream()
                            .map(client -> {

                                int totalTransactions = client.getTransactions().size();

                                double totalDeposit = client.getTransactions().stream()
                                    .filter(txt -> txt.getType().endsWith("Deposit"))
                                    .mapToDouble(txt -> txt.getAmount())
                                    .sum();

                                double totalWithdraw = client.getTransactions().stream()
                                    .filter(txt -> txt.getType().endsWith("Withdrawal"))
                                    .mapToDouble(txt -> txt.getAmount())
                                    .sum();

                                double totalTransfer = client.getTransactions().stream()
                                    .filter(txt -> txt.getType().endsWith("Transfer"))
                                    .mapToDouble(txt -> txt.getAmount())
                                    .sum();

                                return "Customer: " + client.getName() + "\n"
                                    + "Total Transactions : " + totalTransactions + "\n"
                                    + "Total Deposit      : " + totalDeposit + "\n"
                                    +   "Total Withdraw     : " + totalWithdraw + "\n"
                                    + "Total Transfer     : " + totalTransfer + "\n"
                                    + customer.line + "\n";

                            })
                            .toList();

                            auditReports.forEach(System.out::print);
                        }

                        case 10 -> {

                            boolean isSorting = false;

                            while (!isSorting) {
                                
                                Customer.subdisplay();
                                System.out.print("Enter the choice = ");
                                
                                int sortingChoice = sc.nextInt();
                                sc.nextLine();

                                System.out.println(customer.line);

                                switch (sortingChoice) {

                                    case 1 -> {

                                        List<customer> sortedClients = new ArrayList<>(clients);

                                        Comparator<customer> compare = new Comparator<customer>() {

                                            public int compare(customer customer1 ,customer customer2){

                                                if(customer1.getCustomerId() > customer2.getCustomerId()){
                                                    return 1;
                                                }else if(customer1.getCustomerId() ==  customer2.getCustomerId()){
                                                    return 0;
                                                }else{
                                                    return -1;
                                                }
                                                                
                                            }
                                            
                                        };

                                        Collections.sort(sortedClients,compare);

                                        for(customer client : sortedClients){
                                            System.out.println((client));
                                        }

                                        System.out.println("Customers Sorted by Customer ID.");
                                    }

                                    case 2 -> {

                                        List<customer> sortedClients = new ArrayList<>(clients);
                            
                                        Collections.sort(sortedClients);

                                        for (customer client : sortedClients) {
                                            System.out.println(client);
                                        }

                                        System.out.println("Customers Sorted by Name.");
                                    }

                                    case 3 -> {

                                        customer foundCustomer =  Customer.searchId();
                               
                                        if(foundCustomer == null){

                                            break;


                                        }else{

                                            if(Customer.accountVaildation().equalsIgnoreCase("Yes")){

                                                List<Transaction> sortedTransactions = new ArrayList<>(foundCustomer.getTransactions());

                                                Comparator<Transaction> compare = (txt1 ,txt2) -> txt1.getTransactionId().compareTo(txt2.getTransactionId());

                                                Collections.sort(sortedTransactions,compare);

                                                System.out.println(Transaction.line);

                                                System.out.printf(
                                                    "| %-5s | %-16s | %10s | %10s | %n",   
                                                    "ID", "TYPE", "AMOUNT", "DATE"
                                                );

                                                System.out.println(Transaction.line);
                                                
                                                for(Transaction History :sortedTransactions){

                                                    System.out.println(History);

                                                } 

                                                System.out.println(Transaction.line + "\n" +"Total Transactions =  " + sortedTransactions.size());
                                            
                                            }

                                        }  

                                    }
                                        
                                    
                                    case 4 ->{

                                        customer foundCustomer =  Customer.searchId();
                               
                                        if(foundCustomer == null){

                                            break;


                                        }else{

                                            if(Customer.accountVaildation().equalsIgnoreCase("Yes")){

                                                List<Transaction> sortedTransactions = new ArrayList<>(foundCustomer.getTransactions());

                                                Comparator<Transaction> compare = (txt1 ,txt2) -> Double.compare(txt1.getAmount(), txt2.getAmount());

                                                Collections.sort(sortedTransactions,compare);

                                                System.out.println(Transaction.line);

                                                System.out.printf(
                                                    "| %-5s | %-16s | %10s | %10s | %n",   
                                                    "ID", "TYPE", "AMOUNT", "DATE"
                                                );

                                                System.out.println(Transaction.line);
                                                
                                                for(Transaction History :sortedTransactions){

                                                    System.out.println(History);

                                                } 

                                                System.out.println(Transaction.line + "\n" +"Total Transactions =  " + sortedTransactions.size());
                                            
                                            }

                                        }  

                                    }
                                        
                                    
                                    case 5 ->{

                                        System.out.println("Redirecting To Main Menu");
                                        isSorting= true;

                                    }

                                    case 6 ->{

                                        System.out.println("Thank you." + "\n" + customer.line);
                                        isSorting = true;
                                        isRunning = true;

                                    }
                                                    
                                    default -> System.out.println("Invalid Input.");
    
                                }
                            }

                        }

                        case 11->{
                            System.out.println("Thank you." + "\n" + customer.line);
                            isRunning = true;
                        }

                        default -> System.out.println("Invaild Input");

                    }
                }catch (InputMismatchException e){

                    System.out.println("Invalid Input. Please enter a number.");
                    sc.nextLine();
                    continue;

                }
            }
        }
        catch(NoSuchElementException e){
            System.out.println("\n" + "Session Terminated." + "\n" + customer.line);
        }
        catch(Exception e){
            System.out.println("Something Went Wrong!" + " | " + e );
        }
        
    
    } 
}
  
