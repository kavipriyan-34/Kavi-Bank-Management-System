package customer;
import person.Person;
import java.util.*;
import account.AccountSecurity;
import account.AccountBenefits;
import account.AccountContactUpdater;
import account.AccountStatus;
import account.CardType;
import account.PenaltyCalculator;
import account.AccountType;

public class Customer extends Person implements AccountSecurity, AccountBenefits,PenaltyCalculator{
      
  //Instance variables
  private String branchName;
  private String nomineeName;
  private String kycVerified;
  private String relationship;
  private String proofDocument;

  private int interest;
  private int currentPin;
  private int rewardPoints;
  private int branchPincode;
  private double minimumBalancePenalty;

  //construtor 
  private final int customerId;
      
  //Encapsulation 
  private double balance;
  private long accountNumber;
  
  // private String customerName;
      
  //Instance variable for String Builder
  // String email;
  // String address;
  // String phoneNumber;

  //Enum
  private AccountType accountType;
  private AccountStatus accountStatus;

  //Instance variables using Array
    
  private double[] monthlyDeposits;
  private double[][] monthlyTransactions;
      
  protected static String[] months = {
  "January   : ",
  "February  : ",
  "March     : ",
  "April     : ",
  "May       : ",
  "June      : ",
  "July      : ",
  "August    : ",
  "September : ",
  "October   : ",
  "November  : ",
  "December  : "
  };

  //Static variables
  protected static final String bankBranch = "Kavi Bank ";
  protected static String midLine = "-----------------------------------------";
  protected static String endLine = "**********************************************************";

  //Static block
  static {  
  System.out.println("Loading Bank Customer Management System...");
  }

  //Helper Method for default customer constructor 
  private int generateCustomerId(){
  Random random = new Random();
  return random.nextInt(900000) + 100000;
  }

  //constructor
  public Customer(){
    customerId = generateCustomerId();
  }

  public Customer(String customerName ,String phoneNumber,String email,String address,long accountNumber,double balance,int currentPin){
    super(customerName,phoneNumber,email,address);
    customerId =  generateCustomerId(); 
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.currentPin = currentPin;
  } 

  public Customer(String customerName ,String phoneNumber,String email,String address,long accountNumber,double balance
  ,String branchName,int branchPincode,AccountType accountType,String nomineeName,String relationship,
  String kycVerified,String proofDocument){
    super(customerName,phoneNumber,email,address);
    customerId =  generateCustomerId(); 
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.branchName = branchName;
    this.branchPincode = branchPincode;
    this.accountType = accountType;
    this.nomineeName = nomineeName;
    this.relationship = relationship;
    this.kycVerified = kycVerified;
    this.proofDocument = proofDocument;
  } 

  // Static Method
  public static void welcome(){
    System.out.println(endLine);
    System.out.println(" Welcome to " + bankBranch);
    System.out.println(endLine);
  }

  //Instance Method
  public void customerDetail(){
    System.out.println("Customer Account Detail \n" + endLine);
    System.out.println(
    "Customer Name   : " + getName() + "\n" +
    "Customer ID     : " + customerId + "\n" +
    "Account Number  : " + accountNumber + "\n" +
    "Account Balance : " + balance + "\n\n" +
    "Branch Name     : " + branchName + "\n" +
    "Branch PIN Code : " + branchPincode + "\n\n" +
    "Account Type    : " + accountType.getAccountTypeName() + "\n" +
    "Minimum Balance : " + accountType.getMinmumBalance()+ "\n\n" +
    "Nominee Name    : " + nomineeName + "\n" +
    "Relationship    : " + relationship + "\n\n" +
    "KYC Status      : " + kycVerified + "\n" +
    "Proof Document  : " + proofDocument + "\n" +
    endLine
    );
  }

  //Instance Method Using String Builder
  public void customerContactReport(){
    StringBuilder sb = new StringBuilder();

    sb.append("CUSTOMER CONTACT REPORT \n")
      .append(endLine)
      .append("\n");

    sb.append("Customer Name        : ")
      .append(getName())
      .append("\n");

    sb.append("Phone Number         : ")
      .append(getPhoneNumber())
      .append("\n");
    
    sb.append("Email                : ")
      .append(getEmail())
      .append("\n");

    sb.append("Address              : ")
      .append(getAddress())
      .append("\n");

    sb.append("Account Status       : ")
      .append(getAccountStatus());

    System.out.println(sb.toString());
    System.out.println(endLine);
  } 

