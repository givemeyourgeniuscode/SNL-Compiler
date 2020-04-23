package client;
import javax.swing.*;
public class Client extends  JFrame
{
	
	JTextArea textarea ;              //�ı���
	
	/*----------------------------------------�˵����--------------------------------------------*/
	
	JMenuBar menubar;
	JMenu jmenufile ; 
	JMenu jmenuoperate ;
	JMenu jmenuhelp ;
	JMenuItem openitem ;
	JMenuItem saveitem ;
	JMenuItem lexitem ;
	JMenuItem parseitem ;
	JMenuItem helpitem ;
	
	/*----------------------------------------�˵����--------------------------------------------*/
	
	
	String[] text;
	
	
	
	
	
	
	
	
    public static void main(String args[])
    {
    	Client aclient = new Client();
    	
    	
    }
    
    
	public Client()
	{
		super("SNL -- ������");
		initialize();
	}
	
	
	
    void initialize() 
    {
        textarea = new JTextArea(); 
    	textarea.setEditable(true); 
    	super.getContentPane().add(new JScrollPane(textarea));     //�ı�����������
    	
    	/*----------------------------------------�˵���������--------------------------------------------*/
    	
    	menubar = new JMenuBar();
    	jmenufile = new JMenu("�ļ�"); 
    	jmenuoperate = new JMenu("����");
    	jmenuhelp = new JMenu("����");
    	openitem = new JMenuItem("��");
    	saveitem = new JMenuItem("����");
    	lexitem = new JMenuItem("�ʷ�����");
    	parseitem = new JMenuItem("�﷨����");
    	helpitem = new JMenuItem("�����ֲ�");
    	openitem.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.CTRL_MASK));              //���ÿ�ݼ�ctrl+o������ͬ��
    	saveitem.setAccelerator(KeyStroke.getKeyStroke('S',java.awt.Event.CTRL_MASK));
    	lexitem.setAccelerator(KeyStroke.getKeyStroke('L',java.awt.Event.CTRL_MASK));
    	parseitem.setAccelerator(KeyStroke.getKeyStroke('P',java.awt.Event.CTRL_MASK));
    	helpitem.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));                   
    	
    	jmenufile.add(openitem);                            //����ѡ������ļ��˵�������ͬ��
    	jmenufile.add(saveitem);
    	jmenuoperate.add(lexitem);
    	jmenuoperate.add(parseitem);
    	jmenuhelp.add(helpitem);         
    	
    	
    	menubar.add(jmenufile);                    //���˵�����˵���������ͬ��
    	menubar.add(jmenuoperate);
    	menubar.add(jmenuhelp);
    	super.setJMenuBar(menubar);

    	/*----------------------------------------�˵���������--------------------------------------------*/
    	
    	
    	
    	
    	/*----------------------------------------�˵��¼�����--------------------------------------------*/
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*----------------------------------------�˵��¼�����--------------------------------------------*/
    	
    	
    	super.setVisible(true); 
    	super.setSize(600, 500); 
    	super.setLocation(300, 200);
    	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	
	
    
	
}
