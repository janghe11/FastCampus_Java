package my.examples.chat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


public class ChatServer extends Thread{
    private int port;
    private Set<PrintWriter> socketSet = null;

    public ChatServer(int port){
        this.port = port;
        this.socketSet = new CopyOnWriteArraySet<>();
    }

    public void addPrintWriter(PrintWriter out){
        socketSet.add(out);
    }

    public void removePrintWriter(PrintWriter out){
        socketSet.remove(out);
    }

    public void broadcast(String msg){
        for (PrintWriter out : socketSet){
            // 네트워크가 쓰는 동안 error,disconnect가 날 때 catch로 아무 동작 안함
            try{
                out.println(msg);
                out.flush();
            }catch (Exception ex){}
        }
    }

    @Override
    public void run() {
        // To-do list of chatting server

        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept(); //Blocking method
                ChatHandler handler = new ChatHandler(this,socket);
                handler.start();
//                System.out.println(socket);
            }
        }catch (Exception ioe){
            ioe.printStackTrace();
        }finally {
            try{
                serverSocket.close();
            }catch (Exception ex){}
        }
    }
}
