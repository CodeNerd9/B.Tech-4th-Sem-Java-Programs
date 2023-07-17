/*synchronized static return_type method_name (Parameters) 
{
//code
}
Or 
synchronized static return_type method_name (Class_name.class) 
{
//code
}
*/

class Power
{  
synchronized static void printPower(int n)			//static synchronized method
{ 
	int temp = 1;
	for(int i=1;i<=5;i++)
	{ 
		System.out.println(Thread.currentThread().getName() + ":- " +n + "^"+ i + " value: " + n*temp);
		temp = n*temp;
		try
		{  
			Thread.sleep(400);  
		}
		catch(Exception e){}  
		}  
	}  
}    
class Thread1 extends Thread
{  
	Power p;  
	
	Thread1(Power p)
	{  
		this.p=p;  
	}  
	public void run()
	{  
		p.printPower(2);  
	}  
}

class Thread2 extends Thread
{  
	Power p;
	  
	Thread2(Power p)
	{  
		this.p=p;  
	}  
	public void run()
	{  
		p.printPower(3);  
	} 
}  

class Thread3 extends Thread
{  
	Power p;  
	Thread3(Power p)
	{  
		this.p=p;  
	}  
	public void run()
	{  
		p.printPower(5);  
	}  
} 

class Thread4 extends Thread
{ 
	Power p;
	  
	Thread4(Power p)
	{  
		this.p=p;  
	}  
	public void run()
	{  
		p.printPower(8);  
	}  
} 

public class Thread_sync_3
{  
	public static void main(String args[])
	{ 
		Power ob1 = new Power(); 				//first object
		Power ob2 = new Power(); 				//second object
		Thread1 p1 = new Thread1(ob1);  
		Thread2 p2 = new Thread2(ob1); 
		Thread3 p3 = new Thread3(ob2);
		Thread4 p4 = new Thread4(ob2);
		
		p1.start();  
		p2.start();
		p3.start();
		p4.start();
	}  
}