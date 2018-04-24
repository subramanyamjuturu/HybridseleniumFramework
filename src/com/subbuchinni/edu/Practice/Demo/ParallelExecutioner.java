package com.subbuchinni.edu.Practice.Demo;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.subbuchinni.Scripts.*;

public class ParallelExecutioner {
	
	
	@Parameters({"host","browser","packageName","testName","dataSource"})
	
	//private static String AbsolutePath = new File("").getAbsolutePath();
	@Test
	public synchronized void executer(String host,String browser,String suit,String testName,String strDataSource) throws Exception
	{
		String [] parameters = {host,browser,suit,testName,strDataSource};
		
		Executioner.main(parameters);
	}
	public  void Dummy()
	{
		System.out.println("Dummy");
		
		//System.out.println("pathis--"+AbsolutePath);7
	}
	public static void main(String[] args)
	{
		System.out.println("Main");
		
		//System.out.println("pathis--"+AbsolutePath);
	}

}
