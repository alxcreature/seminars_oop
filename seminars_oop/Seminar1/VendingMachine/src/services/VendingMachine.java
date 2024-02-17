package services;

import java.util.List;

import domen.Product;

public class VendingMachine {
    private Holder holder;
    private CoinDispencer dispencer;
    private List<Product> assort;
    private Display display;

    /**
     * @apiNote Конструктор "Вендинг машины"
     * @param holder Выдача оплаченного товара
     * @param dispenser Монетоприёмник, выдача сдачи
     * @param assort Ассортимент товаров на полках
     * @param display Интеррактивный Экран
     */
    public VendingMachine(Holder holder, CoinDispencer dispenser, List<Product> assort, Display display) {
        this.holder = holder;
        this.dispencer = dispencer;
        this.assort = assort;
        this.display = display;
    }

    public List<Product> getProducts() {
        return assort;
    }

    public void buyProduct(Product p, int price) {
        if (assort.contains(p) && holder.getBalance() >= price) {
            if (dispencer.dispence(price)) {
                releaseProduct(p, holder);
                display.print("You have successfully bought " + p.getName() + ".");
            }
        } else {
            display.print("Product not available or insufficient balance.");
        }
    }

    public void releaseProduct(Product p, Holder h) {
        h.release(0, 0);
        assort.remove(p);
    }

    public void cancel() {
        dispencer.giveChahge(0, 0);
    }

    public Holder getHolder() {
        return holder;
    }

    public CoinDispencer getDispencer() {
        return dispencer;
    }

    public List<Product> getAssort() {
        return assort;
    }

    public Display getDisplay() {
        return display;
    }

}
