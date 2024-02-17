package domen;

public class Product {
    private long id;
    private String name;
    private double price;
    private int place;

    public Product(long id, String name, double price, int place) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.place = place;
    }

    public Product() {
        this.id = -1;
        this.name = "Неизвестно";
        this.price = -1;
        this.place = -1;
    }

    public Product(double price) {
        this();
        this.price = price;
    }

    public Product(double price, int place) {
        this(price);
        this.place = place;
    }

    public Product(String name, double price, int place) {
        this(price, place);
        this.name = name;
    }

    public Product(double price, int place, String name) {
        this(price, place);
        this.name = name;
    }

    public Product(double price, int place, String name, long id) {
        this(price, place, name);
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getPlace() {
        return place;
    }
    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "\nPrice = " + this.price + "\n" +
                "Place = " + this.place + "\n" +
                "Name = " + this.name + "\n" +
                "ID = " + this.id + "\n";
    }
}
