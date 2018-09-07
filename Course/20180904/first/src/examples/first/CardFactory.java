package examples.first;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    // 카드를 만든다
    private CardFactory() {}

    public static List<Card> create() {
        List<Card> list = new ArrayList<>();


        String[] types = new String[]{"하트", "스페이스", "다이아", "스페이스"};
        for (String type : types) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(type, i);
                list.add(card);
            }
        }
//        for (int allCards = 1; allCards <= 3; allCards++) {
//            for (int i = 1; i < 13; i++) {
//                Card card = new Card(i);
//                list.add(card);
//            }
//        }

        return list;
    }
}
