import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controls.AccountControler;
import domen.Employee;
import domen.PersonGroup;
import domen.PersonStream;
import domen.Student;
import domen.Teacher;
import domen.WorkingPerson;
import services.PersonService;


public class App {
    public static void main(String[] args) throws Exception {
        //Создание и наполнение списка студентов первой, второй групп
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

        //Создание 1 группы студентов
        PersonGroup<Student> studentGroup1 = new PersonGroup<Student>(2,students1);

        for (Student student : studentGroup1){
            System.out.println("student = " + student);
        }
        System.out.println("_________________________1я_группа_студентов__________________________");
        Collections.sort(studentGroup1.getPersonList());
        for (Student student : studentGroup1){
            System.out.println("student = " + student);
        }
        List<Student> students2 = new ArrayList<>();
        students2.add(student8);
        students2.add(student9);
        students2.add(student10);
        students2.add(student11);
        students2.add(student12);

        PersonGroup<Student> studentGroup2 = new PersonGroup<Student>(1, students2);
        System.out.println("_________________________2я_группа_студентов__________________________");
        for (Student student : studentGroup2) {
            System.out.println("student = " + student);
        }
        System.out.println("___________________________________________________");
        Collections.sort(studentGroup2.getPersonList());
        for (Student student : studentGroup2) {
            System.out.println("student = " + student);
        }
        System.out.println("===================================================");
        
        //Создание и наполнение списка групп студентов
        List<PersonGroup<Student>> studentGroups = new ArrayList<>();
        studentGroups.add(studentGroup1);
        studentGroups.add(studentGroup2);

        //Создание потока (направления) студентов из списка групп студентов
        PersonStream<PersonGroup<Student>> studentStream = new PersonStream<PersonGroup<Student>>(studentGroups, 5);
        System.out.println(studentStream);
        System.out.println("________________________Оригинал_потока_групп_студентов___________________________");
        Collections.sort(studentStream.getPersonGroups());
        System.out.println(studentStream);
        System.out.println("_______________________Сортированный_поток_групп_студентов________________________");

        //Печать среднего возраста студентов по группам
        System.out.print("Студенты группа №1:");
        AccountControler.averageAge(students1);
        System.out.print("Студенты группа №2:");
        AccountControler.averageAge(students2);
        System.out.println("____________________Средний_возраст_в_студентческих_группах_______________________");

        //Создание и наполнение отдельных списков наёмных рабочих и преподавателей
        Employee employee1 = new Employee("Vasily", 50, "Разнорабочий");
        Employee employee2 = new Employee("Sergio", 55, "Завхоз");
        Employee employee3 = new Employee("Arambek", 60, "Дворник");
        Employee employee4 = new Employee("Roman", 42, "Сантехник");
        Employee employee5 = new Employee("Gaspar", 38, "Электрик");
        Teacher teacher1 = new Teacher("Olga Grigorievna", 60, "Доцент");
        Teacher teacher2 = new Teacher("Antonana Vasilievna", 55, "КТН");
        Teacher teacher3 = new Teacher("Hristina Valerievna", 45, "Доктор");
        Teacher teacher4 = new Teacher("Ulia Beda", 30, "Специалист");
        Teacher teacher5 = new Teacher("Zoya Belalovna", 80, "Заслуженный герой труда");

        List<WorkingPerson> employeers = new ArrayList<>();
        employeers.add(employee1);
        employeers.add(employee2);
        employeers.add(employee3);
        employeers.add(employee4);
        employeers.add(employee5);
        List<WorkingPerson> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);
        teachers.add(teacher5);
        
        //Создание и наполнение отдельных списков групп наёмных рабочих и преподавателей
        List<PersonGroup<WorkingPerson>> workersGroups = new ArrayList<>();
        PersonGroup<WorkingPerson> employeeGroup = new PersonGroup<WorkingPerson>(1, employeers);
        workersGroups.add(employeeGroup);
        PersonGroup<WorkingPerson> teacherGroup = new PersonGroup<WorkingPerson>(2, teachers);
        workersGroups.add(teacherGroup);

        //Создание потока (направления) рабочего персонала из групп
        PersonStream<PersonGroup<WorkingPerson>> workersStream = new PersonStream<PersonGroup<WorkingPerson>>(workersGroups, 5);
        
        System.out.println(workersStream);
        System.out.println("_____________________Оригинал_списка_рабочего_персонала______________________");
        //Сортировка по возрасту (по умолчанию)
        Collections.sort(employeeGroup.getPersonList());
        Collections.sort(teacherGroup.getPersonList());
        System.out.println(workersStream);
        System.out.println("_____________Сортированный_список_рабочего_персонала__(по_возрасту)__________");
        
        //Создание дополнительного сервиса для рабочего персонала
        PersonService<WorkingPerson> psEmployees = new PersonService<>();
        psEmployees.setListPersons(employeers);
        //Сортировка по ФИО
        psEmployees.softByFIO();

        PersonService<WorkingPerson> psTeachers = new PersonService<>();
        psTeachers.setListPersons(teachers);
        psTeachers.softByFIO();

        //Сортировка групп по количеству персонала в группе
        Collections.sort(workersStream.getPersonGroups());
        System.out.println(workersStream);
        System.out.println("_____________Сортированный_список_рабочего_персонала__(ФИО)___________");

        //Выдача ЗП персоналу, печать на экран
        AccountControler.paySalary(employee1, 1000);
        AccountControler.paySalary(teacher1, 2000);
        System.out.println("__________________Пример_выплаты_ЗП_рабочему_персоналу_______________");
        
        //Рассчёт и вывод на печать среднего возраста по типу группы персонала
        System.out.print("Наёмные рабочие:");
        AccountControler.averageAge(employeers);
        System.out.print("Преподаватели:");
        AccountControler.averageAge(teachers);
        System.out.println("____________________Средний_возраст_рабочего_персонала_____________________");
    }
}
