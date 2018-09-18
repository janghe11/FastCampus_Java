package my.examples.was;

public class Main {
    public static void main(String[] args) {
        WasServer wasServer = new WasServer(8000);
        wasServer.start();
        System.out.println("WAS 서버가 시작되었습니다.");
    }
}
