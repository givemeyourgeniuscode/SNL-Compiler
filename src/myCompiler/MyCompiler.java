package myCompiler;
import java.awt.*;
import javax.swing.*;

public class MyCompiler extends JFrame
{
	JButton b1=new JButton("Commit");
    JTextField t1=new JTextField(10000);
    JLabel l1=new JLabel("分析结果");
    JLabel l2=new JLabel("语法树");
    MyLexer  alexer= new MyLexer();
    MyParser aparser= new MyParser();
    
    MyCompiler()
    {
       super("SNL-Compiler");	
       super.add(b1);
       super.add(t1);
       super.add(l1);
       super.add(l2);
       b1.setBounds(1200, 1000, 300, 200);
       l1.setBounds(0, 1000, 1200, 200);
       l2.setBounds(1000, 0, 500, 1000);
       t1.setBounds(250, 0, 1000, 1000);
       super.setSize(1500,1000);
	   super.setLocation(200,50);
	   super.setVisible(true);
	   super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public static void main(String args[]) 
    {
    	MyCompiler acopmiler= new MyCompiler();
		
		return;
    	
    }
	
   	
   	
   	
   	
}
