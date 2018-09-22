package selenium.framework.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

	String result = "";
	InputStream inputStream;
	Properties prop;

	/*****************************************************************************************************
	 * Method Name : getProperties() Method Description : This method will helps
	 * to read the email properties Parameters : NA Return Type : properties
	 ******************************************************************************************************/

	public static Properties getProperties() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(System.getProperty("user.dir") + "/config/email.properties");

			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
	
	public static Properties getReportingServerProperties() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(System.getProperty("user.dir") + "/config/reportingserver.properties");

			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

	/*****************************************************************************************************
	 * Method Name : main() Method Description : Created this main method for
	 * testing purpose Parameters : NA Return Type : Date
	 ******************************************************************************************************/

	public static void main(String[] args) {
		new PropertiesFileReader();
		System.out.println(PropertiesFileReader.getProperties().getProperty("emailFlag"));

	}
}
