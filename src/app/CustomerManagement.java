  package app;

  import account.AccountSecurity;

  import java.util.ArrayList;
  import java.util.List;

  import account.AccountBenefits;
  import account.AccountContactUpdater;
  import account.AccountStatus;
  import account.AccountType;
  import customer.Customer;
  import customer.PremiumCustomer;
  import account.CardType;
  import account.PenaltyCalculator;

  public class CustomerManagement{

    private static Customer[] customers;
    private static Customer.BankCard[] bankCards;
    private static Customer.Locker[] lockers;
    private static AccountSecurity[] security;
    private static AccountBenefits[] benefits; 
    private static PenaltyCalculator[] penalty;
    private static AccountContactUpdater[] contactUpdaters;

        private static void initializeCustomers(){

          //Object creation using Collection
          List <Customer> clients = new ArrayList<>();

          clients.add(new Customer(
            "Kevin",
            "9876543210",
            "kevin@gmail.com",
            "Chennai",
            989824214,
            12000,
            8421
          ));

          clients.add(new Customer(
            "Rick",
            "7728261289",
            "rick@gmail.com",
            "Karur",
            989824214,
            15000,
            3242
          ));

          clients.add(new Customer(
            "Ivan",
            "8778276278",
            "ivan@gmail.com",
            "Karur",
            84937294,
            20000,
            2331
          ));

          //object creation 
          Customer client1 = clients.get(0);
          Customer client2 = clients.get(1);
          Customer client3 = clients.get(2);

          //non-static Inner Class
          Customer.BankCard client1Card = client1.new BankCard(CardType.CREDIT,"4821",2030,"Active");
          Customer.BankCard client2Card = client2.new BankCard(CardType.CREDIT,"6194",2031,"Active");
          Customer.BankCard client3Card = client3.new BankCard(CardType.DEBIT,"3057",2032,"Active");

          bankCards = new Customer.BankCard[3];
          bankCards[0] = client1Card;
          bankCards[1] = client2Card;
          bankCards[2] = client3Card;

          //Static Inner Class
          Customer.Locker client1Locker = new Customer.Locker(101, "Medium", 2500, "Active");
          Customer.Locker client2Locker = new Customer.Locker(102, "Large", 4000, "Active");
          Customer.Locker client3Locker = new Customer.Locker(103,"Small",1500,"Active");

          lockers = new Customer.Locker[3];
          lockers[0] = client1Locker;
          lockers[1] = client2Locker;
          lockers[2] = client3Locker;

          //Anonymous Inner Class
          // Customer validator = new Customer(){
          //   @Override
          //   public void validateAccount() {
          //     System.out.println("GENERAL ACCOUNT VALIDATION" + "\n" + endLine);
          //     System.out.println("Account validation completed.");
          //     System.out.println("Account Status : Valid");
          //     System.out.println(endLine);
          //   }
          // };

          //Interface for single class implementaiton
          security = new AccountSecurity[3];
          security[0] = client1;
          security[1] = client2;
          security[2] = client3;

          
          //Interface for Multiple class implementaiton
          benefits = new AccountBenefits[3];
          benefits[0] = client1;
          benefits[1] = client2;
          benefits[2] = client3;

          //Functional Interface
          penalty = new PenaltyCalculator[3];
          penalty[0] = client1;
          penalty[1] = client2;
          penalty[2] = client3;

          //Functional Interface with lambda expression
          contactUpdaters = new AccountContactUpdater[2];
          contactUpdaters[0] = client1.getContactUpdater();
          contactUpdaters[1] = client2.getContactUpdater();

          // //Excute the lambda expression
          // contactUpdaters[0].contactUpdater("8877349102","Kevin34@gmail.com");
          // contactUpdaters[1].contactUpdater( "9123456789", "rick45@gmail.com");
          
          // client1.setcustomerName("Kevin");
          // client2.setCustomerName( "Rick");
          // client3.setCustomerName("Ivan");

          // client1.setAccountNumber(9876543210);
          // client2.setAccountNumber(989824214);
          // client3.setAccountNumber(849372947);
          
          // client1.setBalance(10000);
          // client2.setBalance(15000);
          // client3.setBalance(20000);

          //Object creation using parameter
          client1.updateBranch("Chennai",600119);
          client2.updateBranch("Karur",639005);  
          client3.updateBranch("Karur",639002);

          client1.updateAccountType(AccountType.SAVINGS);
          client2.updateAccountType(AccountType.SALARY);
          client3.updateAccountType(AccountType.CURRENT);
      
          client1.updateNominee("Mark","Father");
          client2.updateNominee("Emma","Sister");
          client3.updateNominee("Carla","Wife");

          client1.updateKYCStatus("Verified","Aadhar and PAN Card");
          client2.updateKYCStatus("Verified","Aadhar and PAN Card");
          client3.updateKYCStatus("Verified","Aadhar and PAN Card");
          
          // client1.email = "kevin@gmail.com";
          // client2.email = "rick@gmail.com";
          // client3.email = "ivan@gmail.com";

          // client1.phoneNumber = "9876543210";
          // client2.phoneNumber = "7728261289";
          // client3.phoneNumber = "8778276278";

          // client1.address = "Chennai";
          // client2.address = "Karur";
          // client3.address = "Karur";

          client1.setAccountStatus(AccountStatus.ACTIVE);
          client2.setAccountStatus(AccountStatus.FROZEN);
          client3.setAccountStatus(AccountStatus.BLOCKED);

          client1.setMonthlyDeposits(new double[] {
          25000,
          28000,
          26500,
          29000,
          30000,
          31500,
          30500,
          32000,
          31000,
          33000,
          34000,
          35500
          });

          client1.setMonthlyTransactions(new double[][]{
          {25000,  5000, 120},   // January
          {28000,  4500, 135},   // February
          {26500,  6000, 140},   // March
          {29000,  5500, 150},   // April
          {30000,  7000, 160},   // May
          {31500,  6500, 170},   // June
          {30500,  5000, 165},   // July
          {32000,  6000, 180},   // August
          {31000,  5500, 175},   // September
          {33000,  7000, 190},   // October
          {34000,  6500, 200},   // November
          {35500,  7500, 210}    // December
          });


          client2.setMonthlyDeposits(new double[]{
          18000,
          18500,
          19000,
          20000,
          19500,
          21000,
          22000,
          21500,
          22500,
          23000,
          24000,
          25000
          });

          client2.setMonthlyTransactions( new double[][]{
          {18000, 3500,  90},   // January
          {18500, 3200,  95},   // February
          {19000, 4000, 100},   // March
          {20000, 3800, 105},   // April
          {19500, 4200, 102},   // May
          {21000, 4500, 110},   // June
          {22000, 4700, 115},   // July
          {21500, 4300, 112},   // August
          {22500, 4600, 118},   // September
          {23000, 5000, 120},   // October
          {24000, 5200, 125},   // November
          {25000, 5500, 130}    // December
          });

          client3.setMonthlyDeposits(new double[]{
          45000,
          47000,
          46500,
          48000,
          49000,
          50000,
          51000,
          52000,
          51500,
          53000,
          54000,
          55000
          });

        client3.setMonthlyTransactions(new double[][]{
          {45000,  8000, 220},   // January
          {47000,  8500, 230},   // February
          {46500,  7800, 225},   // March
          {48000,  9000, 235},   // April
          {49000,  9500, 240},   // May
          {50000, 10000, 250},   // June
          {51000,  9800, 255},   // July
          {52000, 10500, 260},   // August
          {51500, 10200, 258},   // September
          {53000, 11000, 270},   // October
          {54000, 11500, 280},   // November
          {55000, 12000, 290}    // December
        });

        customers = new Customer[] {
        client1,
        client2,  
        client3
        };

        }

      public static void validateAccounts() {

        Customer validator = new Customer() {
          //Anonymous Inner Class
          @Override
          public void validateAccount() {

            System.out.println("GENERAL ACCOUNT VALIDATION" + "\n" + endLine);
            System.out.println("Account validation completed.");
            System.out.println("Account Status : Valid");
            System.out.println(endLine);
          }
        };

        validator.validateAccount();
        } 

        public static void displayCustomerManagement() {

        for (int i = 0; i < customers.length; i++) {

            customers[i].customerDetail();
            customers[i].customerContactReport();
            customers[i].displayMonthlyDeposits();
            customers[i].displayMonthlyTransactions();
            bankCards[i].displayCardDetails();
            lockers[i].displayLockerDetails();
            customers[i].calculateInterest();
            customers[i].calculateRewards();
            customers[i].checkBenefits();
            validateAccounts();
            customers[i].minimumBalancePenaltyCalculator();
          }
          customers[0].lockAccount();
          customers[1].verifyIdentity();
          customers[2].changePin(2331, 1332, 1332);
        }

        public static void startBank() {
        initializeCustomers();
        }

        public static Customer getCustomerByPin(int pin) {

          if (customers == null) {
            return null;
          }

        for (Customer customer : customers) {

            if (customer.getCurrentPin() == pin) {  
              return customer;
            }
            
          }
        return null;
        }

        public static void main(String [] args){
          
          System.setProperty("app.mode", "CUSTOMER_MANAGEMENT");
          
          Customer.welcome();
    
          initializeCustomers();
          displayCustomerManagement();

          // //Anonymous Object Creation 
          // new Customer("Tyson",88484936,20000).customerDetail();
        
          //Array of object  creation
          Customer[] customers = new Customer[2];
          customers[0] = new Customer("Simon","8976574653","kingpin@gmail.com","Chennai",887107215,34000,7353);
          customers[1] = new Customer("Martin","7569675548","martin@gmail.com","Chennai",897129617,50000,3252);

          Customer.BankCard customer1Card = customers[0].new BankCard(CardType.DEBIT,"7542",2030,"Active");
          Customer.BankCard customer2Card = customers[1].new BankCard(CardType.DEBIT,"1397",2030,"Active");

          Customer.Locker customer1Locker = new Customer.Locker(104,"Medium",2500,"Inactive");
          Customer.Locker customer2Locker = new Customer.Locker( 105,"Large",4000,"Active");

          bankCards = new Customer.BankCard[2];
          bankCards[0] = customer1Card;
          bankCards[1] = customer2Card;

          lockers = new Customer.Locker[2];
          lockers[0] = customer1Locker;
          lockers[1] = customer2Locker;

          security = new AccountSecurity[2];
          security[0] = customers[0];
          security[1] = customers[1];
        
          benefits = new AccountBenefits[2];
          benefits[0] = customers[0];
          benefits[1] = customers[1];

          penalty = new PenaltyCalculator[2];
          penalty[0] = customers[0];
          penalty[1] = customers[1];
          

          // customers[0].setCustomerName("Simon");
          // customers[1].setCustomerName("Martin");
          
          // customers[0].setAccountNumber(887107215);
          // customers[1].setAccountNumber(897129617);
          
          // customers[0].setBalance(34000);
          // customers[1].setBalance(50000);

          //Array of object creation using parameter
          customers[0].updateBranch("Chennai",600119);
          customers[1].updateBranch("Chennai",600119);  

          customers[0].updateAccountType(AccountType.CURRENT);
          customers[1].updateAccountType(AccountType.CURRENT);
      
          customers[0].updateNominee("Roy","Father");
          customers[1].updateNominee("Willson","Father");

          customers[0].updateKYCStatus("Verified","Passport");
          customers[1].updateKYCStatus("Verified","Aadhar and PAN Card");

          // customers[0].email = "kingpin@gmail.com";
          // customers[1].email = "martin@gmail.com";

          // customers[0].phoneNumber = "8976574653";
          // customers[1].phoneNumber = "7569675548";
      
          // customers[0].address = "Chennai";
          // customers[1].address = "Chennai";

          customers[0].setAccountStatus(AccountStatus.ACTIVE);
          customers[1].setAccountStatus(AccountStatus.ACTIVE);

          customers[0].setMonthlyDeposits(new double[]{
          32000,
          33000,
          34000,
          35000,
          36000,
          35500,
          37000,
          38000,
          39000,
          40000,
          41000,
          42500
          });

          customers[0].setMonthlyTransactions(new double[][]{
          {32000, 6000, 170},   // January
          {33000, 6200, 175},   // February
          {34000, 6500, 180},   // March
          {35000, 6800, 185},   // April
          {36000, 7000, 190},   // May
          {35500, 6900, 188},   // June
          {37000, 7200, 195},   // July
          {38000, 7500, 200},   // August
          {39000, 7800, 205},   // September
          {40000, 8000, 210},   // October
          {41000, 8200, 215},   // November
          {42500, 8500, 220}    // December
          });
          
          customers[1].setMonthlyDeposits(new double[]{
          52000,
          53000,
          54000,
          55000,
          56000,
          57500,
          59000,
          60000,
          61000,
          62000,
          63500,
          65000
          });

          customers[1].setMonthlyTransactions(new double[][]{
          {52000, 10000, 260},   // January
          {53000, 10200, 265},   // February
          {54000, 10500, 270},   // March
          {55000, 10800, 275},   // April
          {56000, 11000, 280},   // May
          {57500, 11500, 288},   // June
          {59000, 11800, 295},   // July
          {60000, 12000, 300},   // August
          {61000, 12200, 305},   // September
          {62000, 12500, 310},   // October
          {63500, 12800, 318},   // November
          {65000, 13000, 325}    // December
          });

          for(int i=0;i<customers.length;i++){
            customers[i].customerDetail();
            customers[i].customerContactReport();
            customers[i].displayMonthlyDeposits();
            customers[i].displayMonthlyTransactions();
            bankCards[i].displayCardDetails();
            lockers[i].displayLockerDetails();
            // validator.validateAccount();
            security[i].verifyIdentity();
            benefits[i].calculateInterest();
            benefits[i].calculateRewards();
            benefits[i].checkBenefits();
            penalty[i].minimumBalancePenaltyCalculator();
          }
        
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

          premiumClient1.setAccountStatus(AccountStatus.ACTIVE);
          premiumClient1.setManagerContactInfo("9876243392", "david@kavibank.com");
          PremiumCustomer.BankCard premiumClient1BankCard = premiumClient1.new BankCard(CardType.PREMIUMCREDIT,"7821",2032,"Active");
          PremiumCustomer.Locker premiumclient1Locker = new PremiumCustomer.Locker(201,"Extra Large",7500,"Active");
          AccountSecurity premiumClient1Security = premiumClient1;
          AccountBenefits premiumClient1Benefits = premiumClient1;
          PenaltyCalculator premiumClient1PenaltyCalculator = premiumClient1;

          premiumClient1.customerDetail();
          premiumClient1.customerContactReport();
          premiumClient1.premiumCustomerReport();
          premiumClient1BankCard.displayCardDetails();
          premiumclient1Locker.displayLockerDetails();
          premiumClient1Security.verifyIdentity();
          premiumClient1Benefits.calculateInterest();
          premiumClient1Benefits.calculateRewards();
          premiumClient1Benefits.checkBenefits();
          premiumClient1PenaltyCalculator.minimumBalancePenaltyCalculator();


          // //Dynamic Method Dispatch
          // Customer client6 = new Customer( "Arjun",
          //   "9123456780",
          //   "arjun@gmail.com",
          //   "Coimbatore",
          //   875634219,
          //   25000);

          // // NORMAL METHOD 
          // // client6.customerContactReport();

          // client6 = new PremiumCustomer(
          //   "Arjun",
          //   "9123456780",
          //   "arjun@gmail.com",
          //   "Coimbatore",
          //   875634219,
          //   25000,

          //   "Coimbatore",
          //   641001,
          //   "Current",
          //   5000,
          //   "Rahul",
          //   "Brother",
          //   "Verified",
          //   "Passport and PAN Card",

          //   4200,
          //   750000,
          //   "Sarah",
          //   true,
          //   7.5,
          //   true,
          //   "Diamond");

          // //OVERIDE METHOD
          // client6.customerContactReport();
        
          // //Up Casting    
          // Person  person = new Customer("Mohan","8787553628","mohan843@gmail.com","Madurai",894576812,17000);
          // person.displayPersonInfo();
          // //Down casting
          // Customer customer = (Customer) person;
          // customer.customerContactReport();
        
          // //Abstraction
          // Person person1 = new Customer("Kevin","9876543210","kevin@gmail.com","Chennai",989824214,10000); 
          // person1.displayPersonInfo();
        }   
    }
