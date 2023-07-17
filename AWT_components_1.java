import java.awt.*;
import java.awt.event.*;


public class AWT_components_1 extends Frame implements ActionListener, ItemListener
{
	Label l1, l2, l3, l4, l5, l6;
	
	TextField tf1, tf2;
	
	TextArea ta1;
	
	Button b1, b2;
	
	Checkbox cb1, cb2, cb3, cb4;
	
	CheckboxGroup cbg1;
	
	String rollno = "", name = "", lang = "", gender = "", str1="", str2="", str3 = "", str4 = "", str_main = ""; 
	Panel p1, p2, p3, p4, p5, p6, p7;
	
	public AWT_components_1()
	{
		setTitle("AWT Components Demo");
		setLayout(new BorderLayout());
		
		/////// Font to be applied to awt components //////////////////
		Font myFont1 = new Font("Serif", Font.ITALIC, 20);
		Font myFont2 = new Font("Arial Black", Font.BOLD, 16);
		
		
		//// Secondary containers //////
		
		
		////////////////// Labels ////////////
		p1 = new Panel();
		p1.setBackground(Color.YELLOW);
		p2 = new Panel();
		p2.setBackground(Color.blue);
		p3 = new Panel();
		p3.setBackground(Color.yellow);
		p4 = new Panel();
		p4.setBackground(Color.cyan);
		p5 = new Panel();
		p5.setBackground(Color.green);
		p6 = new Panel();
		p6.setLayout(new BorderLayout());
		p6.setBackground(new Color(50, 120,90));
		
		p7 = new Panel();
		p7.setLayout(new GridLayout(4, 1, 5, 5)); 
		p7.setBackground(new Color(50,120,90));
		
		l1 = new Label();
		l1.setText("AWT Components Demo");
		l1.setFont(myFont1);
		
		l2 = new Label("ROll No. :: ");
		l2.setForeground(Color.white);
		l3 = new Label("Name :: ");
		l3.setForeground(Color.white);
				
		l4 = new Label("Languages Known", Label.CENTER);
		
		l5 = new Label("Gender");
		
		l6 = new Label("Report", Label.CENTER);	
		l6.setFont(myFont2);
		
		///////////////// Text Field /////////////////
		tf1 = new TextField(12);
		tf2 = new TextField(12);
		Font f  = new Font("Lucida Console", Font.PLAIN,20);
		tf1.setFont(f);
		tf1.setColumns(25);
		///////////////// Text Area /////////////////
		ta1 = new TextArea();
		ta1.setFont(myFont2);
		///////////////// Buttons /////////////////
		b1 = new Button("ok");
		b1.addActionListener(this);
		b2 = new Button();
		b2.setLabel("Reset");
		b2.addActionListener(this);
		
		/// CheckBoxes
		cb1 = new Checkbox("C++",cbg1, false);
		cb1.addItemListener(this);
		cb2 = new Checkbox("Java",cbg1, false);
		cb2.addItemListener(this);
		
		/// Radio Buttons ////////////
		cbg1 = new CheckboxGroup();
		cb3 = new Checkbox("Male",cbg1, false);
		cb3.addItemListener(this);
		cb4 = new Checkbox("Female",cbg1, false);
		cb4.addItemListener(this);
		
		p1.add(l1);
		
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(tf2);
		
		p3.add(l4);
		p3.add(cb1);
		p3.add(cb2);
		
		p4.add(l5);
		p4.add(cb3);
		p4.add(cb4);
		
		p5.add(b1);
		p5.add(b2);
		
		p6.add(l6, BorderLayout.NORTH);		
		p6.add(ta1, BorderLayout.CENTER);
		
		add(p1, BorderLayout.NORTH);
		p7.add(p2);
		p7.add(p4);
		p7.add(p3);	
		p7.add(p5);
		add(p7, BorderLayout.CENTER);
		add(p6, BorderLayout.SOUTH);

		setSize(430, 500);
		setVisible(true);
		setResizable(false);
	}
	
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource() == cb1)
		{
			str1 = cb1.getLabel();
		}
		if(ie.getSource() == cb2)
		{
			str2 = cb2.getLabel();
		}
		if(ie.getSource() == cb3)
		{
			str3 = cb3.getLabel();
		}
		if(ie.getSource() == cb4)
		{
			str4 = cb4.getLabel();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			rollno = tf1.getText();
			name = tf2.getText();
			
			str_main = str_main + "\n" + rollno + "\n" + name;
			
			
			if(!str1.equals(""))
			{
				str_main = str_main + "\n" + str1;
			}
			if(!str2.equals(""))
			{
				str_main = str_main + "\n" + str2;
			}
			if(!str3.equals(""))
			{
				str_main = str_main + "\n" + str3;
			}
			if(!str4.equals(""))
			{
				str_main = str_main + "\n" + str1;
			}
			
			ta1.setText(str_main);
		}
		if(ae.getSource() == b2)
		{
			tf1.setText("");
			tf2.setText("");
		}
	}
	
	public static void main(String args[])
	{
		AWT_components_1 awt_c_1 = new AWT_components_1();
	}
}