  public void  displayMonthlyDeposits(){
  System.out.println("Customer Monthly Deposit Report \n"+ "Customer Name : " + getName() + "\n" + endLine);
    for(int i=0;i<monthlyDeposits.length;i++){
      System.out.println(months[i] + monthlyDeposits[i]);
    }

  System.out.println(endLine);
  }

  // // Example of array using as parameter in a method
  // public void  displayMonthlyDeposits(double[] deposits){
  // System.out.println("Customer Monthly Deposit Report \n"+ "Customer Name : " + customerName + "\n" + longLine);
  //   for(int i=0;i<deposits.length;i++){
  //     System.out.println(months[i] + deposits[i]);
  //   }

  // System.out.println(longLine);
  // }

  // // Example of array using return type method
  // public double[] getMonthlyDeposits() {
  // return monthlyDeposits;
  // }

  public void displayMonthlyTransactions(){

    String[] transactionLabels = new String[]{
    "Deposit    : ",
    "Withdrawal : ",
    "Interest   : " 
    };

    for(int i=0;i<monthlyTransactions.length;i++){
      System.out.println(months[i] + "Transactions Report \n" + midLine) ;

      for(int j=0;j<monthlyTransactions[i].length;j++){
      System.out.println( transactionLabels[j] + monthlyTransactions[i][j]);
      }

      if(i < monthlyTransactions.length -1){
      System.out.println(midLine);
      }else{
      System.out.println(endLine);
      }
      
    }
  }

  //Abstract Class Method
  @Override
  public void displayPersonInfo(){
  System.out.println
  ("Name         : " + getName() + "\n" + 
    "Phone Number : " + getPhoneNumber() + "\n" +
    "Email        : " + getEmail() + "\n"+
    "Address      : " + getAddress());
  }

  //setters
  // public void setCustomerName(String customerName){
  //   this.customerName = customerName;
  // }

  
  public void setAccountStatus(AccountStatus accountStatus){
  this.accountStatus = accountStatus;
  }

  public void  setAccountNumber(long accountNumber){
    this.accountNumber = accountNumber;
  }

  public void setBalance(double balance) {
    if (balance >= 0) {
        this.balance = balance;
    } else {
        System.out.println("Invalid Balance");
    }
  }    

  public void setMonthlyDeposits(double[] monthlyDeposits){
  this.monthlyDeposits = monthlyDeposits;
  }

  public void setMonthlyTransactions(double[][] monthlyTransactions){
  this.monthlyTransactions = monthlyTransactions;
  }

  //getters
  // public String getCustomerName(){
  // return customerName;
  // }

  public double getBalance(){
    return balance;
  }

  public long getAccountNumber(){
    return accountNumber;
  }

  public AccountStatus getAccountStatus(){
    return accountStatus;
  }

  public int getCurrentPin(){
    return currentPin;
  }

  public AccountType getAccountType(){
    return accountType;
  }

  public double[] getMonthlyDeposits() {
    return monthlyDeposits;
  }

  public double[][] getMonthlyTransactions() {
    return monthlyTransactions;
  }


  //Method using parameter
  public void updateBranch(String newBranchName){
  branchName = newBranchName;
  }

  public void updateAccountType(AccountType newAccountType){
  accountType = newAccountType;
  }

  
  public void updateNominee(String newNomineeName){
  nomineeName = newNomineeName;
  }

  public void updateKYCStatus(String newStatus){
  kycVerified = newStatus; 
  }

  //Method overloading
  public void updateBranch(String newBranchName ,int newBranchPincode){
  branchName = newBranchName;
  branchPincode = newBranchPincode;
  }

  // public void updateAccountType(String newAccountType, double newMinimumBalance){
  // accountType = newAccountType;
  // minimumBalance = newMinimumBalance;
  // }

  public void updateNominee(String newNomineeName , String newRelationship){
  nomineeName = newNomineeName;
  relationship = newRelationship;
  }

