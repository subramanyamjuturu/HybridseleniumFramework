package com.subbuchinni.Scripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.subbuchinni.Scripts.*;

public class CommonClass {
	
	Executioner e= new Executioner();
	ExcelOperations exceloper =new ExcelOperations();
	
	public static String hostDetails ;
	public static String browserDetails ;
	public String suitDetails ;
	public String testNameDetails ;
	public String strDataSourceDetails;

	public void executeMultiScripts(String host,String browser,String suit,String testName,String strDataSource) throws Exception 
	{
		 hostDetails =host;
		 browserDetails =browser;
		 suitDetails = suit;
		 testNameDetails = testName;
		 strDataSourceDetails =strDataSource;
		 
		 setExecutionDetails();
		//exceloper.masterconfigData();
		
		exceloper.setExcelFile(e.strDataPath,"ClassPackageDetails");
		
	}
	
	public String setExecutionDetails()
	{
		String ExecutionDetails=null;
		
		ExecutionDetails=hostDetails+"@@@"+browserDetails+"@@@"+suitDetails+"@@@"+testNameDetails+"@@@"+strDataSourceDetails;
		
		return ExecutionDetails;
	}
}
