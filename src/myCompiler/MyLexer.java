package myCompiler;

import java.util.*;

public class MyLexer {

	String codetext;                           //源文本
	ArrayList<String> afterfilter ;           //文本过滤后的单词
	ArrayList<Token> tokenlist = null ;           //token序列
	boolean ifpass ;                             //是否通过词法检查
	public MyLexer(String codetext)
	{
		this.codetext = codetext;
		
		
	}
	
	public String printTokenList()                //返回分析结果
	{
		String tokenlist = null;
			return tokenlist;
	}
	
	public ArrayList<Token> getTokenList()          
	{
		return tokenlist ;
	}
	
	void filter()                                    
	{
		
		
	}
	
	void lexerAnalyse()
	{
		
	}
	public String falseinfo()                       //返回错误信息
	{
		String falseinfo = null;
		return falseinfo;
		
	}
	
	public boolean ifpass()               
	{
		return ifpass;
	} 
}
