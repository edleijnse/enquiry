package leijnse.info.enquery;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import leijnse.info.enquiry.*;

/**
 * Unit test for simple Enquiry.
 */
public class EnquiryTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public EnquiryTest(String testName) {
        super(testName);
        System.out.println("test");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        System.out.println("test");
        return new TestSuite(EnquiryTest.class);
    }

    /**
     * Rigourous Test :-)
     */

    public void testApp() {
        assertTrue(true);
        Enquiry testee = new Enquiry();
        try {
			System.out.println(testee.createEnquiry());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("test");

    }
}
