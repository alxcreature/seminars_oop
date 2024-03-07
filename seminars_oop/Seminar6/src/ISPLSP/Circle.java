package ISPLSP;
/***
 * Класс экземпляра круга имплементируемый от интерфейса фигуры
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + " area=" + area() + "]";
    }
}

