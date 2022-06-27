/*
System.out.print("Enter	the	year?	");	
			Scanner	input	=	new	Scanner(	System.in	);	
			int	year	=	input.nextInt();
			boolean	isLeapYear	=	((year	%	400	==	0)	||	
				(!(year	%	100	==	0)	&&	(year	%	4	==	0)));	
			if	(isLeapYear)
			System.out.print("Year " +	year +" is a leap year.");	
			else	System.out.print("Year " + year + " is not a leap year.");	 
 */
import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter	the	year?	");	
		Scanner	input=new Scanner(System.in	);	
		int	year=input.nextInt();
		boolean	isLeapYear = false;
		if	(year % 400	==	0)	
				isLeapYear = true;	
			else if	(year % 100	==	0)	
				isLeapYear = false;	
				else if	(year % 4 == 0)	
				isLeapYear = true;	
				else		
				isLeapYear = false;
		if	(isLeapYear)
			System.out.print("Year "+ year +" is a leap year.");	
	else	System.out.print("Year "+ year +" is not a leap year.");
	}

}
/*
	System.out.print("Enter	the	year?	");	
				Scanner	input	=	new	Scanner(	System.in	);	
				int	year	=	input.nextInt();
				boolean	isLeapYear	=	false;设定初始值就是false,可以少写最后的else
				if	(year	%	400	==	0)	
						isLeapYear	=	true;	
				else if	(year	%	100	==	0)	
						isLeapYear	=	false;	
				else if	(year	%	4	==	0)	
						isLeapYear	=	true;	
				if	(isLeapYear)
System.out.print("Year"	+ year + " is a leap year.");	
			else System.out.print("Year " + year + " is not	a leap year.");	
*/