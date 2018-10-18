package net.thjang.blog;

import java.util.List;

public class Game {
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void play() {
        int faceScore = 0;
        int maxScore = 0;
        String bestPlayer = null;

        for (Player player : players) {
            faceScore = player.play();
            System.out.println(player.getName() + "의 점수 : " + faceScore);

            if (faceScore > maxScore) {
                maxScore = faceScore;
                bestPlayer = player.getName();
            }
        }

        System.out.println(bestPlayer + "의 점수가 가장 높습니다." + maxScore + "점");
    }
}
