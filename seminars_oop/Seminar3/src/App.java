import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domen.Student;
import domen.StudentGroup;
import domen.StudentStream;

public class App {
    public static void main(String[] args) throws Exception {
        List<Student> students1 = new ArrayList<>();
        Student student1 = new Student("Ivan", 20);
        Student student2 = new Student("Anna", 21);
        Student student3 = new Student("Vova", 19);
        Student student4 = new Student("Sergei", 22);
        Student student5 = new Student("Dima", 20);
        Student student6 = new Student("Mikhail", 24);
        Student student7 = new Student("Sofia", 23);
        Student student8 = new Student("Vadim", 18);
        Student student9 = new Student("Jaroslav", 22);
        Student student10 = new Student("Maxim", 21);
        Student student11 = new Student("Yulia", 28);
        Student student12 = new Student("Anatoly", 22);

        students1.add(student1);
        students1.add(student2);
        students1.add(student3);
        students1.add(student4);
        students1.add(student5);
        students1.add(student6);
        students1.add(student7);

        StudentGroup studentGroup1 = new StudentGroup(2,students1);

        for (Student student : studentGroup1){
            System.out.println("student = " + student);
        }
        System.out.println("___________________________________________________");
        Collections.sort(studentGroup1.getStudentList());
        for (Student student : studentGroup1){
            System.out.println("student = " + student);
        }
        List<Student> students2 = new ArrayList<>();
        students2.add(student8);
        students2.add(student9);
        students2.add(student10);
        students2.add(student11);
        students2.add(student12);

        StudentGroup studentGroup2 = new StudentGroup(1, students2);
        System.out.println("___________________________________________________");
        for (Student student : studentGroup2) {
            System.out.println("student = " + student);
        }
        System.out.println("___________________________________________________");
        Collections.sort(studentGroup2.getStudentList());
        for (Student student : studentGroup2) {
            System.out.println("student = " + student);
        }
        System.out.println("===================================================");
        
        List<StudentGroup> studentGroups = new ArrayList<>();
        studentGroups.add(studentGroup1);
        studentGroups.add(studentGroup2);

        StudentStream studentStream = new StudentStream(studentGroups, 5);
        System.out.println(studentStream);
        System.out.println("___________________________________________________");
        Collections.sort(studentStream.getStudentGroups());
        System.out.println(studentStream);
    }
}
