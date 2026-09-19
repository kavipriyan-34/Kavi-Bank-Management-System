package ATM;

//Custom Exception
class InvalidAmountException extends Exception{
    
    public InvalidAmountException(){

    }

    public InvalidAmountException(String message){
    super(message);
    }
}
