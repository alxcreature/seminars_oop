package DIP;
import OCP.Vehicle;

/***
 * @apiNote Класс экземпляра автобуса с расширяемым классом средства
 *          передвижения и имплементируемым интерфейсом функционала класса
 *          двигателя
 */
public class Bus extends Vehicle implements iEngine<Engine>{
    //Инициализация типа двигателя (дизель, бензин)
    private Engine egine = new Engine("Diesel");
    
    /**
     * Конструктор указания типа транспорта и его максимальной скорости
     * @param maxSpeed
     */
    public Bus(int maxSpeed) {
        super(maxSpeed, "Bus");
    }

    /**
     * Запуск двигателя автобуса через экземпляр двигателя
     */
    public void start(){
        this.egine.start();
    }
    
}
