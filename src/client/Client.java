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
	String codetext = null;                       //Դ������
	File codefile = null;                   //Դ���ļ�
	MyLexer alexer;                         //�ʷ�������
	MyParser aparser;                       //�﷨������
	
	
	/*----------------------------------------ͼ�����--------------------------------------------*/
	
	JTextArea textarea ;              //�ı���
	JFileChooser fc = new JFileChooser();    //�ļ�ѡ����
	
	
	JMenuBar menubar;                  //�˵����
	JMenu jmenufile ; 
	JMenu jmenuoperate ;
	JMenu jmenuhelp ;
	JMenuItem openitem ;
	JMenuItem saveitem ;
	JMenuItem lexitem ;
	JMenuItem parseitem ;
	JMenuItem helpitem ;
	
	/*----------------------------------------ͼ�����--------------------------------------------*/
	
	

	
	
	
	
	
	
	
	
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
    	openitem = new JMenuItem("��...");
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
    	
    	
    	openitem.addActionListener(new ActionListener(){                   //���ļ�Ŀ¼������Դ����
    		public void actionPerformed(ActionEvent e){
    			fc.setDialogTitle("���ļ�");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.showOpenDialog(openitem);                             //��������ʾ�ڸ���� ���򿪡� ��Χ
				codefile = fc.getSelectedFile();
				if(codefile!=null)                                        //���û��ѡ���ļ����������������ѭ���壬�����ļ�����
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
					System.out.println("�ļ���ȡ����");
				   }
				
				   codetext = new String(context);
				   textarea.setText(codetext);
				}				
    			
    		}}) ;         
    	
    	
    	saveitem.addActionListener(new ActionListener(){                 //���������ݴ����½����ļ�
    		public void actionPerformed(ActionEvent e){
    			String parent = "F:\\1university\\������\\����ԭ��\\����\\SNL-Compiler\\";               //�˴���Ϊ�Լ����ԵĴ洢·��
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
    	
    	lexitem.addActionListener(new ActionListener(){                  //�ʷ�����
    		public void actionPerformed(ActionEvent e){
    		     
    			 alexer = new MyLexer(codetext);
    		     JFrame newframe = new JFrame("�ʷ��������");
		    	 JTextArea area = new JTextArea();
    			 area.setText(alexer.printTokenList()+"������Ϣ��"+alexer.falseinfo());          //����������ʹ�����Ϣ��ӡ���ı���
    			 area.setEditable(false);
    			 newframe.add(area);
    			 newframe.setVisible(true); 
    		     newframe.setSize(400, 300); 
    		     newframe.setLocation(300, 100);
    			 
    		}}) ;
    	
    	parseitem.addActionListener(new ActionListener(){                 //�﷨����
    		public void actionPerformed(ActionEvent e){
    		      alexer = new MyLexer(codetext);
    		      if(!(alexer.ifpass()))                                  //����ʷ�����û��
    		      {
    		    	  JFrame newframe = new JFrame("��ʾ");
    		    	  JTextField field = new JTextField();
    		    	  field.setEditable(false);
    		    	  newframe.add(field);
    		    	  field.setText("�ʷ�����������ͨ���ʷ�����");
    		    	  newframe.setVisible(true); 
    	    		  newframe.setSize(400, 300); 
    	    		  newframe.setLocation(300, 100);
    		      }
    		      else                                                      //�����﷨����
    		      {
    		    	  MyParser aparser = new MyParser(alexer.getTokenList());
    		    	  JFrame newframe = new JFrame("�﷨�������");
    		    	  JTextArea area = new JTextArea();
    		    	  area.setEditable(false);
    		    	  newframe.add(area);
    		    	  area.setText(aparser.printsituation()+"������Ϣ��"+aparser.printfalseinfo());
    		    	  newframe.setVisible(true); 
    	    		  newframe.setSize(400, 300); 
    	    		  newframe.setLocation(300, 100);
    		      }
    			
    		}}) ;
    	
    	helpitem.addActionListener(new ActionListener(){              //�����ֲ�
    		public void actionPerformed(ActionEvent e){
    		    JFrame newframe = new JFrame("�����ֲ�");  
    		     JTextArea newarea = new JTextArea(); 
    		     String help = new String("�����ֲ�");
    		     newarea.setText(help);  		     
    	    	 newarea.setEditable(false); 
    		     newframe.add(newarea);
    			 newframe.setVisible(true);
    			 newframe.setLocation(700, 200);
    			 newframe.setSize(600,500); 
    		}}) ;
    	
    	
    	
    	/*----------------------------------------�˵��¼�����--------------------------------------------*/
    	
    	
    	super.setVisible(true); 
    	super.setSize(1200, 800); 
    	super.setLocation(300, 100);
    	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }   
	
}
