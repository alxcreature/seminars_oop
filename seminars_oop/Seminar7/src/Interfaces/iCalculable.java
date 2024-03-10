package Interfaces;
/***
 * @apiNote Интерфейс класса целочисленного калькулятора
 */
public interface iCalculable {
    /**
     * Метод сложения чисел
     * @param arg Второе число
     * @return ссылку на экземпляр класса калькулятора
     */
    iCalculable sum(int arg);

    /**
     * Метод умножения чисел
     * 
     * @param arg Второе число
     * @return ссылку на экземпляр класса калькулятора
     */
    iCalculable multi(int arg);

    /**
     * Метод деления чисел
     * 
     * @param arg Второе число
     * @return ссылку на экземпляр класса калькулятора
     */
    iCalculable div(int arg);

    /**
     * Метод вычетания чисел
     * 
     * @param arg Второе число
     * @return ссылку на экземпляр класса калькулятора
     */
    iCalculable sub(int arg);

    /**
     * Метод возвращает текущее значение результата
     */
    int getResult();
}
