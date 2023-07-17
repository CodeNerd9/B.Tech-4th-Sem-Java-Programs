import java.awt.*;
import java.awt.event.*;

class Bouncing_Balls extends Frame 
{
	int x1 = 40, y1 = 200;			// initializing co-ordinates
	int x2 = 400, y2 = 200;			// initializing co-ordinates
	int t = 4, flag = 0, s1 = 0, s2 = 400;

	Thread th;

	Bouncing_Balls()
	{
		setSize(700, 400);
		setVisible(true);
		
		th = new Thread(new Thread() 		// Creating a new Thread
		{
			public void run()
			{
				while (true) 
				{
					if(x1 < (x2 - 40) )
					{
						x1 += t;
						x2 -= t;
						s1 += 4; 
					}
					else
					{
						flag = 1;
					}

					try 
					{
						this.sleep(50);
					}
					catch (Exception E) 
					{}
					
					repaint();
				}
			}
		});
		th.start();
	}

	public void paint(Graphics g)
	{
		if(flag == 1)
		{
			g.setColor(Color.red);
			g.fillOval(x1+10, y1-10, 20, 70);
			g.setColor(Color.blue);
			g.fillOval(x2-10, y2-10, 20, 70);

		}
		else
		{
			g.setColor(Color.red);
			g.fillOval(x1, y1, 40, 40);
			g.setColor(Color.blue);
			g.fillOval(x2, y2, 40, 40);
		//	g.fillRect(50, 220, s1, 4);
			s1 += 4;
		}
	}
	
	public static void main(String[] args)
	{
		Bouncing_Balls B = new Bouncing_Balls();
	}
}
