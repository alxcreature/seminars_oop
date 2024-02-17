package domen;

public class HotDrinks extends Bottle{
    private int temperature;

    public HotDrinks() {
        this.temperature = -255;
    }

    public HotDrinks(long id, String name, double price, int place, double volume, int temperature) {
        super(id, name, price, place, volume);
        this.temperature = temperature;
    }

    public HotDrinks(int temperature) {
        this.temperature = temperature;
    }

    public HotDrinks(double price, int temperature) {
        super(price);
        this.temperature = temperature;
    }

    public HotDrinks(int place, double price, int temperature) {
        super(place, price);
        this.temperature = temperature;
    }

    public HotDrinks(String name, double price, int place, int temperature) {
        super(name, price, place);
        this.temperature = temperature;
    }

    public HotDrinks(long id, String name, double price, int place, int temperature) {
        super(id, name, price, place);
        this.temperature = temperature;
    }

    public HotDrinks(double price, int place, String name, long id, double volume, int temperature) {
        super(id, name, price, place, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return super.toString() + "\ntemperature = " + temperature;
    }
    
}
