
/**
 * Write a description of class Customer here.
 *
 *Customer class deals with the getter and setter methods for : name of customer, products bought, total cost and many more functions.
 *The idea is to complete all the functons of the new customer object. 
 *
 * @author Kapish
 * @version (22nd April 2021)
 */
public class Customer
{
    private String cusName;
    private String productName;
    private int productCost;
    private int balance;
    private int totalBill;
    
    public Customer()
    {
        cusName = "";
        productName = "";
        productCost = 0;
        balance = 0;
        totalBill = 0;
    }
    
    public void addBalance(int moreCredit)
    {
        balance = balance + moreCredit;
    }
    
    public void addProduct(String itemName)
    {
        if (productName.equals(""))
            productName = itemName;
        else
            productName = productName + ", " + itemName;
    }
    
    public int finalCost()
    {
        return totalBill;
    }
    
    public int getBalance()
    {
        return balance;
    }
    
    public int getCost()
    {
        return productCost;
    }
    
    public String getName()
    {
        return cusName;
    }
    
    public void purchaseCost(int productPrice)
    {
        totalBill = totalBill + productPrice;
    }
    
    public boolean purchaseValidity(int productCost)
    {
        if (balance >= productCost) 
        {
            balance = balance - productCost; // Reduce the balance by the productprice.
            return true;
            
        }
        else 
        {
            System.out.println("Sorry, You do not have enough balance. " +
                               (productCost - balance) + " more bucks required");
            return false;
                    
        }
    }
    
    public void setBalance(int creditValue)
    {
        balance = creditValue;
    }
    
    public void setName(String name)
    {
        cusName = name;
    }
    
    public String totalProduct() //allProductInformation
    {
        return productName;
    }
}
