import java.util.Scanner;

public class LeapYears {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner( System.in );
		System.out.print("Enter the first year: ");
		int firstYear = input.nextInt();
		System.out.print("Enter the last year: ");
		int lastYear = input.nextInt();
		for (int year=firstYear; (year <= lastYear); year=year+1)
		{
			if ((year % 400 == 0) ||
			((year % 4 == 0) && (year % 100 != 0)))
			{
			System.out.println( "" + year + " is a leap year." );
			}
		}
	}
}
/*
Scanner input = new Scanner( System.in );
		System.out.print("Enter the first year: ");
		int firstYear = input.nextInt();
		System.out.print("Enter the last year: ");
		int lastYear = input.nextInt();
		for (int year=firstYear; (year <= lastYear); year=year+4)直接year+4不就好了吗2333
			System.out.println( "" + year + " is a leap year." );
		}
}
*/
