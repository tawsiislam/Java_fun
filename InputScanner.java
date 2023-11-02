import java.util.Scanner;  // imports a packet that enables us to use the input code


public class InputScanner {

	public static void main(String[] args) {

			Scanner input = new Scanner(System.in); 
			//This code enables the system to input a string/value with help of the imported packet
			//Scanner is the function and input is the name of the code we have defined
			System.out.println("Write your name: "); //ln in println means "new line"
			String name = input.nextLine();			// You can name and define the values on the same line. 
			//input.nextLine means that next that is written will be input in the variable name
			
			System.out.println("Write your age: ");
			int age = input.nextInt();
			// By writing nextInt enables the person to only input an integer or else there is an error
			
			System.out.println("Write your height(m): ");
			double length = input.nextDouble();
			
			System.out.println(name+" is "+age+" years old and "+length+" m long.");
	}

}
