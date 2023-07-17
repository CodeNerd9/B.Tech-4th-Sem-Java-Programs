class obje{
    int p=1200, ci=0, r=4,t=2, n=4;

    void calculated_CI(){

        ci = (p*(1+r/n))^n*t;

        System.out.println("The Compund Interest is : "+ci);
    }
}

public class compoundInterest {
    public static void main(String args[]){

        obje ob = new obje();
        ob.calculated_CI(); //Function Call

    }
}
