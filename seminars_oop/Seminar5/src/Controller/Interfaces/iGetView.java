package Controller.Interfaces;

import java.util.HashMap;
import java.util.List;

import Model.Domain.Student;

/***
 * @apiNote Интерфейс визуализации
 */
public interface iGetView {
    /**
     * Метод печати списка студентов
     * @apiNote Метод печати списка студентов
     * @param students Список студентов
     */
    public void printAllStudents(List<Student> students);
    
    /**
     * Дополнитеьный метод печати отображаемым списком студентов
     * 
     * @apiNote Дополнительный метод печати отображаемым списком студентов
     * @param students Список студентов отображением
     */
    public void printAllStudents(HashMap<Integer,Student> students);
    
    /**
     * Метод запроса данных из командной строки
     * @apiNote Метод запроса данных из командной строки
     * @param msg Выводимое сообщение в консоль терминала
     * @return Возвращает введённую с клавиатуры строку
     */
    public String prompt(String msg);
    
    /***
     * Блок сообщений на региональном языке
     */
    public String getMsgPrompt();
    public String getMsgExit();
    public String getMsgStudentsListEmpty();
    public String getMsgDeleteInputId();
    public String getMsgIdNotFound();
    public String getMsgHelpCommands();
    public String getMsgFindStudent();
    public String getMsgStudentFoundInList();

}
