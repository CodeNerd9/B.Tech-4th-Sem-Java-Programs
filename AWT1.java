import java.awt.Frame;
import java.awt.*;

public class AWT1 extends Frame{
 
    public AWT1()
    {
        setTitle("AWT EXAMPLE 1: Frame");
        setSize(500,300);

    }
    public static void main(String[]args){
        AWT1 aw= new AWT1();
        aw.setLocation(200,200);
        aw.setVisible(true);
    }
}