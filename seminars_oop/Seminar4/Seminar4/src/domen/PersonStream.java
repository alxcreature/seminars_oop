package domen;

import java.util.Iterator;
import java.util.List;
/***
 * @apiNote Класс-дженерик потока персон (студентов, рабочих, преподавателей)
 */
public class PersonStream<T> implements Iterable<T> {
    private int idStream;
    private List<T> personGroups;

    public PersonStream(int idStream) {
        this.idStream = idStream;
    }

    public PersonStream(List<T> personGroups, int idStream) {
        this.idStream = idStream;
        this.personGroups = personGroups;
    }

    public PersonStream(List<T> personGroups) {
        this.personGroups = personGroups;
    }

    public int getIdStream() {
        return idStream;
    }

    public void setIdStream(int idStream) {
        this.idStream = idStream;
    }

    public List<T> getPersonGroups() {
        return personGroups;
    }

    public void setPersonGroups(List<T> personGroups) {
        this.personGroups = personGroups;
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator(personGroups);
    }

    @Override
    public String toString() {
        // выводить номер потока, количество групп и список студентов с указанием
        // идентификатора группы
        String temp = "";
        for (T personGroup : personGroups) {
            temp += personGroup + "\n";
        }
        return "\nidStream=" + idStream + "\npersonGroups=" + personGroups.size() + "\n" + temp;
    }
}
