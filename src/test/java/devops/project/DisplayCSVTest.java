package devops.project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DisplayCSVTest extends TestCase {
    
    private DataFrame df;
    private Integer[][] initArray;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DisplayCSVTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DisplayCSVTest.class );
    }

    public void setUp() {
        df = new DataFrame("src/main/java/devops/project/csv/machin.csv");
    }

    public void testPrintAll() throws Exception {
        assertEquals("Sexe,Prénom,Année de naissance\nM,Alphonse,1932\n" + 
            "F,Béatrice,1964\nF,Charlotte,1988\n", df.toString());
    }

    public void testPrintFirst0Rows() throws Exception {
        assertEquals("Sexe,Prénom,Année de naissance\n", df.printFirst(0));
    }

    public void testPrintFirst2Rows() throws Exception {
        assertEquals("Sexe,Prénom,Année de naissance\nM,Alphonse,1932\n" + 
            "F,Béatrice,1964\n", df.printFirst(2));
    }

    public void testPrintFirstAllRows() throws Exception {
    	assertEquals("Sexe,Prénom,Année de naissance\nM,Alphonse,1932\n" + 
            "F,Béatrice,1964\nF,Charlotte,1988\n", df.printFirst(4));
    }

    public void testPrintLast0Rows() throws Exception {
        assertEquals("Sexe,Prénom,Année de naissance\n", df.printLast(0));
    }

    public void testPrintLast2Rows() throws Exception {
        assertEquals("Sexe,Prénom,Année de naissance\nF,Béatrice,1964\n" + 
            "F,Charlotte,1988\n", df.printLast(2));
    }

    public void testPrintLastAllRows() throws Exception {
    	assertEquals("Sexe,Prénom,Année de naissance\nM,Alphonse,1932\n" + 
            "F,Béatrice,1964\nF,Charlotte,1988\n", df.printLast(4));
    }
}
