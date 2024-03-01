package services;

import java.util.ArrayList;
import java.util.List;

import domen.PersonComporator;
import domen.Student;

/***
 * @apiNote Класс сервисов для класса студента
 * @deprecated Класс не используется, вместо данного класса используйте
 *             класс-дженерик PersonService
 */
public class StudentService implements iPersonService<Student>{
    //Счётчик студентов
    private int count=0;
    //Список студентов
    private List<Student> listStudents;
    /***
     * Конструктор списка студентов
     */
    public StudentService() {
        this.listStudents = new ArrayList<Student>();
        count = 0;
    }
    /***
     * @apiNote Перегрузка метода возвращающего список студентов
     * @return List<Students> список студентов
     */
    @Override
    public List<Student> getAll() {
        return this.listStudents;
    }
    /***
     * @apiNote Перегрузка метода создания студента и добавление его в список
     * @param name имя (ФИО)
     * @param age возраст
     */
    @Override
    public void create(String name, int age) {
        Student newStudent = new Student(name, age);
        this.listStudents.add(newStudent);
        this.count++;
    }
    
    /**
     * @apiNote Метод сортировки студентов по ФИО (имени)
     */
    public void softByFIO(){
        //PersonComporator<Student> comporator = new PersonComporator<Student>();
        // this.listStudents.sort(comporator);
        this.listStudents.sort(new PersonComporator<Student>());
    }
}
