package View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

/***
 * Класс визуализации
 * 
 * @apiNote Класс визуализации
 */
public class ViewClass implements iGetView {
/***
 * Блок сообщений на региональном языке
 */
    private String msgPrompt ="Введите команду: ";
    private String msgExit="Выход из программы!";
    private String msgStudentsListEmpty="Список студентов пуст!";
    private String msgDeleteInputId = "Введите идентификатор студента для удаления: ";
    private String msgIdNotFound = "Идентификатор не найден!";
    private String msgHelpCommands = "\nПомощь:\nhelp (по умолчанию)\t\t\t- (эта команда) список команд.\nlist\t\t\t\t\t- вывести список.\ndelete ->id\t\t\t\t- удалить запись по ID.\nexit\t\t\t\t\t- выход из программы.\n" + //
                                        "find\t\t\t\t\t- найти студента по Имени (ФИО).";
    private String msgFindStudent = "Найти студента по Имени (ФИО): ";
    private String msgStudentFoundInList = "Студент найден в следующем списке: ";

    public void printAllStudents(List<Student> students)
    {
        System.out.println("--------------------Список студентов-------------------");
        for(Student s: students)
        {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------");
    }
    
    public void printAllStudents(HashMap<Integer,Student> students) {
        System.out.println("--------------------Список студентов-------------------");
        for (Map.Entry<Integer,Student> s : students.entrySet()) {
            System.out.println(s.getValue());
        }
        System.out.println("-------------------------------------------------------");
    }

    public String prompt(String msg)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }

    public String getMsgPrompt() {
        return msgPrompt;
    }

    public String getMsgExit() {
        return msgExit;
    }

    public String getMsgStudentsListEmpty() {
        return msgStudentsListEmpty;
    }

    @Override
    public String getMsgDeleteInputId() {
        return msgDeleteInputId;
    }

    @Override
    public String getMsgIdNotFound() {
        return msgIdNotFound;
    }

    @Override
    public String getMsgHelpCommands() {
        return msgHelpCommands;
    }

    @Override
    public String getMsgFindStudent() {
        return msgFindStudent;
    }
    
    @Override
    public String getMsgStudentFoundInList() {
        return msgStudentFoundInList;
    }

}
