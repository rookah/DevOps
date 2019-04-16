package devops.project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;

public class SelectTest extends TestCase {
    
    private DataFrame df;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SelectTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SelectTest.class );
    }

    public void setUp() {
        df = new DataFrame("src/main/java/devops/project/csv/test_df.csv");
    }

    public void testSelectNoIndex() throws Exception {
        assertEquals("Sexe,Prénom,Année de naissance\n", df.selectIndex(new ArrayList<Integer>()).toString());
    }

    public void testSelectOneIndex() throws Exception {
        ArrayList<Integer> listI = new ArrayList<Integer>();
        listI.add(1);
        assertEquals("Sexe,Prénom,Année de naissance\nF,Béatrice,1964\n", df.selectIndex(listI).toString());
    }

    public void testSelectSameIndex() throws Exception {
        ArrayList<Integer> listI = new ArrayList<Integer>();
        listI.add(1);
        listI.add(1);
        assertEquals("Sexe,Prénom,Année de naissance\nF,Béatrice,1964\nF,Béatrice,1964\n", df.selectIndex(listI).toString());
    }

    public void testSelectAllIndex() throws Exception {
        ArrayList<Integer> listI = new ArrayList<Integer>();
        listI.add(1);
        listI.add(0);
        listI.add(2);
        assertEquals("Sexe,Prénom,Année de naissance\nF,Béatrice,1964\n" + 
            "M,Alphonse,1932\nF,Charlotte,1988\n", df.selectIndex(listI).toString());
    }

    public void testSelectNoCol() throws Exception {
        assertEquals("", df.selectColumn(new ArrayList<String>()).toString());
    }

    public void testSelectOneCol() throws Exception {
        ArrayList<String> listL = new ArrayList<String>();
        listL.add("Prénom");
        assertEquals("Prénom\nAlphonse\nBéatrice\nCharlotte\n", df.selectColumn(listL).toString());
    }

    public void testSelectSameCol() throws Exception {
        ArrayList<String> listL = new ArrayList<String>();
        listL.add("Prénom");
        listL.add("Prénom");
        assertEquals("Prénom,Prénom\nAlphonse,Alphonse\nBéatrice,Béatrice\nCharlotte,Charlotte\n", df.selectColumn(listL).toString());
    }

    public void testSelectAllCol() throws Exception {
        ArrayList<String> listL = new ArrayList<String>();
        listL.add("Prénom");
        listL.add("Année de naissance");
        listL.add("Sexe");
        assertEquals("Prénom,Année de naissance,Sexe\nAlphonse,1932,M\n" + 
            "Béatrice,1964,F\nCharlotte,1988,F\n", df.selectColumn(listL).toString());
    }
}