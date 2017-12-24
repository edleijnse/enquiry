package leijnse.info.enquery;

import com.thoughtworks.xstream.XStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import leijnse.info.enquiry.FilterSample;
import leijnse.info.enquiry.Person;

import java.io.IOException;
import java.util.Collection;

import static leijnse.info.enquiry.Person.Gender.FEMALE;
import static leijnse.info.enquiry.Person.Gender.MALE;

/**
 * Unit test for simple Enquiry.
 */
public class FilterSampleTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FilterSampleTest(String testName) {
        super(testName);
        System.out.println("test");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        System.out.println("test");
        return new TestSuite(FilterSampleTest.class);
    }

    /**
     * Rigourous Test :-)
     */

    public void testApp() {
        assertTrue(true);
        FilterSample testee = new FilterSample();
        try {
            testee.addPerson(35, MALE);
            testee.addPerson(30,MALE);
            testee.addPerson(25,FEMALE);
            testee.addPerson(15,FEMALE);
            testee.addPerson(15,MALE);
            testee.addPerson(22,MALE);
            Collection<Person> result = testee.filterPersonMaleGT21();
            XStream xstream = new XStream();
            String myResult = xstream.toXML(result);
            System.out.println(myResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


        System.out.println("test");

    }
}
