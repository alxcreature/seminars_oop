package Controller.Interfaces;

import java.util.HashMap;
import java.util.List;

import Model.Domain.Student;
/***
 * @apiNote Интерфейс Модели
 */
public interface iGetModel {
    /**
     * Метод получения списка студентов
     * @apiNote Метод получения списка студентов
     * @return Возвращает список студентов
     */
    public List<Student> getAllStudents();
    
    /**
     * Метод получения списка студентов
     * @apiNote Метод получения списка студентов
     * @return Возвращает список студентов
     */
    public HashMap<Integer,Student> getAllHashMapStudents();
    
    /**
     * Метод удаления студента из списка
     * @apiNote Метод удаления студента из списка
     * @param id Идентификатор студента
     * @return Возвращает Истину в случае успеха
     */
    public boolean deleteStudent(int id);
    
    /**
     * Метод поиска студента по списку
     * @apiNote Метод поиска студента по списку
     * @param name Имя (ФИО)
     * @return Истина в случае успеха
     */
    public boolean findStudent(String name);
}
