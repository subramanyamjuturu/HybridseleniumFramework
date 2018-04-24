package com.subbuchinni.Scripts;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verification {
	
	ScriptExecuter scriptexecuter= new ScriptExecuter();
	ResultsClass report = new ResultsClass();
	ExcelOperations fileoperations = new ExcelOperations();
	String ObjectProprty;
	String ObjectProprtyValue;

	public int passcount;
	public static ArrayList passList= new ArrayList();

	public void verifyText(String ObjectProperty,String ObjectPropertyValue,String Text,WebDriver driver) throws Exception
	{
		ObjectProprty=ScriptExecuter.Objpropertey.get(ObjectProperty);
		ObjectProprtyValue=ScriptExecuter.ObjproperteyValue.get(ObjectPropertyValue);
		boolean Status =false;
		String ActualValue = null;

		try
		{
			if(ObjectProprty.equalsIgnoreCase("Name"))
			{
				//driver.findElement(By.name(ObjectPropertyValue)).clear();

				//String ExcectedText =driver.findElement(By.name(ObjectProprtyValue)).getAttribute("value");
				
				if(driver.findElement(By.name(ObjectProprtyValue)).getAttribute("value").equals(Text) || driver.findElement(By.name(ObjectProprtyValue)).getText().equals(Text))
				Status=true;
				try{
					ActualValue=driver.findElement(By.name(ObjectProprtyValue)).getAttribute("value");
				}catch(NoSuchElementException e)
				{
					ActualValue=driver.findElement(By.name(ObjectProprtyValue)).getText();
				}
			}
			else if(ObjectProprty.equalsIgnoreCase("Id"))
			{
				//driver.findElement(By.id(ObjectPropertyValue)).clear();

				//driver.findElement(By.id(ObjectProprtyValue)).sendKeys(Text);
				if(driver.findElement(By.id(ObjectProprtyValue)).getAttribute("value").equals(Text) || driver.findElement(By.id(ObjectProprtyValue)).getText().equals(Text))
				Status=true;
				
				try{
					ActualValue=driver.findElement(By.id(ObjectProprtyValue)).getAttribute("value");
				}catch(NoSuchElementException e)
				{
					ActualValue=driver.findElement(By.id(ObjectProprtyValue)).getText();
				}

			}
			else if(ObjectProprty.equalsIgnoreCase("Xpath"))
			{
				//driver.findElement(By.xpath(ObjectPropertyValue)).clear();

				//driver.findElement(By.xpath(ObjectProprtyValue)).sendKeys(Text);
				if(driver.findElement(By.xpath(ObjectProprtyValue)).getAttribute("value").equals(Text) || driver.findElement(By.xpath(ObjectProprtyValue)).getText().equals(Text))
				Status=true;
				
				try{
					ActualValue=driver.findElement(By.xpath(ObjectProprtyValue)).getAttribute("value");
				}catch(NoSuchElementException e)
				{
					ActualValue=driver.findElement(By.xpath(ObjectProprtyValue)).getText();
				}

			}

			if(Status)
			{
				passList.add("Pass");
				report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Verifying Text",ActualValue,"Pass",driver,true);
			}
			else
			{
				passList.add("Fail");
				report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Verifying Text",ActualValue,"Fail",driver,true);
			}
		}catch(Exception e)
		{
			passList.add("Fail");
			report.ResultWrite(fileoperations.TempResultFile, fileoperations.TestDescription,Text,"Verifying Text",ActualValue,"Fail",driver,true);
		}


	}


}
