package DIP;
/***
 * @apiNote Класс экземпляра дизельного двигателя
 */
public class DieselEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Diesel engine start");
    }
    @Override
    public Engine getEngine() {
        return this;
    }
}
