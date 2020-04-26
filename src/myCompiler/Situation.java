package myCompiler;

import java.util.*;

public class Situation {                           //格局类
    ArrayList<Symbol> symbolstack;             //符号栈内容
	ArrayList<Token> tokenlist;                //输入流内容
	String operation;                          //操作栈内容
	
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
