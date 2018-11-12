package examples.boot.springboard.config;

import org.springframework.beans.factory.annotation.Value;

public class ServerInfo {
    @Value("${serverinfo.ip}")
    private String ip;
    @Value("${serverinfo.port}")
    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
