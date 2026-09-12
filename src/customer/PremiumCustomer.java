package customer;

import account.CardType;
import account.AccountType;

public class PremiumCustomer extends Customer{
  
private int rewardPoints;

private int interest;

private CardType cardType;

private final String relationshipManager;

private final boolean priorityBanking;

private double cashbackPercentage;

private boolean airportLoungeAccess;

private String membershipLevel;

private String supportEmail;

private String premiumHelpline;

protected Double balanceObject;

private Boolean priorityBankingObject;

protected Long accountNumberObject;

private double  premiumMinimumBalancePenalty;

public PremiumCustomer(String customerName ,String phoneNumber,String email,String address,long accountNumber,double balance,
    String branchName,int branchPincode,AccountType accountType,String nomineeName,String relationship,String kycVerified,
    String proofDocument,  int rewardPoints,CardType cardType,String relationshipManager,boolean priorityBanking,double cashbackPercentage
    ,boolean airportLoungeAccess,String membershipLevel){
    super(customerName,phoneNumber,email,address,accountNumber,balance,branchName,branchPincode
    ,accountType,nomineeName,relationship,kycVerified,proofDocument);
    this.rewardPoints = rewardPoints;
    this.cardType = cardType;
    this.relationshipManager = relationshipManager;
    this.priorityBanking = priorityBanking;
    this.cashbackPercentage = cashbackPercentage;
    this.airportLoungeAccess = airportLoungeAccess;
    this.membershipLevel = membershipLevel;
}

public void premiumCustomerReport(){
    System.out.println("PREMIUM CUSTOMER REPORT");
    System.out.println(endLine);
    System.out.println
    ("Reward Points         : " + rewardPoints + "\n" +
     "Card Limit            : " + cardType.getTransactionLimit() + "\n" +
     "RelationShip Manager  : " + relationshipManager + "\n" +
     "Priority Banking      : " + priorityBanking + "\n" +
     "Cashback Percentage   : " + cashbackPercentage + "\n" +
     "Airport Lounge Access : " + airportLoungeAccess +  "\n" +
     "MemberShip Level      : " + membershipLevel + "\n" + endLine           
    );
}

@Override
public void customerContactReport(){
          super.customerContactReport();
          
          StringBuilder sb = new StringBuilder();

          sb.append("PREMIUM BANKING CONTACT")
            .append("\n")
            .append(endLine)
            .append("\n");
    
          sb.append("Relationship Manager : ")
            .append(relationshipManager)
            .append("\n");

          sb.append("Manager Email        : ")
            .append(supportEmail)
            .append("\n");  

          sb.append("Manager Phone        : ")
            .append(premiumHelpline)
            .append("\n");

          sb.append(endLine);
          System.out.println(sb.toString());
} 


public void setManagerContactInfo(String premiumHelpline, String supportEmail){
this.premiumHelpline = premiumHelpline;
this.supportEmail = supportEmail;
}

public String getPremiumHelpline(){
    return premiumHelpline;
}

public String getSupportEmail(){
    return supportEmail;
}

//Wrapper Class 
public void convertToObject(){
  balanceObject = getBalance();
  priorityBankingObject = priorityBanking;
  accountNumberObject= getAccountNumber();
}

public Double getBalanceObject(){
  return balanceObject;
}

public Boolean getPriorityBoolean(){
  return priorityBankingObject;
}

public Long getAccountNumberObject(){
  return accountNumberObject;
}

// public void convertToPrimitive() {

//     double balance = balanceObject;
//     boolean priorityBanking = priorityBankingObject;
//     long accountNumber = accountNumberObject;

//     System.out.println("Primitive Balance         : " + balance);
//     System.out.println("Primitive Priority Banking: " + priorityBanking);
//     System.out.println("Primitive Account Number  : " + accountNumber);
// }

//Interface abstract methods for multiple class implementation
@Override
public void calculateInterest(){

System.out.println("Premium Interest Rate");
System.out.println(endLine);

interest = (int) getBalance() * 8 / 100;
System.out.println("Balance                  : " + getBalance() );
System.out.println("Premium interest rate    : 8%");
System.out.println("Interest                 : " + interest);
System.out.println(endLine);
}

@Override
public void calculateRewards(){

System.out.println("Premium Reward Points");
System.out.println(endLine);

rewardPoints = (int) getBalance() / 40;
System.out.println("Rewards Points : " + rewardPoints);
System.out.println(endLine);
}

@Override
public void checkBenefits() {

System.out.println("PREMIUM ACCOUNT BENEFITS");
System.out.println(endLine);

System.out.println("Membership Level : " + membershipLevel);
System.out.println("Cashback         : " + cashbackPercentage + "%");
System.out.println("Priority Banking : " + priorityBanking);
System.out.println("Airport Lounge   : " + airportLoungeAccess);
System.out.println(endLine);
}

//Functional Interface
@Override
public void minimumBalancePenaltyCalculator(){
  switch(getAccountType()){

    case PREMIUMSAVINGS -> {

      if(getBalance() < getAccountType().getMinmumBalance()){

        premiumMinimumBalancePenalty = 8000;
        System.out.println("Minimum Balance Penatly Amount : " + premiumMinimumBalancePenalty);
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



public static void main(String[] args) {
   PremiumCustomer premiumClient1 = new PremiumCustomer(
    "Kevin",
    "9876543210",
    "kevin@gmail.com",
    "Chennai",
    989824214,
    100000,

    "Chennai",
    600119,
    AccountType.PREMIUMSAVINGS,
    "Mark",
    "Father",
    "Verified",
    "Aadhar and PAN Card",

    2500,
    CardType.PREMIUMCREDIT,
    "David",
    true,
    5.0,
    true,
    "Platinum"
);

Customer.welcome();
premiumClient1.customerDetail();
premiumClient1.setManagerContactInfo("9876243392", "david@kavibank.com");
premiumClient1.customerContactReport();
premiumClient1.premiumCustomerReport();

// premiumClient1.convertToObject();
// // System.out.println("Object value : " + premiumClient1.getBalanceObject());
// premiumClient1.convertToPrimitive();

}
}
