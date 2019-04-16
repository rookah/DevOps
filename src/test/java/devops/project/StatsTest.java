package devops.project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;

public class StatsTest extends TestCase {
    
    private DataFrame df;
    private ArrayList<String> labels;
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
        labels = new ArrayList<String>();
        df = new DataFrame("src/main/java/devops/project/csv/grades.csv");
    }

    public void testMean() throws Exception {
        assertEquals("Last grade,Mean\n13.375,12.375\n", df.mean().toString());
    }

    public void testMeanOneCol() throws Exception {
        labels.add("Last grade");
        assertEquals("Last grade\n13.375\n", df.mean(labels).toString());
    }

    public void testMeanSwapCol() throws Exception {
        labels.add("Mean");
        labels.add("Last grade");
        assertEquals("Mean,Last grade\n12.375,13.375\n", df.mean(labels).toString());
    }

    public void testMax() throws Exception {
        assertEquals(18.5f, df.max());
    }

    public void testMaxOverCol() throws Exception {
        labels.add("Mean");
        assertEquals(18.1f, df.max(labels));
    }

    public void testMaxOverSameCol() throws Exception {
        labels.add("Mean");
        labels.add("Mean");
        labels.add("Mean");
        assertEquals(18.1f, df.max(labels));
    }

    public void testMin() throws Exception {
        assertEquals(5.0f, df.min());
    }

    public void testMinOverCol() throws Exception {
        labels.add("Mean");
        assertEquals(9.0f, df.min(labels));
    }

    public void testMinOverSameCol() throws Exception {
        labels.add("Mean");
        labels.add("Mean");
        assertEquals(9.0f, df.min(labels));
    }
}