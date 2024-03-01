package domen;

import java.util.Iterator;
import java.util.List;

/***
 * @apiNote Класс группы студентов
 * @deprecated Класс не используется, вместо данного класса используйте
 *             класс-дженерик PersonGroup
 */

public class StudentGroup implements Iterable<Student>, Comparable<StudentGroup>{
    private int idStudentGroup;
    private List<Student> studentList;
    public StudentGroup(int idStudentGroup, List<Student> studentList) {
        this.idStudentGroup = idStudentGroup;
        this.studentList = studentList;
    }
    public int getIdStudentGroup() {
        return idStudentGroup;
    }
    public void setIdStudentGroup(int idStudentGroup) {
        this.idStudentGroup = idStudentGroup;
    }
    public List<Student> getStudentList() {
        return studentList;
    }
    public void setStudentList(List<Student> studentList, int idStudentGroup) {
        this.studentList = studentList;
    }
    @Override
    public String toString() {
        String temp;
        temp = "";
        for (Student student : studentList) {
            temp+=student+"\n";
        }
        return "\nidStudentGroup=" + idStudentGroup + "\nstudentsCount=" + getStudentList().size()
                + "\n" + temp;
    }
    @Override
    public Iterator<Student> iterator() {
        return new PersonIterator<Student>(studentList);
    }
    @Override
    public int compareTo(StudentGroup o) {
        if (this.getStudentList().size()>o.getStudentList().size()) {
            return 1;
        }
        if (this.getStudentList().size()<o.getStudentList().size()) {
            return -1;
        }
        if (this.getStudentList().size()==o.getStudentList().size()) {
            if (this.getIdStudentGroup()<o.getIdStudentGroup()) {
                return -1;
            }
            if (this.getIdStudentGroup()>o.getIdStudentGroup()) {
                return 1;
            }
        }
        return 0;
    }
}
