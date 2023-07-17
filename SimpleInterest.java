
class laura{
	int n=2;
	double p=100, r=10, si=0;
	 
	void calculated_SI()
	{
		si= (p*r*n)/100;
		System.out.println("Simple Interest = "+si);
	}
}	
	public class SimpleInterest{
		
			public static void main(String args[]){
				
				laura co1=new laura();
				co1.calculated_SI(); 
			}
		}
