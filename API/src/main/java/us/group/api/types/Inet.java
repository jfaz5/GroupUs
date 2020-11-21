package us.group.api.types;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Inet implements Serializable {
    private final String address;

    @Override
    public int hashCode() { return address != null ? address.hashCode() : 0; }
    public Inet(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Inet inet = (Inet) o;
        return address != null ? address.equals(inet.address) : inet.address == null;
    }

    public InetAddress toInetAddress() {
        try {
            String host = address.replaceAll("\\/.*$", "");
            return Inet4Address.getByName(host);
        } catch (UnknownHostException e) {
            throw new IllegalStateException(e);
        }
    }
}