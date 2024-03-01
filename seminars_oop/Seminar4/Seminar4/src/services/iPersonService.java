package services;

import java.util.List;
/***
 * @apiNote Интерфейс сервисов для класса персоны
 */
public interface iPersonService<T> {
    /**
     * @apiNote Метод возвращает список персон
     * @return <T> Список персон
     */
    public List<T> getAll();
    //public void create(String name, int age);
    /**
     * @apiNote Метод создания записи обобщённого класса персоны или его производного в список
     * @param T person обобщённый класс
     * @param name Имя (ФИО)
     * @param age Возраст
     */
    public void create(T person, String name, int age);
    
}
