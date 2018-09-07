package examples.first;

public class Card {
    private int cardNumber;
    private String cardType;

    public Card(String cardType, int cardNumber) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    @Override
    public String toString() {
        String strNumber;
        switch (cardNumber){
            case 1: strNumber = "A";
                break;
            case 10: strNumber = "J";
                break;
            case 11: strNumber = "Q";
                break;
            case 12: strNumber = "K";
                break;
            default: strNumber = cardNumber + "";
        }

        return "[ " + cardType + strNumber + " ]";
    }
}
