import java.util.Scanner;

public class AgeLimits {
	final static int	MINIMUM_LEGAL_DRIVING_AGE	=	17;
	final static int	MINIMUM_LEGAL_DRINKING_AGE	=	19;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(" Enter	your age? ");	
		Scanner	input	=	new	Scanner(	System.in	);	
		int	age	=	input.nextInt();	
		if	(age <=	MINIMUM_LEGAL_DRIVING_AGE)	
		{	
		System.out.println("You are not allow to do both the two things now!");					
		}
		if	(age>=	MINIMUM_LEGAL_DRINKING_AGE	)	
		{	
		System.out.println(	"You may now both legally drive and drink!");				
		}
		if  (age>MINIMUM_LEGAL_DRIVING_AGE & age<MINIMUM_LEGAL_DRINKING_AGE)
		{
		System.out.println( "You may now drive now, but not legelly drink!");
		}
	}

}
