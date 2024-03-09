package DIP;
/***
 * @apiNote Класс экземпляра бензиного двигателя
 */
public class PetrolEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Petrol engine start");
    }
    @Override
    public Engine getEngine() {
        return this;
    }
}
