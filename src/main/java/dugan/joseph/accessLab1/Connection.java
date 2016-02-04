package dugan.joseph.accessLab1;

/**
 * Created by joseph on 1/26/16.
 */
class Connection {
    private int portNumber;
    private String ipAddress;

    Connection() {

    }

    Connection(int portNumber, String ipAddress) {
        this.portNumber = portNumber;
        this.ipAddress = ipAddress;
    }

    int getPortNumber() {
        return portNumber;
    }

    String getIpAddress() {
        return ipAddress;
    }

    void setPortNumber(int newPortNumber) {
        portNumber = newPortNumber;
    }

    void setIpAddress(String newIpAddress) {
        ipAddress = newIpAddress;
    }

    @Override
    public String toString() {
        return "Connection at port number: " + portNumber + " from IP address: " + ipAddress;
    }
}
