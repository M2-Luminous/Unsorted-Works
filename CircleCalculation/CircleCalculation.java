import java.util.Scanner;

public class CircleCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("What is the radius of the circle?");
		Scanner input = new Scanner( System.in );
		double radius = input.nextDouble();
		input.close();
		double diameter = radius * 2.0;
		double circumference = 2.0 * Math.PI * radius;
		double area = Math.PI * radius * radius;
		System.out.println("For a circle of radius " + radius +
		"\n Diameter = " + diameter +
		"\n Circumference = " + circumference +
		"\n Area = " + area);
	}

}
