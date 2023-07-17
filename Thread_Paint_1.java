import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class canvas extends JPanel
{
	int x = -1, y = -1, r  =-1;
	
	public canvas()
	{
		setBackground(Color.BLUE);
	}
	
	public void set_data(int x, int y, int r)
	{
		this.x = x;
		this.y = y;
		this.r = r;
		
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillOval(x, y, r, r);
	}
}


class Threads extends Thread
{
	canvas can1;
	int r  =-1, N = 0;
	data_1 data[];
	
	public void draw(canvas canv_1, data_1 d1[], int n, int r)
	{
		this.can1 = canv_1;	
		this.data = d1;
		this.N = n;
		this.r = r;	
	}
	
	public void run()
	{
		int i = 0;
		
		while(i < 1000)
		{
			can1.set_data((int)data[i].x, (int)data[i].y, r);
			
			try
			{
				sleep(10);
			}
			catch(InterruptedException ie){}
			i++;
		}
	}
}

public class Thread_Paint_1 extends Frame
{
	canvas canv;
	Threads ts1;
	
	data_1 d[];

	int min_pts = -1 , N = 0, cl_id = 0, r = 10;
	double eps = -1.0, x= -1.0, y = -1.0; 
		
	public Thread_Paint_1()
	{
		setLayout(new BorderLayout());
		
		canv = new canvas();
		add(canv, BorderLayout.CENTER);
		
		setSize(800, 700);
		setVisible(true);
		
		addWindowListener(new WindowAdapter()
		{ 
			public void windowClosing(WindowEvent we)
			{
				dispose();
				System.exit(0);
			}
		});
		
		ts1 =  new Threads();
		try
		{
			int total = read_data();				
			System.out.println("Total no. of data points = " + total);
		}
		catch(IOException ioe){}
		ts1.draw(canv, d, N, r);
		ts1.start();
		
	}
	
	public int read_data() throws IOException
	{
		StringTokenizer st1;
		FileReader fr = new FileReader("t4.8k.dat");
        BufferedReader br = new BufferedReader(fr);
        int obj = 0;
        
        try
        {
        	String line = "";
 
	        while((line = br.readLine()) != null) 
	        {
	        	obj++; 
	        }
        }
        catch(Exception e){}
        
        br.close();
        fr.close();
        
        N = obj;
        d = new data_1[obj];
        
        for(int n= 0; n < obj; n++)
        {
        	d[n] = new data_1();
        }
        
        fr = new FileReader("t4.8k.dat");
        br = new BufferedReader(fr);
        int i = 0;
        
        try
        {
        	String line = "";
 
	        while((line = br.readLine()) != null) 
	        {
				st1 = new StringTokenizer(line.trim(), " ");
				int j = 0;
				
	        	while(st1.hasMoreTokens())
	        	{
	        		if(j==0)
	        		{
	        			x = Double.parseDouble(st1.nextToken().trim());
	        			d[i].x = x;
	        		}
	        		if(j == 1)
	        		{
	        			y = Double.parseDouble(st1.nextToken().trim());
	        			d[i].y = y;
	        		}
	        			
	        		j++;
	        	}
	       // 	System.out.println("Object no : " + i + ", x = " + d[i].x + " y = " + d[i].y) ;
	        	i++; 
	        }
        }
        catch(Exception e){}
        
        System.out.println("Totl no. of objects = " + obj);
        
        return i;
	}
	
	public void initialize()
	{
		cl_id = 0;
		for(int n= 0; n < N; n++)
        {
        	d[n].no_neighbors = 0;
        	d[n].core = -1;
        	d[n].cl_id = -1;
        }
	}
	
	public static void main(String args[])
	{
		Thread_Paint_1 thm_1 = new Thread_Paint_1();
	}
}

class data_1
{
	double x, y;
	int core;
	int no_neighbors;
	int cl_id;
	
	public data_1()
	{
		x = -1.0;
    	y = -1.0;
    	no_neighbors = 0;
    	core = -1;
    	cl_id = -1;
	}	
}