package my.examples.chat;

import java.io.*;
import java.net.Socket;

public class ChatHandler extends Thread{
    private ChatServer chatServer;
    private Socket socket;
    private String name;

    public ChatHandler(ChatServer chatServer, Socket socket){
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("SocketHandler Start");
//        System.out.println(socket);
//        InputStream in  = null;
        BufferedReader in  = null;
        PrintWriter out = null;
        try{
//            in  = socket.getInputStream();
//            out = socket.getOutputStream();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.name = in.readLine();
            chatServer.broadcast(this.name + "님이 입장했어요.");

            chatServer.addPrintWriter(out);

            String line = null;

            while ((line = in.readLine()) != null){
//                out.println(line);
//                out.flush();
                chatServer.broadcast(this.name + ":" + line);
            }
        }catch (Exception ex){
            System.out.println("Chat Handler Close");
        }finally {
            chatServer.removePrintWriter(out);
            chatServer.broadcast(this.name + "님이 퇴장했어요.");
            System.out.println("Chat Handler Finally");
            try{
                in.close();
            }catch (Exception e){}
            try{
                out.close();
            }catch (Exception e){}
            // 해당 socket이 끊어졌다는 것을 ChatServer에게 알린다.
        }

    }
}
