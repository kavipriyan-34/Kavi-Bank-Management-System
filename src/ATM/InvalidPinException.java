package ATM;

//Custom Exception
class InvalidPinException extends Exception{
    public InvalidPinException(){

    }

    public InvalidPinException(String message){
    super(message);
    }
}

