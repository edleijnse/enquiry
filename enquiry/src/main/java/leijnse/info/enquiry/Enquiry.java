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
    private static String enquiryHeaderLocation;
    
    public void setEnquiryHeader(String headerLocation){
    	enquiryHeaderLocation = headerLocation;
    }
	
	public static void main(String[] args) {
		System.out.println("Hello World Ed!");
		Properties properties = new Properties();
		BufferedInputStream stream;
		
		try {
			Enquiry enquiry = new Enquiry();
			
			stream = new BufferedInputStream(
					new FileInputStream(
							"C:/data/git/enquiry/enquiry/src/main/resources/enquiry.properties"));

					properties.load(stream);
			
			enquiryHeaderLocation = properties.getProperty("header");
			enquiry.setEnquiryHeader(enquiryHeaderLocation);
			
			System.out.println("headerLocation: " + enquiryHeaderLocation);

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
