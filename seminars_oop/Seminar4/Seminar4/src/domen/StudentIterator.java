package domen;

import java.util.Iterator;
import java.util.List;

/***
 * @apiNote Класс итератора для студентов
 * @deprecated Класс не используется, вместо данного класса используйте
 *             класс-дженерик PersonIterator
 */
public class StudentIterator implements Iterator<Student>{

    private int counter;
    private List<Student> students;

    public StudentIterator(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {
        return counter < students.size();
    }

    @Override
    public Student next() {
        return students.get(counter++);
    }
}
