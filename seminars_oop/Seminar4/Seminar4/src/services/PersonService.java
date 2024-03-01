package services;

import java.util.ArrayList;
import java.util.List;

import domen.Person;
import domen.PersonComporator;

/***
 * @apiNote Дженерик класс сервисов для класса персоны и его производных
 */
public class PersonService<T extends Person> implements iPersonService<T> {
    // Счётчик студентов
    private int count = 0;
    // Список студентов
    private List<T> listPersons;

    /***
     * Конструктор списка студентов
     */
    public PersonService() {
        this.listPersons = new ArrayList<T>();
        count = 0;
    }

    /***
     * @apiNote Перегрузка метода возвращающего список студентов
     * @return List<Persons> список студентов
     */
    @Override
    public List<T> getAll() {
        return this.listPersons;
    }

    /***
     * @apiNote Перегрузка метода создания студента и добавление его в список
     * @param name имя (ФИО)
     * @param age  возраст
     */
    //@Override
    public void create(T person, String name, int age) {
        person.setName(name);
        person.setAge(age);
        this.listPersons.add(person);
        this.count++;
    }

    /**
     * @apiNote Метод сортировки студентов по ФИО (имени)
     */
    public void softByFIO() {
        this.listPersons.sort(new PersonComporator<T>());
    }

    public int getCount() {
        return count;
    }

    public List<T> getListPersons() {
        return listPersons;
    }

    public void setListPersons(List<T> listPersons) {
        this.listPersons=listPersons;
    }
}


