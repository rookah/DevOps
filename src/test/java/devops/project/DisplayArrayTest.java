package devops.project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DisplayArrayTest extends TestCase {
    
    private DataFrame df;
    private Integer[][] initArray;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DisplayArrayTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DisplayArrayTest.class );
    }

    public void setUp() {
    	initArray = new Integer[4][4];
        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                initArray[i][j] = i + j;
            }
        }
        df = new DataFrame(initArray);
    }

    public void testPrintAll() throws Exception {
        assertEquals("0,1,2,3\n0,1,2,3\n1,2,3,4\n2,3,4,5\n3,4,5,6\n", df.toString());
    }

    public void testPrintFirst0Rows() throws Exception {
        assertEquals("0,1,2,3\n", df.printFirst(0));
    }

    public void testPrintFirst2Rows() throws Exception {
        assertEquals("0,1,2,3\n0,1,2,3\n1,2,3,4\n", df.printFirst(2));
    }

    public void testPrintFirstAllRows() throws Exception {
    	assertEquals("0,1,2,3\n0,1,2,3\n1,2,3,4\n2,3,4,5\n3,4,5,6\n", df.printFirst(4));
    }

    public void testPrintLast0Rows() throws Exception {
        assertEquals("0,1,2,3\n", df.printLast(0));
    }

    public void testPrintLast2Rows() throws Exception {
        assertEquals("0,1,2,3\n2,3,4,5\n3,4,5,6\n", df.printLast(2));
    }

    public void testPrintLastAllRows() throws Exception {
    	assertEquals("0,1,2,3\n0,1,2,3\n1,2,3,4\n2,3,4,5\n3,4,5,6\n", df.printLast(4));
    }
}
