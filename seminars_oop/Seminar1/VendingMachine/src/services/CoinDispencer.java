package services;

public class CoinDispencer {
    private int nominal;

    public CoinDispencer(int nominal){
        this.nominal=nominal;
      }

    public String toString() {
        return "Номинал монеты равен " + nominal;
    }

    public int getSumm(int insertCoin, int outCoin) {
        int summCoin;
        summCoin = insertCoin + outCoin;
        return summCoin;
    }

    public int giveChahge(int summCoin, int price) {
        int change;
        if (price < summCoin) {
            change = summCoin - price;
        } else if (price == summCoin) {
            change = summCoin - price;
        } else
            change = 0;
        return change;
    }

    public boolean dispence(int price) {
        return false;
    }
    
}
