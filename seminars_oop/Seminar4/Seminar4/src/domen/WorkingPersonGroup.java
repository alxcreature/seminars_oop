package domen;

import java.util.Iterator;
import java.util.List;
/***
 * @apiNote Класс группы рабочего персонала
 * @deprecated Класс не используется, вместо данного класса используйте
 *             класс-дженерик PersonGroup

 */
public class WorkingPersonGroup implements Iterable<WorkingPerson>, Comparable<WorkingPersonGroup> {
    private int idWorkingPersonGroup;
    private List<WorkingPerson> workingPersons;

    public WorkingPersonGroup(int idWorkingPersonGroup, List<WorkingPerson> workingPersons) {
        this.idWorkingPersonGroup = idWorkingPersonGroup;
        this.workingPersons = workingPersons;
    }

    public int getIdWorkingPersonGroup() {
        return idWorkingPersonGroup;
    }

    public void setIdWorkingPersonGroup(int idWorkingPersonGroup) {
        this.idWorkingPersonGroup = idWorkingPersonGroup;
    }

    public List<WorkingPerson> getWorkingPersonList() {
        return workingPersons;
    }

    public void setWorkingPersonList(List<WorkingPerson> workingPersons, int idWorkingPersonGroup) {
        this.workingPersons = workingPersons;
    }

    @Override
    public String toString() {
        String temp;
        temp = "";
        for (WorkingPerson WorkingPerson : workingPersons) {
            temp += WorkingPerson + "\n";
        }
        return "\nidWorkingPersonGroup=" + idWorkingPersonGroup + "\nWorkingPersonsCount=" + getWorkingPersonList().size()
                + "\n" + temp;
    }

    @Override
    public Iterator<WorkingPerson> iterator() {
        return new PersonIterator<WorkingPerson>(workingPersons);
    }

    @Override
    public int compareTo(WorkingPersonGroup o) {
        if (this.getWorkingPersonList().size() > o.getWorkingPersonList().size()) {
            return 1;
        }
        if (this.getWorkingPersonList().size() < o.getWorkingPersonList().size()) {
            return -1;
        }
        if (this.getWorkingPersonList().size() == o.getWorkingPersonList().size()) {
            if (this.getIdWorkingPersonGroup() < o.getIdWorkingPersonGroup()) {
                return -1;
            }
            if (this.getIdWorkingPersonGroup() > o.getIdWorkingPersonGroup()) {
                return 1;
            }
        }
        return 0;
    }
}
