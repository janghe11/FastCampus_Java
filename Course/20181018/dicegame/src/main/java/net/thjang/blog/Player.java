package net.thjang.blog;

public class Player {
    private String name;
    private Dice dice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public int play() {
        return dice.getNumber();
    }
}
