package bo;

public class Constellation {

    private String cName;
    private int starCount;
    private int cID;
    private int area;
    private String symbol;
    private String starList;

    public Constellation(String cName, int starCount, int cID, int area, String symbol, String starList) {
        this.cName = cName;
        this.starCount = starCount;
        this.cID = cID;
        this.area = area;
        this.symbol = symbol;
        this.starList = starList;
    }
}
