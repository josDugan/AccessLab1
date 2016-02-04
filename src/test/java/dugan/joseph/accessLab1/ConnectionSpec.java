package dugan.joseph.accessLab1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by joseph on 1/26/16.
 */
public class ConnectionSpec {
    private final static int SAMPLE_PORT_NUMBER = 1;
    private final static String SAMPLE_IP_ADDRESS = "1.1.1.1";
    private Connection connection;

    @Before
    public void setUp() {
        connection = new Connection(SAMPLE_PORT_NUMBER, SAMPLE_IP_ADDRESS);
    }

    @Test
    public void setsPortNumberCorrectly() {
        // when
        connection.setPortNumber(SAMPLE_PORT_NUMBER + 1);

        // then
        int expected = SAMPLE_PORT_NUMBER + 1;
        int actual = connection.getPortNumber();
        assertEquals("portNumber was not set as expected", expected, actual);
    }

    private static final String REPLACEMENT_SAMPLE_IP_ADDRESS = "2.2.2.2";

    @Test
    public void setsIpAddressCorrectly() {
        // when
        connection.setIpAddress(REPLACEMENT_SAMPLE_IP_ADDRESS);

        // then
        String expected = REPLACEMENT_SAMPLE_IP_ADDRESS;
        String actual = connection.getIpAddress();
        assertTrue("ipAddress was not set as expected", expected.equals(actual));
    }

    @Test
    public void indiscernibleConnectionsEqualEachOther() {
        // when
        connection.setPortNumber(SAMPLE_PORT_NUMBER);
        connection.setIpAddress(SAMPLE_IP_ADDRESS);

        // then
        Connection indiscernibleConnection = new Connection(SAMPLE_PORT_NUMBER, SAMPLE_IP_ADDRESS);
        assertTrue("objects are not equal", connection.equals(indiscernibleConnection));
    }

    @After
    public void teardown() {
        connection = null;
    }
}
