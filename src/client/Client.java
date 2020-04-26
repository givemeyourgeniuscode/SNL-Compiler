package client;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import myCompiler.*;

public class Client extends  JFrame
{
	String codetext = null;                       //源码内容
	File codefile = null;                   //源码文件
	MyLexer alexer;                         //词法分析器
	MyParser aparser;                       //语法分析器
	
	
	/*----------------------------------------图形组件--------------------------------------------*/
	
	JTextArea textarea ;              //文本域
	JFileChooser fc = new JFileChooser();    //文件选择器
	
	
	JMenuBar menubar;                  //菜单组件
	JMenu jmenufile ; 
	JMenu jmenuoperate ;
	JMenu jmenuhelp ;
	JMenuItem openitem ;
	JMenuItem saveitem ;
	JMenuItem lexitem ;
	JMenuItem parseitem ;
	JMenuItem helpitem ;
	
	/*----------------------------------------图形组件--------------------------------------------*/
	
	

	
	
	
	
	
	
	
	
    public static void main(String args[])
    {
    	Client aclient = new Client();
    	
    	
    }
    
    
	public Client()
	{
		super("SNL -- 编译器");
		initialize();
	}
	
	
	
    void initialize() 
    {
          	
    	textarea = new JTextArea(); 
    	textarea.setEditable(true); 
    	super.getContentPane().add(new JScrollPane(textarea));     //文本域加入滚动条
    	
    	/*----------------------------------------菜单布局设置--------------------------------------------*/
    	
    	menubar = new JMenuBar();
    	jmenufile = new JMenu("文件"); 
    	jmenuoperate = new JMenu("操作");
    	jmenuhelp = new JMenu("帮助");
    	openitem = new JMenuItem("打开...");
    	saveitem = new JMenuItem("保存");
    	lexitem = new JMenuItem("词法分析");
    	parseitem = new JMenuItem("语法分析");
    	helpitem = new JMenuItem("帮助手册");
    	openitem.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.CTRL_MASK));              //设置快捷键ctrl+o，以下同理
    	saveitem.setAccelerator(KeyStroke.getKeyStroke('S',java.awt.Event.CTRL_MASK));
    	lexitem.setAccelerator(KeyStroke.getKeyStroke('L',java.awt.Event.CTRL_MASK));
    	parseitem.setAccelerator(KeyStroke.getKeyStroke('P',java.awt.Event.CTRL_MASK));
    	helpitem.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));                   
    	
    	jmenufile.add(openitem);                            //将打开选项加入文件菜单，以下同理
    	jmenufile.add(saveitem);
    	jmenuoperate.add(lexitem);
    	jmenuoperate.add(parseitem);
    	jmenuhelp.add(helpitem);         
    	
    	
    	menubar.add(jmenufile);                    //将菜单加入菜单栏，以下同理
    	menubar.add(jmenuoperate);
    	menubar.add(jmenuhelp);
    	super.setJMenuBar(menubar);

    	/*----------------------------------------菜单布局设置--------------------------------------------*/
    	
    	
    	
    	
    	/*----------------------------------------菜单事件设置--------------------------------------------*/
    	
    	
    	openitem.addActionListener(new ActionListener(){                   //打开文件目录，导入源代码
    		public void actionPerformed(ActionEvent e){
    			fc.setDialogTitle("打开文件");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.showOpenDialog(openitem);                             //导航窗显示在父组件 “打开” 周围
				codefile = fc.getSelectedFile();
				if(codefile!=null)                                        //如果没有选择文件不操作，否则进入循环体，导入文件内容
				{
				   FileReader fr;
				   StringBuilder context = new StringBuilder();
				   try {
					    fr = new FileReader(codefile);
					    int c = 0;
					    while((c = fr.read()) != -1)
					   {
						   context.append((char)c);
					   }
					   fr.close();
				   }catch (IOException ex) {
					System.out.println("文件读取错误");
				   }
				
				   codetext = new String(context);
				   textarea.setText(codetext);
				}				
    			
    		}}) ;         
    	
    	
    	saveitem.addActionListener(new ActionListener(){                 //将输入内容存入新建的文件
    		public void actionPerformed(ActionEvent e){
    			String parent = "F:\\1university\\大三下\\编译原理\\课设\\SNL-Compiler\\";               //此处改为自己电脑的存储路径
    			String child = "code.txt";
    			File newfile = new File(parent,child);     			
				FileWriter fw;
				try {
				fw = new FileWriter(newfile);
				fw.write(textarea.getText());
				fw.flush();
				fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    			    			
    		}}) ;
    	
    	lexitem.addActionListener(new ActionListener(){                  //词法分析
    		public void actionPerformed(ActionEvent e){
    		     
    			 alexer = new MyLexer(codetext);
    		     JFrame newframe = new JFrame("词法分析结果");
		    	 JTextArea area = new JTextArea();
    			 area.setText(alexer.printTokenList()+"错误信息："+alexer.falseinfo());          //将分析结果和错误信息打印在文本域
    			 area.setEditable(false);
    			 newframe.add(area);
    			 newframe.setVisible(true); 
    		     newframe.setSize(400, 300); 
    		     newframe.setLocation(300, 100);
    			 
    		}}) ;
    	
    	parseitem.addActionListener(new ActionListener(){                 //语法分析
    		public void actionPerformed(ActionEvent e){
    		      alexer = new MyLexer(codetext);
    		      if(!(alexer.ifpass()))                                  //如果词法分析没过
    		      {
    		    	  JFrame newframe = new JFrame("提示");
    		    	  JTextField field = new JTextField();
    		    	  field.setEditable(false);
    		    	  newframe.add(field);
    		    	  field.setText("词法分析有误，先通过词法分析");
    		    	  newframe.setVisible(true); 
    	    		  newframe.setSize(400, 300); 
    	    		  newframe.setLocation(300, 100);
    		      }
    		      else                                                      //进行语法分析
    		      {
    		    	  MyParser aparser = new MyParser(alexer.getTokenList());
    		    	  JFrame newframe = new JFrame("语法分析结果");
    		    	  JTextArea area = new JTextArea();
    		    	  area.setEditable(false);
    		    	  newframe.add(area);
    		    	  area.setText(aparser.printsituation()+"错误信息："+aparser.printfalseinfo());
    		    	  newframe.setVisible(true); 
    	    		  newframe.setSize(400, 300); 
    	    		  newframe.setLocation(300, 100);
    		      }
    			
    		}}) ;
    	
    	helpitem.addActionListener(new ActionListener(){              //帮助手册
    		public void actionPerformed(ActionEvent e){
    		    JFrame newframe = new JFrame("帮助手册");  
    		     JTextArea newarea = new JTextArea(); 
    		     String help = new String("帮助手册");
    		     newarea.setText(help);  		     
    	    	 newarea.setEditable(false); 
    		     newframe.add(newarea);
    			 newframe.setVisible(true);
    			 newframe.setLocation(700, 200);
    			 newframe.setSize(600,500); 
    		}}) ;
    	
    	
    	
    	/*----------------------------------------菜单事件设置--------------------------------------------*/
    	
    	
    	super.setVisible(true); 
    	super.setSize(1200, 800); 
    	super.setLocation(300, 100);
    	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }   
	
}
