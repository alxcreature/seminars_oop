package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

/***
 * @apiNote Класс модели списком отображения
 */
public class ModelClassHash implements iGetModel {

    private HashMap<Integer,Student> students;

    /**
     * Конструктор класса
     * 
     * @apiNote Конструктор класса
     * @param students Список студентов
     */
    public ModelClassHash(HashMap<Integer,Student> students) {
        this.students = students;
    }

    public HashMap<Integer,Student> getAllHashMapStudents() {
        return students;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentsList = new ArrayList<>();
        for (Map.Entry<Integer,Student> student : students.entrySet()){
            studentsList.add(student.getValue());
        };
        return studentsList;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean flag = false;
        List<Integer> removeList = new ArrayList<>();
        for (Map.Entry<Integer,Student> student : students.entrySet()){
            if (student.getValue().getId()==id){
                removeList.add(student.getKey());
                flag = true;
            }
        }
        if (flag) {
            for (int i=0; i<removeList.size(); i++) students.remove(removeList.get(i));
        }
        return flag;
    }
    @Override
    public boolean findStudent(String name) {
        boolean flag = false;
        for (Map.Entry<Integer,Student> student: students.entrySet()){
            if (student.getValue().getName().contains(name)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
