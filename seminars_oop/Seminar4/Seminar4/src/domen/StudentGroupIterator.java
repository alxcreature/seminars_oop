package domen;

import java.util.Iterator;
import java.util.List;

/***
 * @apiNote Класс итератора для группы студентов
 * @deprecated Класс не используется, вместо данного класса используйте
 *             класс-дженерик PersonIterator
 */
public class StudentGroupIterator implements Iterator<StudentGroup>{

    private int counter;
    private List<StudentGroup> studentGroups;
    
    public StudentGroupIterator(List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    @Override
    public boolean hasNext() {
        return counter < studentGroups.size();
    }

    @Override
    public StudentGroup next() {
        return studentGroups.get(counter++);    
    }
}
