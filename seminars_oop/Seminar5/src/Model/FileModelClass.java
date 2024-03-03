package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

/***
 * @apiNote Класс файловой модели списка студентов
 */
public class FileModelClass implements iGetModel {
    private String fileName;
    List<Student> students = new ArrayList<Student>();
    HashMap<Integer, Student> studentsHashMap = new HashMap<>();

    /**
     * Конструктор класса файловой модели
     * 
     * @apiNote Конструктор класса файловой модели
     * @param fileName Имя файла
     */
    public FileModelClass(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод сохранения списка студентов в файл
     * 
     * @apiNote Метод сохранения списка студентов в файл
     * @param students Список студентов
     */
    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, false))
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+" "+pers.getAge()+" "+pers.getId());
                fw.append('\n');
            }
            fw.flush();
            this.students=students;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        if (students==null || students.isEmpty()) {
            try
            {
                File file = new File(fileName);
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                //Student.resetId();
                while(line!=null)
                {
                    String[] param = line.split(" ");
                    Student pers = new Student(param[0], Integer.parseInt(param[1]));
                    students.add(pers);
                    line = reader.readLine();
                }
                reader.close();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        return students;
    }

    @Override
    public HashMap<Integer, Student> getAllHashMapStudents() {
        if (studentsHashMap==null && students==null) {
            try {
                int lineCount=0;
                File file = new File(fileName);
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                //Student.resetId();
                while (line != null) {
                    String[] param = line.split(" ");
                    Student pers = new Student(param[0], Integer.parseInt(param[1]));
                    studentsHashMap.put(lineCount, pers);
                    line = reader.readLine();
                    lineCount++;
                }
                reader.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            if (students!=null || !students.isEmpty()){
                for (int i = 0; i < students.size(); i++) {
                    studentsHashMap.put(i+1, students.get(i));
                }
            }
        }
        return studentsHashMap;
    }

    @Override
    public boolean deleteStudent(int id) {
        List<Student> students = new ArrayList<Student>(this.getAllStudents());
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                flag = true;
            }
        }
        this.saveAllStudentToFile(students);
        return flag;
    }

    @Override
    public boolean findStudent(String name) {
        List<Student> students = new ArrayList<Student>(this.getAllStudents());
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
