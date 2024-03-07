package OCP;
/***
 * @apiNote Класс экземпляра базового средства передвижения (транспорта)
 */
public class Vehicle {
    // Максимальная скорость
    private int maxSpeed;
    //Тип транспортного средства
    private String type;

    /**
     * Конструктор экземпляра класса транспортного средства
     * @param maxSpeed Максимальная скорость
     * @param type Тип транспорта
     */
    public Vehicle(int maxSpeed, String type) {
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public String getType() {
        return this.type;
    }
}