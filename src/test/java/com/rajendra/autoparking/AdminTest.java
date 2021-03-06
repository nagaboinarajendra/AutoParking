package com.rajendra.autoparking;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AdminTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AdminTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AdminTest.class );
    }

    public void testAdminlogin() {
    	assertTrue(new Admin().validateAdmin("rajendra", "1234"));
    	assertFalse(new Admin().validateAdmin("rajendra", "58454"));
    	assertFalse(new Admin().validateAdmin("fdsdsfd", "1234"));
    }
}
