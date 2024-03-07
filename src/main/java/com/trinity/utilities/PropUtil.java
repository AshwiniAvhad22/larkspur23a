package com.trinity.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class can be used to read properties file. It contains utility methods
 * to read any properties file in different way
 * 
 * @author User
 */
public class PropUtil {

	private String filepath;

	/**
	 * This method can be used to get value of a specified key
	 * 
	 * @param filepath from which u want to read value
	 * @param key      for which u need value
	 * @return {@code String} representation of value
	 */

	public PropUtil(String locatorfile) {
		filepath = locatorfile;

	}

	public PropUtil() {

	}

	public String getValue(String filepath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			//handling code
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {

			// Handling code
		}

		String value = prop.getProperty(key);
		return value;
	}

	/**
	 * This method can be used along with{@code proputil(String filepath)} this
	 * method can read which is initialize using object creation
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
