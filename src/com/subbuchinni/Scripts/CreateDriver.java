package com.subbuchinni.Scripts;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CreateDriver {

	Executioner exe=new Executioner();

	CommonClass commnclass =new CommonClass();

	RemoteWebDriver chromeDriver =null;

	@SuppressWarnings("deprecation")
	public RemoteWebDriver getDriver(String Thread)
	{
		RemoteWebDriver webDriver =null;

		String ExeDetails =commnclass.setExecutionDetails();

		String ExecutionDetails [] = ExeDetails.split("@@@");
		String Host=ExecutionDetails[0];
		String Browser =ExecutionDetails[1];
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			HashMap<String,Object> ChromePref= new HashMap<String,Object>();
			 System.setProperty("webdriver.chrome.driver","D:\\java work\\Practice\\Resources\\chromedriver.exe");
			 
			String downloadFilePath=null;
			
			String relName="downloadFilePath";
			downloadFilePath=new File(relName).getAbsolutePath();
			
			ChromePref.put("download.prompt_for_download", false);
			
			ChromePref.put("download.default_directory", downloadFilePath);
			ChromePref.put("profile.default_content_settings.popups", 0);
			
			ChromeOptions options =new ChromeOptions();
			HashMap<String,Object> ChromeOptionsMap= new HashMap<String,Object>();
			
			options.setExperimentalOption("prefs", ChromePref);
			//options.addArguments("--test type");
			
			ChromePref.put("safebrowsing.enabled", "true");
			DesiredCapabilities cap= DesiredCapabilities.chrome();
			
			cap.setCapability(ChromeOptions.CAPABILITY, ChromeOptionsMap);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			
			
			 ChromeDriver driver = new ChromeDriver(cap);
			// chromeDriver =new ChromeDriver(cap);
			 webDriver =driver;
			
			// webDriver.get("www.google.com");
		}

		return webDriver;
	}

}