  public void updateKYCStatus(String newStatus , String newProofDocument){
  kycVerified = newStatus; 
  proofDocument = newProofDocument;
  }       

  //non-static inner class
  public class BankCard{
  
    private CardType cardType;
    private String lastFourDigits;
    private int expiryYear;
    private String cardStatus;

    public BankCard(CardType cardType, String lastFourDigits, int expiryYear, String cardStatus){
      this.cardType = cardType;
      this.lastFourDigits = lastFourDigits;
      this.expiryYear = expiryYear;
      this.cardStatus = cardStatus;
    }

    public void displayCardDetails() {

      System.out.println("BANK CARD DETAILS");
      System.out.println(endLine);

      System.out.println("Card Type       : " + cardType.getCardName());
      System.out.println("Last 4 Digits   : " + lastFourDigits);
      System.out.println("Expiry Year     : " + expiryYear);
      System.out.println("Card Status     : " + cardStatus);

      System.out.println(endLine);
    }
  }

  //Static Inner Class
  public static class Locker {

    private int lockerNumber;
    private String lockerType;
    private double annualFee;
    private String status;

    public Locker(int lockerNumber, String lockerType, double annualFee, String status) {
      this.lockerNumber = lockerNumber;
      this.lockerType = lockerType;
      this.annualFee = annualFee;
      this.status = status;
    }

    public void displayLockerDetails() {

      System.out.println("BANK LOCKER DETAILS");
      System.out.println(endLine);

      System.out.println("Locker Number : " + lockerNumber);
      System.out.println("Locker Type   : " + lockerType);
      System.out.println("Annual Fee    : " + annualFee);
      System.out.println("Status        : " + status);

      System.out.println(endLine);
    }
  }

  //Anonymous Inner Class
  public void validateAccount() {
  System.out.println("Account validation Completed.");
  }

  //Interface abstract methods for single class implementation
  @Override
  public void verifyIdentity(){

    if (!"Verified".equals(kycVerified)) {
      System.out.println("Identity verification failed: KYC is not verified.");
      System.out.println(endLine);
      return;
    }
    if (proofDocument == null || proofDocument.isBlank()) {
      System.out.println("Identity verification failed: Proof document is missing.");
      System.out.println(endLine);
      return;
    }
    
    System.out.println("Identity verification successful.");
    System.out.println(endLine);
  }

  @Override
  public void changePin(int oldPin,int newPin,int confirmPin){

    if(oldPin != currentPin){
      System.out.println("Incorrect current PIN.");
      System.out.println(endLine);
      return;
    }
    if(newPin < 1000 || newPin > 9999){
      System.out.println("New PIN must contain exactly 4 digits.");
      System.out.println(endLine);
      return;
    }
    if (newPin == currentPin) {
      System.out.println("New PIN must be different from old PIN.");
      System.out.println(endLine);
      return;
    }
    if(newPin != confirmPin){
      System.out.println("New PIN and confirmation PIN do not match.");
      System.out.println(endLine);
      return;
    }

    currentPin = newPin;
    System.out.println("PIN changed successfully.");
    System.out.println(endLine);
  }

  @Override
    public void lockAccount(){
    if(AccountStatus.BLOCKED.equals(accountStatus)){
      System.out.println("Your account Already Locked");
      System.out.println(endLine);
      return;
    }

    accountStatus = AccountStatus.BLOCKED;
    System.out.println("Account locked successfully.");
    System.out.println(endLine);
  }

  //Interface abstract methods for multiplee class implementation
  @Override
  public void calculateInterest(){

  System.out.println("Interest Rate");
  System.out.println(endLine);

  interest = (int) balance * 5 / 100;
  System.out.println("Balance         : " + balance );
  System.out.println("Interest rate   : 5%");
  System.out.println("Interest        : " + interest);
  System.out.println(endLine);
  }

  @Override
  public void calculateRewards(){

  System.out.println("Reward Points");
  System.out.println(endLine);

  rewardPoints = (int) balance / 100;
  System.out.println("Reward Points : " + rewardPoints);
  System.out.println(endLine);
  }

