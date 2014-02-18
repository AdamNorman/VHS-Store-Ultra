package se.nackademin.vhs_store_ultra;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropHandling {
	
	//Great a properties object
	private Properties prop;

	//Great a writing method for at save the port number and localhost
	public void writeProperties(String fileName) {
		prop = new Properties();
		try {
			//set the properties value
			prop.setProperty("custName", fileName);
			prop.setProperty("staffPass", fileName);
			prop.setProperty("custPass", fileName);
			prop.setProperty("staffPass", fileName);
			
			//save properties to project root folder
			prop.store(new FileOutputStream(fileName), null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Great a reading method for at collect port number and localhost
	public void readProperties(String fileName) {
		prop = new Properties();
		try {
			//collect properties from project root folder
			prop.load(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Great String method for property
	public String getProperty(String propName) 
	{
		return prop.getProperty(propName);
	}
}

// propHandler.getProperty("address"), Integer.parseInt(propHandler.getProperty("port"))

// propHandler.readProperties("config.properties");