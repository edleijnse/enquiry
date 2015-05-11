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
        private static String labelQuestionary;
        private static String labelQuestionId;
        private static String labelQuestion;
        private static String labelAnswerId;
        private static String labelAnswer;
        


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
		
		try {
			Enquiry enquiry = new Enquiry();

			// https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/i18n/resbundle/examples/PropertiesDemo.java

			ResourceBundle labels = ResourceBundle.getBundle("enquiry",
					Locale.GERMAN);
			enquiryHeaderLocation = labels.getString("header");
			labelQuestionary = labels.getString("txtquestionary");
                        labelQuestionId = labels.getString("txtquestionid");
                        labelQuestion = labels.getString("txtquestion");
                        labelAnswerId = labels.getString("txtanswerid");
                        labelAnswer = labels.getString("txtanswer");
                        
			System.out.println("labelQuestionary: " + labelQuestionary);
                        System.out.println("labelQuestionId: " + labelQuestionId);
                        System.out.println("labelQuestion: " + labelQuestion);
                        System.out.println("labelAnswerId: " + labelAnswerId);
                        System.out.println("labelAnswer: " + labelAnswer);
			
			
			String myEnquiryPrepare = enquiry.getEnquiryFragment("enquiry_01_prolog.html");
			String myEnquiry = myEnquiryPrepare.replace("#labelQuestionary", labelQuestionary);
			
                        String myEnquiryQuestion01Prolog01 = enquiry.getEnquiryFragment("enquiryquestion_01_prolog.html");
                        String myEnquiryQuestion01Prolog02 = myEnquiryQuestion01Prolog01.replace("#labelQuestionId", labelQuestionId);
                        String myEnquiryQuestion01Prolog03 = myEnquiryQuestion01Prolog02.replace("#labelQuestion", labelQuestion);
                        String myEnquiryQuestion01Prolog04 = myEnquiryQuestion01Prolog03.replace("#labelAnswerId", labelAnswerId);
                        String myEnquiryQuestion01Prolog05 = myEnquiryQuestion01Prolog04.replace("#labelAnswer", labelAnswer);
			myEnquiry += myEnquiryQuestion01Prolog05;
			
			String myQuestion1 = enquiry.getEnquiryFragment("enquiryquestion_02_body.html");
			myEnquiry += myQuestion1;
			
			
			String myQuestion2 = enquiry.getEnquiryFragment("enquiryquestion_02_body.html");
			myEnquiry += myQuestion2;
			
			String myQuestion3 = enquiry.getEnquiryFragment("enquiryquestion_02_body.html");
			myEnquiry += myQuestion3;
			for (int i=0;i<100;i++){
				String myQuestion4 = enquiry.getEnquiryFragment("enquiryquestion_02_body.html");
				String myNewstring = myQuestion4.replaceAll("#questionId", Integer.toString(i + 4));
				String myNewstring2 = myNewstring.replaceAll("#questionDescription", "Frage " + Integer.toString(i + 4));
				myEnquiry += myNewstring2;
			}
			
			
		
			myEnquiry += enquiry.getEnquiryFragment("enquiry_03_epilog.html");
			System.out.println(myEnquiry);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
