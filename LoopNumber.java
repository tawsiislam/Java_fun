import java.util.Scanner;

public class LoopNumber {

	public static void main(String[] args) {
		Scanner inputNumber = new Scanner (System.in);
		System.out.println("Calculate the sum of following 10 numbers from: ");
		
		int n = inputNumber.nextInt(); //variable that user write
		int f;	//variable adding to the sum
		System.out.println("Input interval: ");
		int i = inputNumber.nextInt(); //interval
		int sum=0;

		int end = n+10*i; //Last number
		
		for (f=n; f<=end; f=f+i) 
			{
				System.out.print(f); 
				sum = sum+f; 		//Here we print new sum
			}
		System.out.println(); //Creates a new line
		System.out.println("The sum is: " +sum);
		
	

	}

}
