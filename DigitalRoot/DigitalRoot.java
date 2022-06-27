import java.util.Scanner;

public class DigitalRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(
		"Enter an integer to compute its digital root:");
		Scanner input = new Scanner( System.in );
		int number = input.nextInt();
		int currentValue = number;
		while (Math.abs(currentValue) >= 10)
		{
			int remainingNumber = currentValue;
			int sumOfDigits = 0;
			while (remainingNumber != 0)
			{
				sumOfDigits += remainingNumber%10;
				remainingNumber = remainingNumber/10;
			}
			currentValue = sumOfDigits;
		}
		int digitalRoot = currentValue;
		System.out.printf( "The digital root of %d is %d", number,
		digitalRoot );
	}

}
