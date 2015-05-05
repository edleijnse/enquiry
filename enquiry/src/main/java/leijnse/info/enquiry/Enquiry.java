package leijnse.info.enquiry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class Enquiry {
	private static String enquiryHeaderLocation;


	public String getEnquiryFragment(String iFragment) throws IOException {
		String myHeader = "";
		InputStream in =  this.getClass().getClassLoader().getResourceAsStream(iFragment);
		BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		
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

			/*ResourceBundle labels = ResourceBundle.getBundle("enquiry",
					Locale.GERMAN);
			enquiryHeaderLocation = labels.getString("header");
			
			System.out.println("headerLocation: " + enquiryHeaderLocation);*/
			
			
			String myHeader = enquiry.getEnquiryFragment("enquiryheader_01_prolog.html");
			myHeader += enquiry.getEnquiryFragment("enquiryheader_02_body.html");
			myHeader += enquiry.getEnquiryFragment("enquiryheader_03_epilog.html");
			System.out.println("header: " + myHeader);
			
			String myQuestion1 = enquiry.getEnquiryFragment("enquiryquestion_01_prolog.html");
			myQuestion1 += enquiry.getEnquiryFragment("enquiryquestion_02_body.html");
			myQuestion1 += "Wieviele Zigaretten rauchen Sie?";
			myQuestion1 += enquiry.getEnquiryFragment("enquiryanswer_01_prolog.html");
			myQuestion1 += enquiry.getEnquiryFragment("enquiryanswer_02_body.html");
			myQuestion1 += "Anzahl:";
			myQuestion1 += enquiry.getEnquiryFragment("enquiryanswer_03_epilog.html");
			myQuestion1 += enquiry.getEnquiryFragment("enquiryquestion_03_epilog.html");
			System.out.println("question1: " + myQuestion1);
			
			String myQuestion2 = enquiry.getEnquiryFragment("enquiryquestion_01_prolog.html");
			myQuestion2 += enquiry.getEnquiryFragment("enquiryquestion_02_body.html");
			myQuestion2 += "Wie schwer sind Sie?";
			myQuestion2 += enquiry.getEnquiryFragment("enquiryanswer_01_prolog.html");
			myQuestion2 += enquiry.getEnquiryFragment("enquiryanswer_02_body.html");
			myQuestion2 += "Gewicht:";
			myQuestion2 += enquiry.getEnquiryFragment("enquiryanswer_03_epilog.html");
			myQuestion2 += enquiry.getEnquiryFragment("enquiryquestion_03_epilog.html");
			System.out.println("question2: " + myQuestion2);
			
			String myEnquiry = myHeader + myQuestion1 + myQuestion2;
			System.out.println("myEnquiry: " + myEnquiry);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
