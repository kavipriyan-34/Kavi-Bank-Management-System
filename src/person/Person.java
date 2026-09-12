package person;

public abstract class Person {
  private String name;
  private String phoneNumber;
  private String email;
  private String address;

  public Person(){
      
  }

  public Person(String name,String phoneNumber,String email,String address){
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address; 
  }
  
  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  public void setEmail(String email){
    this.email = email;
  }
  
  public String  getName(){
    return name;
  }
  
  public String getPhoneNumber(){
    return phoneNumber;
  }

  public String getEmail(){
    return email;
  }

  public String getAddress(){
    return address;
  }
  
  public abstract void displayPersonInfo();
}
