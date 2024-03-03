package Model;

import java.util.HashMap;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

/***
 * @apiNote Класс модели
 */
public class ModelClass implements iGetModel {
    
    private List<Student> students;
    //private HashMap<Integer,Student> studentssHashMap;

    /**
     * Конструктор класса модели
     * 
     * @apiNote Конструктор класса модели
     * @param students Список студентов
     */
    public ModelClass(List<Student> students) {
        this.students = students;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public HashMap<Integer, Student> getAllHashMapStudents() {
        return null;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean flag = false;
        for (int i=0; i<students.size(); i++) {
            if (students.get(i).getId()==id){
                students.remove(i);
                flag = true;
            }
        }
        return flag;
    }
    @Override
    public boolean findStudent(String name) {
        boolean flag = false;
        for (Student student : students) {
            if (student.getName().contains(name)){
                flag=true;
                break;
            }
        }
        return flag;
    }
}
