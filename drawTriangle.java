
public class drawTriangle {
	public static void drawTriangleRecursion(int n){
		for(int rounds=n; rounds>=1;rounds--){
			System.out.print("*");
		}
		System.out.println("");
		if (n>1){
			drawTriangleRecursion(n-1);
		}
	}
	
	public static void drawTriangleRecursionReversed(int n){
		if (n>2){
			drawTriangleRecursionReversed(n-1);
		}
		for(int rounds=n; rounds>=1;rounds--){
			System.out.print("*");
		}
		System.out.println("");
		
	}
	
	public static double HarmonicNumberRecursion(int n){
		double sum=0;
		if(n==1) return 1;
		sum=(float)1/n+(float)(1/HarmonicNumberRecursion(n-1));
		return sum;
	}
	
	public static double HarmonicNumberIteration(int k){
		double sum=0;
		for(int rounds=0;rounds<=k;rounds++){
			sum=(float)sum+(float)1/k;
		}
		return sum;
	}
	
	public static int powerN(int base,int exp){
		int product=0;
		if(exp==1) return base;
		product=base*powerN(base,exp-1);
		return product;
	}
	
	public static void Hacksaw(int n){
		for(int rounds=n;rounds>=1;rounds--){
		drawTriangleRecursion(n);
		drawTriangleRecursionReversed(n-1);
		}
		drawTriangleRecursion(n);
	}
	
	
	public static void main(String[] args) {
		//drawTriangleRecursion(3);
		//System.out.println(HarmonicNumberRecursion(2));
		//System.out.println(HarmonicNumberIteration(2));
		//System.out.println("3 to the power of 3 is: "+powerN(3,3));
	}

}
