import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JDialog_1
{
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run()
			{
				new A();
			}
		});

	}//Closing the main method
}//Closing the class Combo


class A implements ActionListener
{
	JFrame jf;
	JLabel label1;
	JTextField field1;
	JButton button1, button2, button3;
	JDialog d1, d2, d3;

	public A()
	{
		jf = new JFrame("JDialog");
		button1 = new JButton("Modal JDialog");
		button2 = new JButton("Modeless JDialog");
	
		label1 = new JLabel("Click on any of the buttons for a surprise");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		jf.add(label1);
		jf.add(button1);
		jf.add(button2);
		
		
		jf.pack();
		
		jf.setLayout(new FlowLayout());
		jf.setSize(330,250);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Modal JDialog"))
		{
			//Creating a non-modeless blocking JDialog
			d1= new JDialog(jf,"Modal Dialog",true);
			JLabel label= new JLabel("You first need to close this dialog window to continue");
			d1.add(label);
			d1.pack();
			d1.setLocationRelativeTo(jf);
			d1.setLocation(new Point(100,100));
			d1.setSize(320,200);
			d1.setVisible(true);
		}

		if(ae.getActionCommand().equals("Modeless JDialog"))
		{
			//Creating a modeless JDialog which doesn't block the 
			d2= new JDialog(jf,"Modeless Dialog");
			JLabel label= new JLabel("You don't have to close this dialog window to continue");
			d2.add(label);
			
			d2.pack();
			d2.setLocationRelativeTo(jf);
			d2.setLocation(new Point(100,100));
			d2.setSize(320,200);
			d2.setVisible(true);
		}
	}

}