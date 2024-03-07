package ISPLSP;
/***
 * Класс экземпляра куба имплементируемый от интерфейса фигуры и объёмной фигуры
 */
public class Cube implements Shape, ShapeVolume {
    private int edge;

    public Cube(int edge) {
        this.edge = edge;
    }

    @Override
    public double area() {
        return 6 * edge * edge;
    }

    @Override
    public double volume() {
        return edge * edge * edge;
    }

    @Override
    public String toString() {
        return "Cube [edge=" + edge + " area=" + area() + " volume=" + volume() +"]";
    }
}