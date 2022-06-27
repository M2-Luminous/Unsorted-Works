import java.util.Scanner;

public class HelloName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("What is your name? ");
		Scanner input = new Scanner( System.in );
		String name = input.next();
		System.out.println("Hello " + name);
	}

}
