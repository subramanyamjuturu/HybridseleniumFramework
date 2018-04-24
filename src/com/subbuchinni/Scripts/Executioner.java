package com.subbuchinni.Scripts;
import java.io.*;

public class Executioner {
	
	public static String ExecutionStartTime =null;
	public static String ExecutionEndTime =null;
	public static float TotalExecutionTime =0;
	public static String strExecutionBrowser=null;
	
	public static String strAbsolutePath =new File("").getAbsolutePath();
	public static  String strDataPath = strAbsolutePath+"\\data";
	private static boolean isPassed =false;
	
	 public static CommonClass executor =new CommonClass();
	
	public static boolean getExecutionFlag(){
		return isPassed;
	}
	
	public void setExecutionBrowser(String strExecutionBrowser)
	{
		strExecutionBrowser =this.strExecutionBrowser;
	}

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
		
		System.out.println("main Method");
		
		//executor.getDriver(args[1]);
		
		
		
		executor.executeMultiScripts(args[0],args[1],args[2],args[3],args[4]);
		
		
		
		

	}

}
