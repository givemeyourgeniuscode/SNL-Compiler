package myCompiler;

import java.util.*;

public class MyParser {

	ArrayList<Token> tokenlist = null;                      //token序列
    ArrayList<ArrayList<Symbol>> production = null;          //产生式
    ArrayList<Symbol> predict = null;                   //predict集
    Stack<Symbol> symbolstack = null;                      //符号栈
    Stack<String> operatestack = null;                 //操作栈
	ArrayList<Situation> situation = null;              //格局数组
    public MyParser(ArrayList<Token> tokenlist )
	{
		this.tokenlist = tokenlist;
				
	}
    void initialize()                         //设置产生式和predict集
    {
    	
    }
	void parseranalyse()                     //语法分析过程
	{
		
		
	}
	
	public String printsituation() 
	{
		String content = null;
		return content ;
		
		
	}
	
	public String printfalseinfo()      //打印错误信息
	{
		String falseinfo = null;
		return falseinfo ;
	}
	
	
}
