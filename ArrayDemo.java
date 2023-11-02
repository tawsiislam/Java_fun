
public class ArrayDemo {

	public static void main(String[] args) {
		int[] numArray=new int[10]; //[] Says that it will be an array and the number inside says how many
									// Positions it should have. The array starts from 0
		
		numArray[7]=5;
		numArray[2]=2;
		numArray[0]=numArray[2]+numArray[7];	//Arrays can work with arithmetic operations
		// To write many data at the same time
		String[] månader = {"jan","feb","mar","apr","maj","jun","jul","aug","sep","okt","nov","dec"};
		
		System.out.println(numArray[7]);
		System.out.println(numArray[2]);
		System.out.println(numArray[0]);

		for(int count=0;count<numArray.length;count++){
			numArray[count]= (int)Math.ceil(Math.random()*100);
		}
		for(int count=0;count<numArray.length;count++){
			System.out.print(numArray[count]+", ");
		}
		System.out.println("Nu är det "+månader[10]+".");
		
	}

}
