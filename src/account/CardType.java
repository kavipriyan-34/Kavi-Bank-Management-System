package account;

public enum CardType {
    
    DEBIT("Debit Card", 100000.0, 500.0),
    PREMIUMDEBIT("Premium Debit card ",1000000.0,5000.0),
    CREDIT("Credit Card", 20000.0, 1000.0),
    PREMIUMCREDIT("Premium Credit Card",2000000.0,10000.0),
    PREPAID("Prepaid Card", 50000.0, 250.0);

    private String cardName;
    private double transactionLimit;
    private double annualFee;


    CardType(String cardName,double transactionLimit,double annualFee){
       this.cardName = cardName;
       this.transactionLimit = transactionLimit;
       this.annualFee = annualFee;
    }


    public String getCardName() {
        return cardName;
    }

    public double getTransactionLimit() {
        return transactionLimit;
    }

    public double getAnnualFee() {
        return annualFee;
    }
}
