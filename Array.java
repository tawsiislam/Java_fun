import javax.swing.ImageIcon;

/*Can be used in any program*/
public class Array { 
	
	//Prints an Array of int
	public static void printIntArray(int[]inputIntArray){
		int index;
		for(index=0;index<inputIntArray.length-1;index++){
			System.out.print(inputIntArray[index]+", ");
		}
		System.out.print(inputIntArray[index++]);
	}
	public static void printDoubleArray(double[]inputIntArray){
		int index;
		for(index=0;index<inputIntArray.length-1;index++){
			System.out.print(inputIntArray[index]+", ");
		}
		System.out.print(inputIntArray[index++]);
	}
	//Prints an Array of String
	public static void printStringArray(String[]inputStringArray){
		int index;
		for(index=0;index<inputStringArray.length-1;index++){
			System.out.print(inputStringArray[index]+", ");
		}
		System.out.print(inputStringArray[index++]);
	}
	
	//Finding the maximum value
	public static int maximum(int[] inputArray){ //Uses an integer array as input
		int maxValue = 0; 
		int count; 
		
		maxValue = inputArray[0]; //The first value in the index 0 will be the max
		for (count = 1; count < inputArray.length; count++){ //Counting from the next index
			if(maxValue < inputArray[count]){ 
				maxValue = inputArray[count]; 	//Checking if the value is large than the 
												//previous max and rewrites into that max variable
			} 
		} 
		return maxValue ; 
	} 
	
	//Finding the minimum value
	public static int minimum(int[] inputArray){
		int minValue = 0; 
		int count; 
		
		minValue = inputArray[0]; 
		for (count = 1; count < inputArray.length; count++){ 
			if(minValue > inputArray[count]){ 
				minValue = inputArray[count]; 	
			} 
		} 
		return minValue ; 
	} 
	
	/* Finding the mean value*/
	public static double mean(int[] inputArray){
		int sum = 0; 
		double mean; 
		
		for (int count = 0; count < inputArray.length; count++){ 
			sum=sum+inputArray[count];
		} 
		mean=sum/inputArray.length;
		return mean ; 
	}
	
