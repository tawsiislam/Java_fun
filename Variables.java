public class Variables {

	public static void main(String[] args){
		String aWord;
		String bWord;
		char aLetter;
		int aWholeNumber;
		double aRealNumber;
		boolean aFlag;
		// Create a String and number and naming them (integer (must be whole number)), double (real number)
		// Double takes more memory and eventually slows down the program
		// Boolean take least space. Only true or false
			// Boolean are used when to check something, in a loop ex. can lead to something
		
		aWord = " Hello";
		bWord = "World!";
		aLetter = 'U';
		aWholeNumber = 100;
		aRealNumber = 100.5;
		aFlag = true;
		// Define the Strings and the int (number value)
		
		System.out.println(aLetter+aWord+" "+bWord);
		System.out.println(aWholeNumber+ " + "+aRealNumber+" equals");
		System.out.println(aWholeNumber+aRealNumber);
		System.out.println("The boolean is "+aFlag);
		// Print out or write out everything inside parenthesis
		// Plus "+" combines the Strings
	}
}
