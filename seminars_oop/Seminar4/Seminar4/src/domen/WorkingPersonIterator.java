package domen;

import java.util.Iterator;
import java.util.List;

/***
 * @apiNote Класс итератора для рабочего персонала
 * @deprecated Класс не используется, вместо данного класса используйте
 *             класс-дженерик PersonIterator
 */

public class WorkingPersonIterator implements Iterator<WorkingPerson> {

    private int counter;
    private List<WorkingPerson> workingPersons;

    public WorkingPersonIterator(List<WorkingPerson> workingPersons) {
        this.workingPersons = workingPersons;
    }

    @Override
    public boolean hasNext() {
        return counter < workingPersons.size();
    }

    @Override
    public WorkingPerson next() {
        return workingPersons.get(counter++);
    }
}
