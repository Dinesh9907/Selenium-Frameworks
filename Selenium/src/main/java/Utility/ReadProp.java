package Utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ReadProp {
	
	public String propReader(String Key) throws IOException {
		Properties prop=new Properties();
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\url.properties");
		prop.load(file);
		
		return prop.getProperty(Key);
	}
}
