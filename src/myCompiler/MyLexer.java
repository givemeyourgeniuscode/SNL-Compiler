package myCompiler;

import java.util.*;

public class MyLexer {

	String codetext;                           //Դ�ı�
	ArrayList<String> afterfilter ;           //�ı����˺�ĵ���
	ArrayList<Token> tokenlist = null ;           //token����
	boolean ifpass ;                             //�Ƿ�ͨ���ʷ����
	public MyLexer(String codetext)
	{
		this.codetext = codetext;
		
		
	}
	
	public String printTokenList()                //���ط������
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
	public String falseinfo()                       //���ش�����Ϣ
	{
		String falseinfo = null;
		return falseinfo;
		
	}
	
	public boolean ifpass()               
	{
		return ifpass;
	} 
}
