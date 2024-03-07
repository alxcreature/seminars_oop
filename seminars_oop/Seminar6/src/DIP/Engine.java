package DIP;
/***
 * @apiNote Базовый класс экземпляра двигателя
 */
public class Engine {
    private String typeEngine;

    public String getTypeEngine() {
        return typeEngine;
    }

    public Engine(String typeEngine) {
        this.typeEngine = typeEngine;
    }

    /**
     * Запуск двигателя экемпляра класса
     */
    public void start() {
            System.out.println("Brbrbrbrrrr....:"+typeEngine);
    }

}
