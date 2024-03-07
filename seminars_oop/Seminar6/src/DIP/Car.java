package DIP;
import OCP.Vehicle;

/***
 * @apiNote Класс автомобиля расширенный от класа транспорта и имплементированный экземпляр класса двигателя
 */
public class Car extends Vehicle implements iEngine<Engine>{
    //Варианты создания типа двигателя транспорта. ПРИМЕР!!!
    private Engine engine = new Engine("Petrol");
    private Engine engine1 = new PetrolEngine();
    private Engine engine2 = new DieselEngine();
    
    /**
     * Конструктор типа транспорта автомобиль с указанием максимальной скорости передвижения
     * @param maxSpeed
     */
    public Car(int maxSpeed) {
        super(maxSpeed, "Car");
    }

    /**
     * Запуск всех типовых экземпляров двигателей автомобиля
     */
    public void start() {
        this.engine.start();
        this.engine1.start();
        this.engine2.start();
    }
}
