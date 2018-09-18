package my.examples.was;

import java.net.ServerSocket;
import java.net.Socket;

public class WasServer extends Thread {
    private int port = 0;

    public WasServer(int port){
        this.port = port;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                WasRequest wasRequest = new WasRequest(this, socket);
                wasRequest.start();
            }
        }catch (Exception ex) {
//            System.out.println("Server Socket error : " + ex.getStackTrace());
            ex.printStackTrace();
        } finally {
            try{
                serverSocket.close();
            }catch (Exception ioe) {
//                System.out.println("Server Socket close error : " + ioe.getMessage());
                ioe.getMessage();
            }
        }
    }
}
