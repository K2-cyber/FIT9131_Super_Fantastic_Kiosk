import java.util.*;

/**
 * Write a description of class Kiosk here.
 *
 *Kiosk class is the front end application which is directly interacting with the customer.
 *Kiosk class uses inputs from the customer and performs the necessary actions.
 *Kiosk class is dependent on the customer classs and random number generator class for showing the name of the customer and generating a random number for the purchasing part.
 *
 *
 * @author Kapish
 * @version (22nd April 2021)
 */


public class Kiosk
{
    private Customer customerProfile;
    private LuckyDipGenerator luckyDip;
    
    public Kiosk()
    {
        luckyDip = new LuckyDipGenerator();
    }
    
    private int getItemCost(int itemNumber)
    {
        switch (itemNumber)
        {
            case 1:
                return 10;
            case 2:
                return 20;
            case 3:
                return 30;
            case 4:
                return 40;
            case 5:
                return 50;
            default:
                return 0;
        }
    }
    
    private String getItemName(int itemNumber)
    {
        switch (itemNumber)
        {
            case 1:
                return "PEN";
            case 2:
                return "BOOK";
            case 3:
                return "DVD";
            case 4:
                return "MOUSE";
            case 5:
                return "KEYBOARD";
            default:
                return "NONE";
        }
    }
    
    private int getResponse()
    {
        int userChoice = 0;
        String choiceString = "";
        Scanner consoleInput = new Scanner(System.in);
        
        System.out.println("Choose an option: ");
        
        choiceString = consoleInput.nextLine();
        if (choiceString.matches("[0-9]+"))
        {
            userChoice = Integer.parseInt(choiceString);       // takes string as a paramter and parses it to integer
            if (userChoice>0 && userChoice<8)
                return userChoice;
            else
                System.out.println("You can only choose between number 1 & 7");
        }
        
        else
            System.out.println("You can only choose between number 1 & 7");
            return 0;
    }
    
    public void handlerFlow()
    {
        boolean shouldContinue = true;
        while (shouldContinue)
        {
            printMenu();
            int userChoice = getResponse();
            shouldContinue = processResponse(userChoice);
        }
    }
    
    private void printMenu()
    {
        System.out.println("Welcome to Super Fantastic Kiosk");
        System.out.println("================================");
        System.out.println("(1) Create A New Order");
        System.out.println("(2) Buy More Credit");
        System.out.println("(3) Purchase An Item");
        System.out.println("(4) What have I Ordered So Far?");
        System.out.println("(5) Collect My Order");
        System.out.println("(6) Display Help");
        System.out.println("(7) Leave Kisok");
    }
    
    private boolean processResponse(int userChoice)
    {     
        Scanner consoleInput = new Scanner(System.in);   // the scope of the object will be throughout the method
        
        if (userChoice == 0)
            return true;
        
        
        else if (userChoice == 1)
        {
            if (customerProfile != null)
                System.out.println("## We can not create a new profile, Please checkout using option (5)");
            else
            {
                customerProfile = new Customer();
                System.out.println("Enter your name please: ");
                String userName = consoleInput.nextLine();
                
                System.out.println("Buy some credits please: ");
                int userCredit = consoleInput.nextInt();
                consoleInput.nextLine();
                
                // cutomer class methods are called to create a new order for new customer
                
                customerProfile.setName(userName);
                customerProfile.setBalance(userCredit);
            }
        }
        
        else if (userChoice == 2)
        {
            if (customerProfile != null)
            {
                int increasedCredit = 0;
                System.out.println("Enter more credit you wish to add to your account: $");
                increasedCredit = consoleInput.nextInt();
                consoleInput.nextLine();
                customerProfile.addBalance(increasedCredit);
                
            }
            
            else
            {
                System.out.println("##CREATE A PROFILE FIRST USING OPTION 1###");
                
            }
        }
        
        else if (userChoice == 3)
        {
            if (customerProfile!= null)
            {
                int numValue;
                System.out.println("These are the items available for sale today:");
                System.out.println("---------------------------------------------");
                System.out.println("(1) PEN, worth $10 ");
                System.out.println("(2) BOOK, worth $20 ");
                System.out.println("(3) DVD, worth $30 ");
                System.out.println("(4) MOUSE, worth $40 ");
                System.out.println("(5) KEYBOARD, worth $50 ");
                System.out.println("(6) Help me pick somthing randomly! ");
                
                System.out.println("Pick a number between 1-6 :");
                numValue = consoleInput.nextInt();
                consoleInput.nextLine();
                
                if (numValue>0 && numValue<6)
                {
                    purchaseItem(getItemCost(numValue), getItemName(numValue));
                }
                    
                    
                
                else if (numValue == 6)
                {
                    int randomInteger = luckyDip.generateRandomNumber();
                    purchaseItem(getItemCost(randomInteger), getItemName(randomInteger));
                }
                
                else 
                    
                    System.out.println("Error: Your choice should be limited from 1 to 6");
            }
            
            else
                System.out.println("##CREATE A PROFILE FIRST USING OPTION 1###");
        }
        
        
        else if (userChoice == 4)
        {
            if (customerProfile!= null)
            {
                System.out.println("Customer " + customerProfile.getName());
                System.out.println("Total products are: " + customerProfile.totalProduct());
                System.out.println("Balance Left: $" + customerProfile.getBalance());
            }
            
            else
                System.out.println("##CREATE A PROFILE FIRST USING OPTION 1###");
        }
        
        else if (userChoice == 5)
        {
            if (customerProfile != null)
            {
                System.out.println("Customer " + customerProfile.getName());
                System.out.println("Total products are: " + customerProfile.totalProduct());
                System.out.println("Total Expenditure: " + customerProfile.finalCost());
                System.out.println("Balance is: " + customerProfile.getBalance());
                System.out.println("Your order is complete, kindly collect your products from the front counter.");
                customerProfile = null;
            }
            
            else
                System.out.println("##CREATE A PROFILE FIRST USING OPTION 1###");
        }
        
        else if (userChoice == 6)
        {
            System.out.println("You have reached the help menu of the kiosk");
            System.out.println("Please pay attention to the following instructions");
            System.out.println("Items available for sale today are PEN, BOOK, DVD, MOUSE, KEYBOARD ");
            System.out.println("If you are confused to choose between any of the items, let us do the job for you");
            System.out.println("Keep in mind, we will inform you if your credit is not enough!");
            System.out.println("I hope you are enjoying this interaction with us, have a lovely day ahead!!");
        }
        
        else
        {
            return false;
        }
        
        return true;
    }
    
    private void purchaseItem(int itemCost , String itemName)
    {
        boolean isValid = customerProfile.purchaseValidity(itemCost);
        if (isValid == true)
        {
            customerProfile.purchaseCost(itemCost);
            customerProfile.addProduct(itemName);
        }
    }
}