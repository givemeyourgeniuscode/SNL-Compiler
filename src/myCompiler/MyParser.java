package myCompiler;

import java.util.*;

public class MyParser {

	ArrayList<Token> tokenlist = null;                      //token����
    ArrayList<ArrayList<Symbol>> production = null;          //����ʽ
    ArrayList<Symbol> predict = null;                   //predict��
    Stack<Symbol> symbolstack = null;                      //����ջ
    Stack<String> operatestack = null;                 //����ջ
	ArrayList<Situation> situation = null;              //�������
    public MyParser(ArrayList<Token> tokenlist )
	{
		this.tokenlist = tokenlist;
				
	}
    void initialize()                         //���ò���ʽ��predict��
    {
    	
    }
	void parseranalyse()                     //�﷨��������
	{
		
		
	}
	
	public String printsituation() 
	{
		String content = null;
		return content ;
		
		
	}
	
	public String printfalseinfo()      //��ӡ������Ϣ
	{
		String falseinfo = null;
		return falseinfo ;
	}
	
	
}
