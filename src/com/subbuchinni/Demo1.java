package com.subbuchinni;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo1 {
	
	private static String AbsolutePath = new File("").getAbsolutePath();
	@BeforeTest
	public void Demo(String [] args)
	{
		System.out.println("Demo1");
		
		System.out.println("pathis--"+AbsolutePath);
		
	}

}
