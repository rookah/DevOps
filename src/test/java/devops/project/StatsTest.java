package devops.project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StatsTest extends TestCase {
    
    private DataFrame df;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StatsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StatsTest.class );
    }

    public void setUp() {
        df = new DataFrame("src/main/java/devops/project/csv/grades.csv");
    }

    public void testMean() throws Exception {
        assertEquals("Last grade,Mean\n13.375,12.375\n", df.mean().toString());
    }
}