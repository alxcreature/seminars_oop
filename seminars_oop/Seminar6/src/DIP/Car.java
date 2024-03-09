package DIP;
import OCP.Vehicle;

/***
 * @apiNote Класс автомобиля расширенный от класа транспорта и имплементированный экземпляр класса двигателя
 */
public class Car extends Vehicle implements Engine{
    //Создания типа двигателя транспорта (бензиновый).
    private Engine engine;// = new PetrolEngine();
    
    /**
     * Конструктор типа транспорта автомобиль с указанием максимальной скорости передвижения
     * @param maxSpeed
     */
    public Car(Engine engine, int maxSpeed) {
        super(maxSpeed, "Car");
        this.engine=engine;
    }

    /**
     * Запуск всех типовых экземпляров двигателей автомобиля
     */
    public void start() {
        System.out.print("Car.start()=");
        this.engine.start();
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }
}
