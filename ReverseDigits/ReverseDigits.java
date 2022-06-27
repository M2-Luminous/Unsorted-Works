import java.util.Scanner;

public class ReverseDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print( "Enter number to reverse: ");
		Scanner input = new Scanner( System.in );
		int number = input.nextInt();
		int reversedNumber = 0;
		int remainingNumber = number;
		while (remainingNumber > 0)
		{
		reversedNumber = reversedNumber*10 + remainingNumber%10;
		remainingNumber = remainingNumber/10;
		}
		System.out.printf( "The reverse of %d is %d\n", number,
		reversedNumber);
		input.close();

	}

}
