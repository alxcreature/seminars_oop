package DIP;
/***
 * @apiNote Класс расширяющий сервисный функционал класса двигателя (на текущий момент не используется)
 */
public class EngineService<E extends Engine>{
    private E engine;

    public E getEngine() {
        return engine;
    }

    public void setEngine(E engine) {
        this.engine = engine;
    }

    public EngineService(E engine) {
        this.engine = engine;
    }
}
