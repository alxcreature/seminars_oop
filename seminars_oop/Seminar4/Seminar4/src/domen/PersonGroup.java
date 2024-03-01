package domen;

import java.util.Iterator;
import java.util.List;

/***
 * @apiNote Класс-дженерик определяющий поведение группы, базовый, расширенный от базового класса персоны
 */
public class PersonGroup<T extends Person> implements Iterable<T>, Comparable<PersonGroup<T>> {
    private int idPersonGroup;
    private List<T> persons;

    public PersonGroup(int idPersonGroup, List<T> persons) {
        this.idPersonGroup = idPersonGroup;
        this.persons = persons;
    }

    public int getIdPersonGroup() {
        return idPersonGroup;
    }

    public void setIdPersonGroup(int idPersonGroup) {
        this.idPersonGroup = idPersonGroup;
    }

    public List<T> getPersonList() {
        return persons;
    }

    public void setPersonList(List<T> persons, int idPersonGroup) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        String temp;
        temp = "";
        for (Person Person : persons) {
            temp += Person + "\n";
        }
        return "\nidPersonGroup=" + idPersonGroup + "\nPersonsCount="
                + getPersonList().size()
                + "\n" + temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator<T>(persons);
    }

    /***
     * @apiNote Метод перегрузки сравнения группы по размеру списка, затем по ноиеру идентификатора
     * для дальнейшей сортировки
     */
    @Override
    public int compareTo(PersonGroup<T> o) {
        if (this.getPersonList().size() > o.getPersonList().size()) {
            return 1;
        }
        if (this.getPersonList().size() < o.getPersonList().size()) {
            return -1;
        }
        if (this.getPersonList().size() == o.getPersonList().size()) {
            if (this.getIdPersonGroup() < o.getIdPersonGroup()) {
                return -1;
            }
            if (this.getIdPersonGroup() > o.getIdPersonGroup()) {
                return 1;
            }
        }
        return 0;
    }
}