	public static double mode(double [] inputArray){
        double maxValue = 0, maxCount = 0;
 
        for (int i = 0; i < inputArray.length; ++i){
            int count = 0;
            for (int j = 0; j < inputArray.length; ++j){
                if (inputArray[j] == inputArray[i])
                    ++count;
            }
            if (count > maxCount){
                maxCount = count;
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }
	
	//Sorting the Array with Bubble sort method
	public static void sortBubbleArray(int [] inputArray){
		boolean changed=true;
		int temporary;
		int maxBound=1;
		
		while (changed){
			changed=false;
			for(int index=0;index<inputArray.length-maxBound;index++){  						
				if(inputArray[index]>inputArray[index+1]){
					temporary = inputArray[index];
					inputArray[index]=inputArray[index+1];
					inputArray[index+1]=temporary;
					changed=true;
				}
			}
			maxBound++;	
		}		
	}
	
	/*Used to shuffle cards by selecting a random card that the current card (dependent on index) will swap place with.
	* The index goes up to number of cards there are in the deck 
	*The temporary variable for ImageIcon and int is used to restore a data rather than replacing it when the data is stored in each other.*/
	public static void shuffleImageIconArrayIntArray (ImageIcon[]inputImageArray,int[]inputIntArray){
		for (int index=0;index<inputImageArray.length;index++){
			//Generates a random number, between 0 to number of cards in the deck, as element in the Array that can be swaped with
			int randomIndex = (int) Math.floor(Math.random() * inputImageArray.length);
			
			//ImageIcon of the Card swap places
			ImageIcon temporary = inputImageArray[index];
			inputImageArray[index]=inputImageArray[randomIndex];
			inputImageArray[randomIndex]=temporary;
			
			//The cards value swap places using the same positions/element as the ImageIcons did (index changes with randomindex)
			int temporaryInt = inputIntArray[index];
			inputIntArray[index]=inputIntArray[randomIndex];
			inputIntArray[randomIndex]=temporaryInt;
			
		}
	}
	
	
	public static void shuffletwoArray (String [] inputStringArray, int[] inputIntArray){
		for (int index=0;index<inputStringArray.length;index++){
			int randomIndex = (int) Math.floor(Math.random() * inputStringArray.length);
			String tempString = inputStringArray[index];
			inputStringArray[index]=inputStringArray[randomIndex];
			inputStringArray[randomIndex]=tempString;
			
			int temporary = inputIntArray[index];
			inputIntArray[index]=inputIntArray[randomIndex];
			inputIntArray[randomIndex]=temporary;
		}
	}
	
	public static void sortIntStringArray(int [] inputIntArray, String [] inputStringArray){
		boolean changed=true;
		int maxBound=1;
		String tempString;
	
		while (changed){
			changed=false;
			for(int index=0;index<inputIntArray.length-maxBound;index++){
				if (inputIntArray[index]>inputIntArray[index+1]){ 
					int temporary = inputIntArray[index];
					inputIntArray[index]=inputIntArray[index+1];
					inputIntArray[index+1]=temporary;
					
					tempString = inputStringArray[index];
					inputStringArray[index]=inputStringArray[index+1];
					inputStringArray[index+1]=tempString;
					changed=true;	
				}
			}
			maxBound++;
		}		
	}
	
	public static void sortStringIntArray(String [] inputStringArray,int [] inputIntArray){
		boolean changed=true;
		int maxBound=1;
		String tempString;
	
		while (changed){
			changed=false;
			for(int index=0;index<inputStringArray.length-maxBound;index++){
				if (inputStringArray[index].compareTo(inputStringArray[index+1])>0){ 
					int temporary = inputIntArray[index];
					inputIntArray[index]=inputIntArray[index+1];
					inputIntArray[index+1]=temporary;
					
					tempString = inputStringArray[index];
					inputStringArray[index]=inputStringArray[index+1];
					inputStringArray[index+1]=tempString;
					changed=true;	
				}
			}
			maxBound++;
		}		
	}
	
	public static boolean arrayIntSearch(int [] inputArray, int itemSearch){
		int min=0;
		int max=inputArray.length-1;
		int guess;
		
		do{
			guess=(int) Math.ceil((max+min)/2);
			if(itemSearch==inputArray[guess]){
				 return true;
			}
			else{
				if(itemSearch<inputArray[guess]){
					max=guess-1;
				}
				else{
					min=guess+1;
				}
			}
		}while(max>=min);
		return false;
	}
	
	public static String arrayIntStringSearch (int[]inputIntArray, String[]inputStringArray, int itemSearch){
		int min=0;
		int max=inputIntArray.length-1;
		int guess;

		Array.sortIntStringArray(inputIntArray, inputStringArray);
		
		do{
			guess=(int) Math.ceil((max+min)/2);
			if(itemSearch==inputIntArray[guess]){
				return inputStringArray[guess];
			}
			else{
				if(itemSearch<inputIntArray[guess]){
					max=guess-1;
				}
				else{
					min=guess+1;
				}
			}
		}while(max>=min);
		return "Not found";
	}
	
	public static int arrayStringIntSearch (String[]inputStringArray, int[]inputIntArray, String itemSearch){
		int min=0;
		int max=inputIntArray.length-1;
		int guess;

		Array.sortStringIntArray(inputStringArray, inputIntArray);
		
		do{
			guess=(int) Math.ceil((max+min)/2);
			if(itemSearch.equalsIgnoreCase(inputStringArray[guess])){
				return inputIntArray[guess];
			}
			else{
				if(itemSearch.compareToIgnoreCase(inputStringArray[guess+1])<0){
					max=guess-1;
				}
				else{
					min=guess+1;
				}
			}
		}while(max>=min);
		System.out.println("Not found");
		return 0;
	}
}	
 
