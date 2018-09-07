package examples.first;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private List<Card> playerCards;

    // 플레이어 생성
    public Player(String name) {
        this.playerName = name;
        playerCards = new ArrayList<>();
    }

    // 플레이어 초기화
    public void clear(){
        playerCards.clear();
    }

    // 플레이어에게 카드 추가하기
    public void addCard(Card card) {
        this.playerCards.add(card);
    }

    // 플레이어의 카드 꺼내기
    public List<Card> getPlayerCards() {
        return playerCards;
    }

    // 플레이어 이름 알아오기
    public String getPlayerName() {
        return playerName;
    }
}