  @Override
  public void checkBenefits(){

    System.out.println("Account Benefits");
    System.out.println(endLine);

    if (AccountType.SAVINGS.equals(accountType)) {
      System.out.println("Savings Account Benefits");
      System.out.println("Standard Interest");
      System.out.println("Standard Banking Services");
      System.out.println(endLine);
    }
    else if (AccountType.SALARY.equals(accountType)) {
      System.out.println("Salary Account Benefits");
      System.out.println("Zero Minimum Balance");
      System.out.println("Standard Banking Services");
      System.out.println(endLine);
    }
    else if (AccountType.CURRENT.equals(accountType)) {
      System.out.println("Current Account Benefits");
      System.out.println("Business Banking Services");
      System.out.println(endLine);
    }
    else {
      System.out.println("No specific benefits available.");
      System.out.println(endLine);
    }
  }

  //Functional Interface -> means it contains only one method 
  @Override
  public void minimumBalancePenaltyCalculator(){
    switch(accountType){

      case SAVINGS -> {

        if(getBalance() < accountType.getMinmumBalance()){

          minimumBalancePenalty = 300;
          System.out.println("Minimum Balance Penatly Amount : " + minimumBalancePenalty);
          System.out.println("Please Maintan The Minmum Balance.");
          System.out.println(endLine);
          
        }else {

          System.out.println("No Minimum Balance Penalty.");
          System.out.println("Your balance satisfies the minimum balance requirement.");
          System.out.println(endLine);
          
        }
      }

      case SALARY -> {

        System.out.println("Salary Account");
        System.out.println("No Minimum Balance Requirement.");
        System.out.println(endLine);

      }

      case CURRENT -> {

        if(getBalance() < accountType.getMinmumBalance()){

          minimumBalancePenalty = 5000;
          System.out.println("Minimum Balance Penatly Amount : " + minimumBalancePenalty);
          System.out.println("Please Maintan The Minmum Balance.");
          System.out.println(endLine);

        }else {

          System.out.println("No Minimum Balance Penalty.");
          System.out.println("Your balance satisfies the minimum balance requirement.");
          System.out.println(endLine);
        
        }
      }

      default -> {
        System.out.println("Zero Pentaly");
        System.out.println(endLine);
      }
    }
  }

  // //Functinal Interface using Lambda expression 
  // public void contactUpdater(String newPhoneNumber,String newEmail){

  //   if (!newPhoneNumber.matches("[6-9][0-9]{9}")) {
  //     System.out.println("Invalid phone number.");
  //     return;
  //   }
    
  //   if (newEmail == null || newEmail.isBlank()){
  //     System.out.println("Email cannot be empty.");
  //     return;
  //   }

  //   if (!newEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
  //     System.out.println("Invalid email address.");
  //     return;
  //   }

  //   if (newPhoneNumber.equals(getPhoneNumber())){
  //     System.out.println( "New phone number is the same as the current phone number." );
  //     return;
  //   }

  //   if (newEmail.equalsIgnoreCase(getEmail())){
  //     System.out.println("New email is the same as the current email.");
  //     return;
  //   }

  //   setPhoneNumber(newPhoneNumber);
  //   setEmail(newEmail);

  //   System.out.println("Phone number updated successfully.");
  //   System.out.println("Email updated successfully.");
  //   System.out.println(endLine);

  // 
      
  //Functional interface using lambda expression
  private AccountContactUpdater contactUpdater = (newPhoneNumber, newEmail) -> {
    
    if (!newPhoneNumber.matches("[6-9][0-9]{9}")) {
      System.out.println("Invalid phone number.");
      return;
    }
    
    if (newEmail == null || newEmail.isBlank()){
      System.out.println("Email cannot be empty.");
      return;
    }

    if (!newEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
      System.out.println("Invalid email address.");
      return;
    }

    if (newPhoneNumber.equals(getPhoneNumber())){
      System.out.println( "New phone number is the same as the current phone number." );
      return;
    }

    if (newEmail.equalsIgnoreCase(getEmail())){
      System.out.println("New email is the same as the current email.");
      return;
    }

    setPhoneNumber(newPhoneNumber);
    setEmail(newEmail);

    System.out.println("Phone number updated successfully.");
    System.out.println("Email updated successfully.");
    System.out.println(endLine);
    };

  public AccountContactUpdater getContactUpdater() {
    return contactUpdater;
  }    
 
}
