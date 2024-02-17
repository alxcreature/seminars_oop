package domen;

public class Bottle extends Product{
    private double volume;

    public Bottle(double volume) {
        this.volume = volume;
    }

    public Bottle(long id, String name, double price, int place, double volume) {
        super(id, name, price, place);
        this.volume = volume;
    }

    public Bottle() {
        this.volume = 0;
    }

    public Bottle(String name, double price, int place, double volume) {
        super(name, price, place);
        this.volume = volume;
    }

    public Bottle(double price, int place, double volume) {
        super(price, place);
        this.volume = volume;
    }

    public Bottle(double price, int place, String name, long id, double volume) {
        super(price, place, name, id);
        this.volume = volume;
    }

    public Bottle(int place, double price) {
        //TODO Auto-generated constructor stub
    }

    public Bottle(String name, double price, int place) {
        //TODO Auto-generated constructor stub
    }

    public Bottle(long id, String name, double price, int place) {
        //TODO Auto-generated constructor stub
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nvolume=" + volume;
    }
}
