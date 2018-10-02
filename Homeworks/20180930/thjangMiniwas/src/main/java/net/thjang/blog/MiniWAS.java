package net.thjang.blog;

public class MiniWAS {
    private int port = 0;
    private int ip = 0;

    public MiniWAS(int port) {
        this.port = port;

        Connector connector = new Connector(8888);
        connector.start();
    }
}
