package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	String path="config.properties";
	public ReadConfig() {
		properties=new Properties();
	try {
		FileInputStream file=new FileInputStream(path);
		properties.load(file);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public String getBrowser()	{
	String value=properties.getProperty("browser");{
	if(value!=null)
		return value;
	else
		throw new RuntimeException("url not specified in config file.");
	}
}
}
