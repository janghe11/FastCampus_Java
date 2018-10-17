package my.examples.arc.servlet;

public class ArcDto {
    private int idx;
    private String id;
    private int idxCode;
    private int investPeriod;
    private int myPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdxCode() {
        return idxCode;
    }

    public void setIdxCode(int idxCode) {
        this.idxCode = idxCode;
    }

    public int getInvestPeriod() {
        return investPeriod;
    }

    public void setInvestPeriod(int investPeriod) {
        this.investPeriod = investPeriod;
    }

    public int getMyPrice() {
        return myPrice;
    }

    public void setMyPrice(int myPrice) {
        this.myPrice = myPrice;
    }
}
