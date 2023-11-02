
public class BasicMethod {

	static void method(String name){
		name = "Hej igen "+name+"!";
		System.out.println("Frasen är: " + name);
	}
	//Does not send back information. We have created a function from the beginning.
	//By writing what kind of variable will exist we write String. Then name is our variable which only exists within code
	
	static void addition(int a, int b ){
		int resultat = a + b;
		System.out.println(resultat);
	}
	
	public static void main(String[] args) {
		String name = "Tawsiful";
		
		System.out.println("Hello World");
		method(name);				//Main will be run thus do everything underneath.
									//It is cursive and main will run this function and the code/variable depending on what is written inside.
		System.out.println("Calling done");
		
		addition(3,4);

	}

}
