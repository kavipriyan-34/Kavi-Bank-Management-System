package account;

//Enum has class
public enum AccountType {

    SAVINGS("Savings",1000),
    SALARY("Salary",0),
    CURRENT("Current",10000),
    PREMIUMSAVINGS("Premium Savings",10000);

    private String accountTypeName;
    private double minimumBalance;

    AccountType(String accountTypeName, double minimumBalance){
        this.accountTypeName = accountTypeName;
        this.minimumBalance = minimumBalance;
    }

    public String  getAccountTypeName(){
        return accountTypeName;
    }

    public double getMinmumBalance(){
        return minimumBalance;
    }

}
