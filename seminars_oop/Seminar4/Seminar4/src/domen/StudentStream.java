package domen;

import java.util.Iterator;
import java.util.List;

/***
 * @apiNote Класс потока студентов состоящий из студенческих групп
 * @deprecated Класс не используется, вместо данного класса используйте
 *             класс-дженерик PersonStream
 */

public class StudentStream implements Iterable<StudentGroup>{
    private int idStream;
    private List<StudentGroup> studentGroups;

    public StudentStream(int idStream) {
        this.idStream = idStream;
    }
    public StudentStream(List<StudentGroup> studentGroups, int idStream) {
        this.idStream = idStream;
        this.studentGroups = studentGroups;
    }
    public StudentStream(List<StudentGroup> studentGroups) {
        this.studentGroups=studentGroups;
    }
    public int getIdStream() {
        return idStream;
    }
    public void setIdStream(int idStream) {
        this.idStream = idStream;
    }
    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }
    public void setStudentGroups(List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }
    @Override
    public Iterator<StudentGroup> iterator() {
        return new StudentGroupIterator(studentGroups);
    }
    @Override
    public String toString() {
        // выводить номер потока, количество групп и список студентов с указанием
        // идентификатора группы
        String temp = "";
        for (StudentGroup studentGroup : studentGroups) {
            temp+=studentGroup+"\n";
        }
        return "\nidStream=" + idStream + "\nstudentGroups=" + studentGroups.size() + "\n" + temp;
    }
}
