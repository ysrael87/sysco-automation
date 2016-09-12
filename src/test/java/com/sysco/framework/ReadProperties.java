package com.sysco.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class reads the properties from the config file
 */
public class ReadProperties {
	private static Properties prop = new Properties();

	public static Properties getProperties() {

		FileInputStream fileInput;
		File file = new File("src/test/resources/config.properties");

		try {

			fileInput = new FileInputStream(file);
		} catch (IOException ioe) {
			System.out.println(ioe.toString());
			return null;
		}

		// load properties file
		try {
			prop.load(fileInput);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
