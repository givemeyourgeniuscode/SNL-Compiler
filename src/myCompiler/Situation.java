package myCompiler;

import java.util.*;

public class Situation {                           //�����
    ArrayList<Symbol> symbolstack;             //����ջ����
	ArrayList<Token> tokenlist;                //����������
	String operation;                          //����ջ����
	
	public Situation( ArrayList<Symbol> symbolstack,ArrayList<Token> tokenlist,String operation ) 
	{
		this.symbolstack = symbolstack;
		this.tokenlist = tokenlist;
		this.operation = operation;
	}
	
	String getsituation() 
	{
		String getsituation = null;
		return getsituation;
		
	}
	
}
