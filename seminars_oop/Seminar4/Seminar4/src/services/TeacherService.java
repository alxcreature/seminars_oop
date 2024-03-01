package services;

import java.util.List;

import domen.PersonComporator;
import domen.Teacher;

/***
 * @apiNote Класс сервисов для класса преподавателя
 * @deprecated Класс не используется, вместо данного класса используйте
 *             класс-дженерик PersonService
 */
public class TeacherService extends PersonComporator<Teacher> implements iPersonService<Teacher>{
    //Счётчик преподавателей
    private int count=0;
    //Список преподавателей
    private List<Teacher> listTeacher;

    /***
     * Конструктор списка преподавателей
     */
    public TeacherService(int count) {
        this.count = count;
    }

    /***
     * @apiNote Перегрузка метода возвращающего список преподавателей
     * @return List<Teacher> список преподавателей
     */
    @Override
    public void create(String name, int age) {
        Teacher newTeacher = new Teacher(name, age, "teacher");
        this.listTeacher.add(newTeacher);
        this.count++;
    }

    /***
     * @apiNote Перегрузка метода создания преподавателя и добавление его в список
     * @param name имя (ФИО)
     * @param age  возраст
     */
    @Override
    public List<Teacher> getAll() {
        return listTeacher;
    }

    /**
     * @apiNote Метод сортировки преподавателей по ФИО (имени)
     */
    
    public void sortByFIO(){
        this.listTeacher.sort(new PersonComporator<Teacher>());
    }

}