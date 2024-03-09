package DIP;
import OCP.Vehicle;

/***
 * @apiNote Класс экземпляра автобуса с расширяемым классом средства
 *          передвижения и имплементируемым интерфейсом функционала класса
 *          двигателя
 */
public class Bus extends Vehicle implements Engine{
    //Инициализация типа двигателя (дизель, бензин)
    private Engine engine;// = new DieselEngine();
    
    /**
     * Конструктор указания типа транспорта и его максимальной скорости
     * @param maxSpeed
     */
    public Bus(Engine engine, int maxSpeed) {
        super(maxSpeed, "Bus");
        this.engine=engine;
    }

    /**
     * Запуск двигателя автобуса через экземпляр двигателя
     */
    public void start(){
        System.out.print("Bus.start()=");
        this.engine.start();
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }
}
