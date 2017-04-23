package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		try {
			File src = new File(System.getProperty("user.dir") + "/Configuration/config.properties");

			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load config file");
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getValue(String key) {
		return pro.getProperty(key);
	}

	public String getChromePath() {
		return pro.getProperty("ChromePath");
	}

	public String getIEPath() {
		return pro.getProperty("IEPath");
	}

}
