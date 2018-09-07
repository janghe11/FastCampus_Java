package examples.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
    private String name;
    private List<Player> players;
    private List<Card> cards;
    private int index = 0;
    private int cardSum = 0;
    private List<Integer> playerSum = new ArrayList<>();

    // Dealer의 기본 정보 가져오기
    public Dealer(String name, List<Player> players, List<Card> cards) {
        this.name = name;
        this.players = players;
        this.cards = cards;
    }

    // 딜러 및 플레이어의 카드 초기화
    public void newGame() {
        for (Player player : players) {
            player.clear();
        }

    }

    // 카드 섞기
    public void mix() {
        Collections.shuffle(cards);
    }

    // 카드 꺼내기
    public Card getCards() {
        Card card = cards.get(index++);
        return card;
    }

    // 카드 확인
    public void open() {
        for (Player player : players) {
            System.out.print(player.getPlayerName() + ": ");
            for (index = 0; index < 5; index++) {
                System.out.print(player.getPlayerCards().get(index).getCardNumber() + " ");
                cardSum += player.getPlayerCards().get(index).getCardNumber();

            }
            playerSum.add(cardSum);
            cardSum = 0;
//            System.out.print(playerSum);
            System.out.println("");
        }
    }

    // 승자 확인
    public void result() {
//        System.out.println(Collections.max(playerSum));
        for (int i = 0; i < playerSum.size(); i++) {
            if (Collections.max(playerSum) == playerSum.get(i)) {
                System.out.println("승자: " + players.get(i).getPlayerName());
            }
        }
    }
}
