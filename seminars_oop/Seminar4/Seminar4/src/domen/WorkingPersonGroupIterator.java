package domen;

import java.util.Iterator;
import java.util.List;

/***
 * @apiNote Класс итератора для группы рабочего персонала
 * @deprecated Класс не используется, вместо данного класса используйте
 *             класс-дженерик PersonIterator
 */
public class WorkingPersonGroupIterator implements Iterator<WorkingPersonGroup> {

    private int counter;
    private List<WorkingPersonGroup> workingPersonGroups;

    public WorkingPersonGroupIterator(List<WorkingPersonGroup> workingPersonGroups) {
        this.workingPersonGroups = workingPersonGroups;
    }

    @Override
    public boolean hasNext() {
        return counter < workingPersonGroups.size();
    }

    @Override
    public WorkingPersonGroup next() {
        return workingPersonGroups.get(counter++);
    }
}
