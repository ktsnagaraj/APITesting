package com.api.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public static String URL;
	public static void readProperties() throws IOException {
		FileReader file = new FileReader("configuraton.properties");
		Properties properties = new Properties();
		properties.load(file);
		URL = properties.getProperty("URL");
		}
}