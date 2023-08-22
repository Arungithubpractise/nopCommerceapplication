package com.nopCommerceapplication.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	 Properties pro ;
	
	 public Readconfig() 
	{
		File fil =new File(".//configuration//config.properties");
		
		try 
		{
			FileInputStream file = new FileInputStream(fil);
			 pro =new Properties();
			 pro.load(file);
		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
}


public  String geturl()
{
	String urll = pro.getProperty("url");
	return urll;
}
public  String getusername()
{
	String name = pro.getProperty("username");
	return name;
}

public  String getpassword()
{
	String pass = pro.getProperty("password");
	return pass;
}
public  String getchromepath()
{
	String path = pro.getProperty("chromedriverpath");
	return path;
}

public  String getfirefoxpath()
{
	String fpath = pro.getProperty("firefoxpath");
	return fpath;
}

}






