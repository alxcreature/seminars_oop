package domen;

import java.util.Iterator;
import java.util.List;
/***
 * @apiNote Класс-дженерик итератора для персон (студентов, рабочих, преподавателей)
 */
public class PersonIterator<T extends Person> implements Iterator<T> {

    private int counter;
    private List<T> persons;

    public PersonIterator(List<T> persons) {
        this.persons = persons;
    }

    @Override
    public boolean hasNext() {
        return counter < persons.size();
    }

    @Override
    public T next() {
        return persons.get(counter++);
    }
}
