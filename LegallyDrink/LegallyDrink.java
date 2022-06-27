import java.util.Scanner;

public class LegallyDrink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter	your	age?	");	
		Scanner	input	=	new	Scanner(	System.in	);	
		int	age	=	input.nextInt();	
		boolean	isAdult	=	(age	>=	18);	
		if	(isAdult)	
		{	
				System.out.println("You	may	now	legally	drink!");
		}
		else
		{
				System.out.println("You may not legally drink yet!");
		}
	}

}
