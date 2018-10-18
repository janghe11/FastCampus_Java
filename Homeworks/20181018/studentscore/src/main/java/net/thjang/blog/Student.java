package net.thjang.blog;

public class Student {
    private String name = null;
    private int literatureScore = 0;
    private int englishScore = 0;
    private int mathScore = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLiteratureScore() {
        return literatureScore;
    }

    public void setLiteratureScore(int literatureScore) {
        this.literatureScore = literatureScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }
}
