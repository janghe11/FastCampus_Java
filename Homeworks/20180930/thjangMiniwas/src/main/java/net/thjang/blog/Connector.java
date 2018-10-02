package net.thjang.blog;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector extends Thread{
    private int port = 0;
    private int ip = 0;
    DefaultServlet defaultServlet = null;

    public Connector(int port) {
        this.port = port;
        defaultServlet = new DefaultServlet();
    }

    @Override
    public void run() {
        System.out.printf("WAS Handler Start");
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            WASHandler wasHandler = new WASHandler(this, socket);
            wasHandler.start();
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ioe) {
                ioe.getStackTrace();
            }
        }

    }
}
