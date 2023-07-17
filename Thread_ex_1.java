import java.io.*;

public class Thread_ex_1
{
	public Thread_ex_1()
	{
		Threads ts1 = new Threads();
		Thread t1 = new Thread(ts1);
		t1.start();
	}
	
	public static void main(String args[])
	{
		Thread_ex_1 thex1 = new Thread_ex_1();
	}
}

class Threads implements Runnable
{
	public void run()
	{
		for(int i=0; i<5; i++)
		{
			try
			{
				System.out.println(i + " ");
				Thread.sleep(500);
			}
			catch(InterruptedException ie)
			{
				
			}

		}
	}
}