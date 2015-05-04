package leijnse.info.enquiry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class Enquiry {
	private static String enquiryHeaderLocation;

	public void setEnquiryHeader(String headerLocation) {
		enquiryHeaderLocation = headerLocation;
	}

	public String getEnquiryFragment(String iFragment) throws IOException {
		String myHeader = "";
		BufferedReader br = new BufferedReader(new FileReader(
				iFragment));
		try {
			StringBuilder sb = new StringBuilder();
			myHeader = br.readLine();

			while (myHeader != null) {
				sb.append(myHeader);
				sb.append("\n");
				myHeader = br.readLine();
			}
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			br.close();
		}
		return myHeader;
	}

	public static void main(String[] args) {
		System.out.println("Hello World Ed!");

		try {
			Enquiry enquiry = new Enquiry();

			// https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/i18n/resbundle/examples/PropertiesDemo.java

			ResourceBundle labels = ResourceBundle.getBundle("enquiry",
					Locale.GERMAN);
			enquiryHeaderLocation = labels.getString("header");
			// enquiryHeaderLocation = properties.getProperty("header");
			enquiry.setEnquiryHeader(enquiryHeaderLocation);

			System.out.println("headerLocation: " + enquiryHeaderLocation);
			
			String myHeader = enquiry.getEnquiryFragment(enquiryHeaderLocation);
			
			System.out.println("header: " + myHeader);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
