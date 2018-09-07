package examples.first;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    public static void main(String args[]) {
        /**
         * List<카드> 카드묶음 = 카드공장.create();
         *
         * 딜러 d = new 딜러(이름);
         *
         */
        // 카드를 생성한다.
        List<Card> cardList = CardFactory.create();

        // 플레이어를 생성한다.
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player("짝귀"));
        playerList.add(new Player("아귀"));
        playerList.add(new Player("평강장"));

        // 딜러를 생성한다.
        Dealer dealer = new Dealer("고니", playerList, cardList);

        // 새 게임
        dealer.newGame();

        // 딜러가 카드를 섞는다.
        dealer.mix();

        // 섞인 카드를 한 장씩 나누어준다. x5
        for (int i = 0; i < 5; i++) {
            for (Player player : playerList) {
                player.addCard(dealer.getCards());
            }
        }

        // 카드를 확인한다
        dealer.open();

        // 승자
        dealer.result();
        }
}
