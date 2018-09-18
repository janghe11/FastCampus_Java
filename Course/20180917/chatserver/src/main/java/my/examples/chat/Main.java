package my.examples.chat;

public class Main {
    public static void main(String[] args){
        ChatServer chatServer = new ChatServer(11000);
        chatServer.start();
        System.out.println("서버가 실행!");
    }
}
