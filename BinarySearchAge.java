import java.util.Scanner;
public class BinarySearchNames {
    
	
	public static void checkAge (String[]names, int[]ages, int age2Search){
		
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner( System.in);
		String[] names = {"Anna", "Bill", "Carl", "Dan", "Ella", "Fred", "Gill", "Harry", 
						"Ignacio", "Jill", "Karen", "Lucy", "Mike", "Nikhil", "Olle"};
		int[] ages = {15, 13, 25, 17, 11, 31, 7, 38, 83, 19, 5, 26, 42, 53, 71};
		
		System.out.println ("Enter the name of the person you wish to look up");
		int age = userInput.nextInt(); 
		checkAge(names, ages, age);
	}
}