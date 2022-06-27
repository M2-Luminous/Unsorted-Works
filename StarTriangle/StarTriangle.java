import java.util.Scanner;

public class StarTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Please enter a number: ");
		Scanner inputScanner = new Scanner(System.in);
			if (inputScanner.hasNextInt())
			{
				int h = Math.abs(inputScanner.nextInt());
				for (int r = -(h-1); (r < h); r++)
				{
					int c = 0;
					for (; (c < Math.abs(r)); c++)
						System.out.print( " " );
					for (; (c < h); c++)
						System.out.print( "*" );
					System.out.println();
				}
			}
		inputScanner.close();
	}

}
