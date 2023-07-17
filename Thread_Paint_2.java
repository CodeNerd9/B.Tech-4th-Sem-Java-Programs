import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class Threads extends Panel implements Runnable
{
	int x = -1, y = -1, r  =-1, N = 0;
	data_1 data[];
	int mx = -1, my = -1;
	
	public void draw(data_1 d1[], int n, int r)
	{
		this.data = d1;
		this.N = n;
		this.r = r;	
	}
	
	public void run()
	{
		int i = 0;
		
		while(i < N)
		{
//			can1.set_data((int)data[i].x, (int)data[i].y, r);
			x = (int)data[i].x;
			y = (int)data[i].y;
			repaint();
			
			try
			{
				Thread.sleep(300);
			}
			catch(InterruptedException ie){}
			i++;
		}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval(x, y, r, r);
	}
}

public class Thread_Paint_2 extends Frame 
{
//	canvas canv;
	Threads ts1;
	
	Panel p1;
	
	data_1 d[];

	int mx = -1, my = -1;
	int min_pts = -1 , N = 0, cl_id = 0, r = 50;
	double eps = -1.0, x= -1.0, y = -1.0; 
		
	public Thread_Paint_2()
	{
		setLayout(new BorderLayout());
		
		ts1 =  new Threads();
		ts1.setBackground(Color.blue);
		add(ts1, BorderLayout.CENTER);
		
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
		
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				mx = me.getX();
				my = me.getY();
			}	
		});
		
		
		Thread t1 = new Thread(ts1);
		try
		{
			int total = read_data();				
			System.out.println("Total no. of data points = " + total);
		}
		catch(IOException ioe){}
		ts1.draw( d, N, r);
		t1.start();	
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
		Thread_Paint_2 thm_2 = new Thread_Paint_2();
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