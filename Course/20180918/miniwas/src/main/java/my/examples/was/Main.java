package my.examples.was;

public class Main {
    public static void main(String[] args) {
        Connector connector = new Connector(8888);
        connector.start();
        System.out.println("WAS 서버가 시작되었습니다.");
    }
}
