package account;

// interface for single implementation
public interface AccountSecurity {

    void lockAccount();
    void verifyIdentity();
    void changePin(int oldPin,int newPin,int confirmPin);
    
}
