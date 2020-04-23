package client;
import javax.swing.*;
public class Client extends  JFrame
{
	
	JTextArea textarea ;              //文本域
	
	/*----------------------------------------菜单组件--------------------------------------------*/
	
	JMenuBar menubar;
	JMenu jmenufile ; 
	JMenu jmenuoperate ;
	JMenu jmenuhelp ;
	JMenuItem openitem ;
	JMenuItem saveitem ;
	JMenuItem lexitem ;
	JMenuItem parseitem ;
	JMenuItem helpitem ;
	
	/*----------------------------------------菜单组件--------------------------------------------*/
	
	
	String[] text;
	
	
	
	
	
	
	
	
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
    	openitem = new JMenuItem("打开");
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
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*----------------------------------------菜单事件设置--------------------------------------------*/
    	
    	
    	super.setVisible(true); 
    	super.setSize(600, 500); 
    	super.setLocation(300, 200);
    	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	
	
    
	
}
