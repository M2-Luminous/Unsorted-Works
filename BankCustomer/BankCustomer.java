
public class BankCustomer {
	private String accountNumber;
	private String customerName;
	private String customerAddress;
	private int customerDateOfBirth;
	
	
	
	public String getAccountNumber()
	{
		return accountNumber;
	}//getter

	public String customerName()
	{
		return customerName;
	}//getter

	public String customerAddress()
	{
		return customerAddress;
	}//getter
	
	public int customerDateOfBirth()
	{
		return customerDateOfBirth;
	}//getter
	
	
	public void setAccountNumber(String a)
	{
		accountNumber = a;
	}//setter
		public void setCustomerName(String b)
	{
		customerName = b;
	}//setter
    public void setcustomerAddress(String c)
	{
		customerAddress = c;
	}//setter
	public void setCustomerDateOfBirth(int d)
	{
		customerDateOfBirth = d;
	}//setter
	
		
	public static void main(String[] args) 
	{
		BankCustomer object = new BankCustomer();
		object.accountNumber = "111222333";
		object.customerName = "John Snow";
		object.customerAddress = "Winterfell";
		object.customerDateOfBirth = 20210205;	
		
	}//

}
/*
import java.util.Scanner;

public class Swap { 
  
    public static void main(String[] args) 
    { 
	Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int x = input.nextInt(); 

        System.out.print("Enter second number: ");
        int y = input.nextInt(); 

        x = x + y; 
        y = x - y; 
        x = x - y; 

        System.out.println("After swaping:" + " x = " + x + ", y = " + y); 
    } 
} 
 */
