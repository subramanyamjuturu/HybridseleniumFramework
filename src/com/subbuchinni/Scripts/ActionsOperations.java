package com.subbuchinni.Scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.subbuchinni.Scripts.*;



public class ActionsOperations {

	ScriptExecuter scriptexecuter= new ScriptExecuter();
	ResultsClass report = new ResultsClass();
	ExcelOperations fileoperations = new ExcelOperations();
	String ObjectProprty;
	String ObjectProprtyValue;

	public int passcount;
	public static ArrayList passList= new ArrayList();

	//public WebDriver driver;


	public void enterText(String ObjectProperty,String ObjectPropertyValue,String Text,WebDriver driver) throws Exception
	{
		ObjectProprty=ScriptExecuter.Objpropertey.get(ObjectProperty);
		ObjectProprtyValue=ScriptExecuter.ObjproperteyValue.get(ObjectPropertyValue);
		boolean Status =false;

		try
		{
			if(ObjectProprty.equalsIgnoreCase("Name"))
			{
				//driver.findElement(By.name(ObjectPropertyValue)).clear();

				driver.findElement(By.name(ObjectProprtyValue)).sendKeys(Text);
				Status=true;
			}
			else if(ObjectProprty.equalsIgnoreCase("Id"))
			{
				//driver.findElement(By.id(ObjectPropertyValue)).clear();

				driver.findElement(By.id(ObjectProprtyValue)).sendKeys(Text);
				Status=true;

			}
			else if(ObjectProprty.equalsIgnoreCase("Xpath"))
			{
				//driver.findElement(By.xpath(ObjectPropertyValue)).clear();

				driver.findElement(By.xpath(ObjectProprtyValue)).sendKeys(Text);
				Status=true;

			}

			if(Status)
			{
				passList.add("Pass");
				report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Enter text",Text,"Pass",driver,true);
			}
			else
			{
				passList.add("Fail");
				report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Enter text",Text,"Fail",driver,true);
			}
		}catch(Exception e)
		{
			passList.add("Fail");
			report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Enter text",Text,"Fail",driver,true);
		}


	}
	
	public void Click(String ObjectProperty,String ObjectPropertyValue,String Text,WebDriver driver) throws Exception
	{
		ObjectProprty=ScriptExecuter.Objpropertey.get(ObjectProperty);
		ObjectProprtyValue=ScriptExecuter.ObjproperteyValue.get(ObjectPropertyValue);
		boolean Status =false;
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		

		try
		{
			if(ObjectProprty.equalsIgnoreCase("Name"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(ObjectProprtyValue)));
				
				driver.findElement(By.name(ObjectProprtyValue)).click();
				Status=true;
			}
			else if(ObjectProprty.equalsIgnoreCase("Id"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ObjectProprtyValue)));
				driver.findElement(By.id(ObjectProprtyValue)).click();
				Status=true;

			}
			else if(ObjectProprty.equalsIgnoreCase("Xpath"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectProprtyValue)));
				driver.findElement(By.xpath(ObjectProprtyValue)).click();
				Status=true;

			}
			else if(ObjectProprty.equalsIgnoreCase("Class"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ObjectProprtyValue)));
				driver.findElement(By.className(ObjectProprtyValue)).click();
				Status=true;

			}

			if(Status)
			{
				passList.add("Pass");
				report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Click",Text,"Pass",driver,true);
			}
			else
			{
				passList.add("Fail");
				report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Click",Text,"Fail",driver,true);
			}
		}catch(Exception e)
		{
			passList.add("Fail");
			report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Click",Text,"Fail",driver,true);
		}


	}

	public void browserLaunch(String Text,WebDriver driver) throws Exception
	{
		boolean Status =false;

		try
		{
			driver.get(Text);

			driver.manage().window().maximize();
			Status=true;

			if(Status)
			{
				passList.add("Pass");
				report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Browser Launch",Text,"Pass",driver,true);
			}
			else
			{
				passList.add("Fail");
				report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Browser Launch",Text,"Fail",driver,true);
			}
		}catch(Exception e)
		{
			passList.add("Fail");
			report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Browser Launch",Text,"Fail",driver,true);
		}


	}
}




