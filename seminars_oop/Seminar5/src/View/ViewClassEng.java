package View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

/***
 * Класс визуализации на EN региональном языке
 * 
 * @apiNote Класс визуализации на EN региональном языке
 */

public class ViewClassEng implements iGetView {
    
    private String msgPrompt = "Input command: ";
    private String msgExit = "Programm exit!";
    private String msgStudentsListEmpty = "Students list is empty!";
    private String msgDeleteInputId = "Input the student id which delete: ";
    private String msgIdNotFound = "ID not found!";
    private String msgHelpCommands = "\nHelp:\nhelp (default)\t\t\t\t- (this) command list.\nlist\t\t\t\t\t- view list.\ndelete ->id\t\t\t\t- delete record by ID.\nexit\t\t\t\t\t- exit from programm.\\n" + //
                "find\\t\\t\\t\\t\\t- find student in list by name.";
    private String msgFindStudent = "Find student by name: ";
    private String msgStudentFoundInList = "Student found in list: ";

    public void printAllStudents(List<Student> students) {
        System.out.println("--------------------Students list-------------------");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------");
    }
    public void printAllStudents(HashMap<Integer,Student> students) {
        System.out.println("--------------------Students list-------------------");
        for (Map.Entry<Integer,Student> s : students.entrySet()) {
            System.out.println(s.getValue());
        }
        System.out.println("-------------------------------------------------------");
    }

    public String prompt(String msg) {
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
