package leijnse.info.enquiry;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class Enquiry {
	public static void main(String[] args) {
		System.out.println("Hello World Ed!");
		Properties properties = new Properties();
		BufferedInputStream stream;
		
		try {
			stream = new BufferedInputStream(new FileInputStream(
				"enquiry.properties"));
			

			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sprache = properties.getProperty("lang");
	}
}
