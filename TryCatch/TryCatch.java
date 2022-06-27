import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			System.out.print( "Enter a number: ");
			Scanner input = new Scanner( System.in );
			int number = input.nextInt();
			int result = 100/number;
			System.out.printf( "100 divided by %d is %d\n", number, result);
			input.close();
		}
		catch (ArithmeticException exception)
		{
			System.out.println( "Sorry, the computation is not possible." );
			System.err.printf( "Exception thrown: %s\n", exception );
		}
		catch (InputMismatchException exception)
		{
			System.out.println( "You need to supply a whole number." );
			System.err.printf( "Exception thrown: %s\n", exception );
		}
		
		
	}
}


