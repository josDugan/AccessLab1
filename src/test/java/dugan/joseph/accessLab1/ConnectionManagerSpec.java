package dugan.joseph.accessLab1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joseph on 1/26/16.
 */
public class ConnectionManagerSpec {

    private final static String SAMPLE_IP_ADDRESS_1 = "1.1.1.1";
    private final static String SAMPLE_IP_ADDRESS_2 = "2.2.2.2";
    private final static String SAMPLE_IP_ADDRESS_3 = "3.3.3.3";
    private final static String SAMPLE_IP_ADDRESS_4 = "4.4.4.4";
    private final static String SAMPLE_IP_ADDRESS_5 = "5.5.5.5";
    private final static String SAMPLE_IP_ADDRESS_6 = "6.6.6.6";
    private final static String SAMPLE_IP_ADDRESS_7 = "7.7.7.7";
    private final static String SAMPLE_IP_ADDRESS_8 = "8.8.8.8";
    private final static String SAMPLE_IP_ADDRESS_9 = "9.9.9.9";
    private final static String SAMPLE_IP_ADDRESS_10 = "10.10.10.10";

    private static String[] ipAddresses = {SAMPLE_IP_ADDRESS_1, SAMPLE_IP_ADDRESS_2, SAMPLE_IP_ADDRESS_3, SAMPLE_IP_ADDRESS_4,
        SAMPLE_IP_ADDRESS_5, SAMPLE_IP_ADDRESS_6, SAMPLE_IP_ADDRESS_7, SAMPLE_IP_ADDRESS_8, SAMPLE_IP_ADDRESS_9, SAMPLE_IP_ADDRESS_10};

    private ConnectionManager cm;

    @Before
    public void setUp() {
        cm = new ConnectionManager();
    }

    @Test
    public void addToArray() {
        // when
        for (String ipAddress: ipAddresses) {
            ConnectionManager.add(cm, ipAddress);
        }

        // then
        for (int i = 0; i < cm.getConnections().length; i++) {
            int expectedPortNumber = i + 1;
            int actualPortNumber = cm.getConnections()[i].getPortNumber();
            String expectedIpAddress = ipAddresses[i];
            String actualIpAddress = cm.getConnections()[i].getIpAddress();

            assertEquals("Port number is not as expected", expectedPortNumber, actualPortNumber);
            assertTrue("Ip address is not what was expected", expectedIpAddress.equals(actualIpAddress));
        }
    }

    @Test
    public void removeFromArray() {
        for (String ipAddress: ipAddresses) {
            ConnectionManager.add(cm, ipAddress);
        }

        // when
        String iPAddressToBeRemove = ipAddresses[0];
        ConnectionManager.remove(cm, iPAddressToBeRemove);
        int expected = -1;
        int actual = ConnectionManager.findConnectionByIP(cm, iPAddressToBeRemove);
        assertEquals("Address not removed", expected, actual);

    }

    @After
    public void teardown() {
        cm = null;
    }


}
