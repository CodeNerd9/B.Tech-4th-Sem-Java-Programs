import javax.swing.*;
public class JOP_Example_1 
{
   public static void main(String[] args) 
   {
      JFrame frame = new JFrame("JoptionPane Example");
      frame.setSize(200, 200);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
      JOptionPane.showMessageDialog(frame, "Java Programming");
      JOptionPane.showMessageDialog(frame, "JOptionPane Examples","Apocalyptic message", JOptionPane.WARNING_MESSAGE);
      int result = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
      
      switch (result) 
      {
         case JOptionPane.YES_OPTION:
         	System.out.println("Yes");
         	break;
         case JOptionPane.NO_OPTION:
         	System.out.println("No");
         	break;
         case JOptionPane.CANCEL_OPTION:
         	System.out.println("Cancel");
         	break;
         case JOptionPane.CLOSED_OPTION:
         	System.out.println("Closed");
         	break;
      }
      String name = JOptionPane.showInputDialog(null, "Please enter your name.");
      System.out.println(name);
      
      JTextField userField = new JTextField();
      JPasswordField passField = new JPasswordField();
      
      String message = "Please enter your user name and password.";
      result = JOptionPane.showOptionDialog(frame, new Object[] {message, userField, passField},
      "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
      
      if (result == JOptionPane.OK_OPTION)
      	System.out.println(userField.getText() + " " + new String(passField.getPassword()));
      System.exit(0);
   }
}