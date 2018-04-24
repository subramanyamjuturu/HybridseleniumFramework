package com.subbuchinni.MainScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.subbuchinni.Scripts.*;

public class SecondPractice {
	
	//WebDriver driver = null;
	
	String thread=null;
	 RemoteWebDriver webDriver=null;
	
	ScriptExecuter scriptexecuter =new ScriptExecuter();
	ResultsClass report = new ResultsClass();
	ExcelOperations fileoperations = new ExcelOperations();
	ActionsOperations actions = new ActionsOperations();
	Verification verify=new Verification();
	String DataSheetName= fileoperations.CurrentFileName;
	String MethodName;
	
	public SecondPractice(String thread)
	{
		
		scriptexecuter.CreateDriver();
		
		System.out.println("ConstructorEXE");
		CreateDriver driver =new CreateDriver();
		this.webDriver=driver.getDriver(thread);
		scriptexecuter.webDriver=this.webDriver;
		//actions.driver=this.webDriver;;
		this.thread=thread;
		
	}
	
	public  void SecondPracticeDemo1() throws FileNotFoundException, IOException{
		
		scriptexecuter.storeObjectProperteyValues();
		
		scriptexecuter.storeObjectProperties();
		
		
		System.out.println(scriptexecuter.Objpropertey.get("abc"));
		
		System.out.println(scriptexecuter.ObjproperteyValue.get("abc"));
		System.out.println("Executing our mathod");
		try{
			MethodName = fileoperations.MethodName;
			Map<String,String> data =fileoperations.readData(fileoperations.CurrentFileName, fileoperations.MethodName, fileoperations.currentExecutionRowNumber);
			System.out.println(webDriver);
			
			System.out.println(thread);
			
			//webDriver.get("https://www.google.co.in");
			
			actions.browserLaunch(data.get("URL_Data"), webDriver);
			
			actions.enterText("googleSearchBox", "googleSearchBox", data.get("SearchData1_Data"),webDriver);
			
			actions.Click("InitialsearchButtongoogle", "InitialsearchButtongoogle", "Search Button", webDriver);
			
			verify.verifyText("googleSearchBox", "googleSearchBox", data.get("SearchData1_Data"), webDriver);
			
			report.FinalResultWrite(fileoperations.TempResultFile);
			report.InsertOverallStatus(fileoperations.TempResultFile);
		}catch(Exception e)
		{
			report.InsertOverallStatus(fileoperations.TempResultFile,"Not Completed");
			System.out.println(e.getMessage());
			
			System.out.println(e.getStackTrace());
			
			System.out.println(e.getCause());
		}
	
		
		//webDriver.findElementById("lst-ib").sendKeys("can i");
		
		
	}
	
	public  void SecondPracticeDemo2() throws IOException{
		
		System.out.println("Executing our 2nd method");
		
			
			System.out.println(thread);
		
			webDriver.get("https://accounts.google.com/signin");
			
			report.InsertOverallStatus(fileoperations.TempResultFile);
	
		
	}

}
