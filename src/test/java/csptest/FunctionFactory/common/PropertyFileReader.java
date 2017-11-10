package csptest.FunctionFactory.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	private String path;
	private Properties pps;
	
	public PropertyFileReader(String path) {
		super();
		this.path = path;
		pps = new Properties();
	}

	public boolean load()
	{
		if (path == "" || path == null) return false;
		try {
	     	BufferedInputStream in = new BufferedInputStream (new FileInputStream(path));  
	     	pps.load(in);
	             
		}catch (IOException e) {
			e.printStackTrace();
	}
		return true;
	}
	
	public String getData(String key)
	{
		     	String value = pps.getProperty(key);
		     	if(value == null)
		     	{
		     		return "Invalid parameter. Please check!";
		     	}
		     	return value;
	}
}
