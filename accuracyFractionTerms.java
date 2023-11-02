
public class accuracyFractionTerms {

	public static int FindTerms(int SearchedNumber, double sum,int terms,double accuracyLowerBound,double accuracyUpperBound){
		int k=-1;
		System.out.println("term: "+terms);
		System.out.println("rest: "+terms%2);
		if(terms%2!=0)k=1;
		sum = sum+(float)(k*1)/terms;
		System.out.println(sum);
		if(accuracyLowerBound<sum&&sum<accuracyUpperBound){
			return terms;
		}
		else return FindTerms(SearchedNumber,sum,terms+1,SearchedNumber*0.95,SearchedNumber*1.05);
	}
	public static void main(String[] args) {
		int SearchedNumber=2;
		FindTerms(SearchedNumber,0,1,SearchedNumber*0.95,SearchedNumber*1.05);
	}

}
