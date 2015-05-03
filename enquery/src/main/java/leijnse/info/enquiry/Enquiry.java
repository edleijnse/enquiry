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
				"C:/data/git/enquiry/enquery/src/main/java/leijnse/info/enquiry/myproject.properties"));
			properties.load(stream);
			
			String sprache = properties.getProperty("test");
			System.out.println("sprache: " + sprache);

			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
