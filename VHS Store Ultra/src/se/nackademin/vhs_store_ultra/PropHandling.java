package se.nackademin.vhs_store_ultra;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropHandling {
	
	private Properties prop;

	public void writeProperties(String fileName) {
		prop = new Properties();
		try {
			prop.setProperty("custName", fileName);
			prop.setProperty("staffPass", fileName);
			prop.setProperty("custPass", fileName);
			prop.setProperty("staffPass", fileName);
			
			prop.store(new FileOutputStream(fileName), null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readProperties(String fileName) {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String propName) 
	{
		return prop.getProperty(propName);
	}
}