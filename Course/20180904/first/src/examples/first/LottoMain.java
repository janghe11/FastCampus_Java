package examples.first;

import java.util.List;

public class LottoMain {

    public static void main(String args[]) {
        // 로또 볼 45개를 준비한다.
        List<LottoBall> list = LottoBallFactory.createBalls();

        // 로또머신에 넣는다.
        LottoMachine machine = new NHLottoMachine();

        // 로또머신의 로또볼을 섞는다.
        machine.put(list);

        // 섞인 볼들중에서 6개를 꺼낸다.
        List<LottoBall> result = machine.getBalls();

        for (LottoBall ball : result) {
            System.out.print(ball.getNumber() + " ");
        }
    }
}
