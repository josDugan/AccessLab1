package dugan.joseph.accessLab1;

/**
 * Created by joseph on 1/26/16.
 */
public class ConnectionManager {
    private static final int TOTAL_NUM_OF_CONNECTIONS = 10;
    private Connection[] connections;

    public ConnectionManager() {
        connections = new Connection[TOTAL_NUM_OF_CONNECTIONS];
        initConnectionBoard(connections);
    }

    private static void initConnectionBoard(Connection[] connections) {
        for (int i = 0; i < connections.length; i++) {
            int portNumber = i + 1;
            connections[i] = new Connection(portNumber, "");
        }
    }

    public static String add(ConnectionManager cm, String ipAddress) {
        int idx = findConnectionByIP(cm, "");
        if (idx != -1) {
            cm.connections[idx].setIpAddress(ipAddress);
            return "Connection added";
        } else {
            System.out.println("No available connections");
            return null;
        }
    }

    public static String remove(ConnectionManager cm, String ipAddress) {
        int idx = findConnectionByIP(cm, ipAddress);
        if (idx != -1) {
            cm.connections[idx].setIpAddress("");
            return "Connection ended";
        } else {
            System.out.println("No connections to disconnect");
            return null;
        }
    }

    static int findConnectionByIP(ConnectionManager cm, String ipAddress) {
        for (int i = 0; i < cm.connections.length; i++) {
            String currentIpAddress = cm.connections[i].getIpAddress();
            if (currentIpAddress != null && currentIpAddress.equals(ipAddress)) {
                return i;
            }
        }
        return -1;
    }



    public static void display(ConnectionManager cm) {
        System.out.println("Current connections: ");
        for (Connection connection : cm.connections) {
            System.out.println(connection.toString());
        }
        System.out.println("End of list of connecitons");
        System.out.println();
    }

    public Connection[] getConnections() {
        return connections;
    }

    public static void main(String[] args) {
        String ip1 = "1.1.1.1";
        String ip2 = "2.2.2.2";
        String ip3 = "3.3.3.3";
        String ip4 = "4.4.4.4";
        String ip5 = "5.5.5.5";

        String[] ipAddresses = {ip1, ip2, ip3, ip4, ip5};

        ConnectionManager cm = new ConnectionManager();

        String success;

        for (String ipAddress : ipAddresses) {
            success = add(cm, ipAddress);
            System.out.println(success);
        }

        display(cm);

        // removing ip4 and ip2
        success = remove(cm, ip4);
        System.out.println(success);
        success = remove(cm, ip2);
        System.out.println(success);

        display(cm);

        // add one more
        String ip6 = "6.6.6.6";
        success =add(cm, ip6);
        System.out.println(success);

        display(cm);

    }
}
