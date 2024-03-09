package DIP;
/***
 * @apiNote Базовый класс экземпляра двигателя
 */
public interface Engine {
    /**
     * Запуск экемпляра класса двигателя
     */
    public void start();
    public Engine getEngine();
}
