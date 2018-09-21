package my.examples.was;

import java.net.ServerSocket;
import java.net.Socket;

public class Connector extends Thread {
    private int port = 0;
//    private WasEngine wasEngine = null;
    private DefaultServlet defaultServlet = null;
//    private Context context = null;

    public Connector(int port){
        this.port = port;
        // Engine, DefaultServlet, Context 생성
//        wasEngine = new WasEngine();
        defaultServlet = new DefaultServlet();
//        context = new Context();
    }

    @Override
    public void run() {

        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                WasHandler wasHandler = new WasHandler(this, socket);
                wasHandler.start();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try{
                serverSocket.close();
            }catch (Exception ioe) {
                ioe.getMessage();
            }
        }
    }
}
