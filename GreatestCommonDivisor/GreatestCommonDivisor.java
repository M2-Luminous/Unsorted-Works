import java.util.Scanner;

public class GreatestCommonDivisor {
	public static void main(String[] args) {
		try
		{
			System.out.print("Enter first number:");
			Scanner input = new Scanner( System.in );
			int number1 = input.nextInt();
			System.out.print("Enter second number:");
			int number2 = input.nextInt();
			
			
			if ((number1 <= 0) || (number2 <= 0))
				throw new NumberFormatException();
			
			
			int gcd = getGreatestCommonDivisor ( number1, number2 );
			System.out.print( "The greatest common divisor of " +
					number1 + " and " + number2 + " is " + gcd);
		}
		catch (NullPointerException exception)
		{
		}
		catch (java.util.NoSuchElementException exception)
		{
			System.out.print( "Error: No number entered.");
		}
		catch (NumberFormatException exception)
		{
			System.out.print( "Error: Numbers must be greater than 0.");
		}
	}
//This function takes two integers and returns the largest
//number which divides evenly into both of them.
	private static int getGreatestCommonDivisor ( int number1,
														int number2 )
{
		int gcd = 1;
		int divisor = 1;
		while ((divisor != -1) && (divisor < number2))
		{
			if (number2%divisor == 0)
			{
				gcd = divisor;
			}
			divisor = getNextDivisor( divisor, number1 );
		}
		return gcd;
}
//Given a number and a divisor, find and return the next
//highest divisor of the number. If there is no such divisor
//return -1.
	private static int getNextDivisor( int lastDivisor, int number )
	{
	if ((lastDivisor > 0) && (lastDivisor < number) &&
							(number % lastDivisor == 0))
	{
		int divisor = lastDivisor;
		do  {
				divisor++;
			} while (number % divisor != 0);
	return divisor;
	}
	return -1;
	}
}

