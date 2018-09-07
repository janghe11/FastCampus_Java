package examples.first;

public class LottoBall {
    // 공을 받을 변수를 설정한다.
    int number;

    // 공 번호를 매긴다
    public LottoBall(int number) {
        this.number = number;
    }

    // 공을 꺼낸다(번호 알려주기)
    public int getNumber() {
        return number;
    }
}
