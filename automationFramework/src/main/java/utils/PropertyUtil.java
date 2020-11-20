package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

	public Properties getPropertyFileLoad(String filePath) throws IOException {
		FileReader reader = new FileReader(filePath);
		Properties prop = new Properties();
		prop.load(reader);
		return prop;
	}
}
