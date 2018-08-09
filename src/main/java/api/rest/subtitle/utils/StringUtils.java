package api.rest.subtitle.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StringUtils {
	
	/**
	 * Load the filePath properties.
	 * @return
	 * @throws IOException
	 */
	public static Properties loadProperties(String filePath) throws IOException{
		Properties prop= new Properties();
		InputStream input = null;
		input = StringUtils.class.getResourceAsStream(filePath);
		// load a properties file
		prop.load(input);
		return prop;
	}
	
	/**
	 * Load the value of a key inside a Properties object.
	 * @param properties
	 * @param key
	 * @return
	 */
	public static String loadKeyFromProperties(Properties properties,String key){
		String value = "";
		if(properties!=null){
			value=properties.getProperty(key, "");
		}
		return value;
	}
}
