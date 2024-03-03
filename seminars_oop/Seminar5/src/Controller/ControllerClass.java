package Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;

/***
 * @apiNote Класс контроллера
 */
public class ControllerClass {

    private iGetModel model;
    private iGetView view;
    private List<Student> bufferStudentList = new ArrayList<Student>();
    private LinkedList<iGetModel> modelsList = new LinkedList<>();

    /**
     * Конструктор контроллера класса
     * 
     * @apiNote Конструктор контроллера класса
     * @param model Экземпляр класса модели
     * @param view  Экземпляр класса визуализации
     */
    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }
    
    /**
     * Конструктор контроллера класса
     * 
     * @apiNote Конструктор контроллера класса
     * @param modelsList Список экземпляров моделей
     * @param view       Экземпляр класса визуализации
     */
    public ControllerClass(LinkedList<iGetModel> modelsList, iGetView view) {
        this.modelsList = modelsList;
        this.view = view;
    }

    /**
     * Метод проверяющий список студентов
     * 
     * @apiNote Метод проверяющий список студентов
     * @param students Список студентов
     * @return Истина если список не пустой
     */
    private boolean testData(List<Student> students) {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод обновления состояний контроллёра
     * 
     * @apiNote Метод обновления состояний контроллёра
     */
    public void update() {
        // MVC
        // view.printAllStudent(model.getStudents());

        // MVP
        bufferStudentList = model.getAllStudents();
        if (testData(bufferStudentList)) {
            view.printAllStudents(bufferStudentList);
        } else {
            System.out.println(view.getMsgStudentsListEmpty());
        }

    }
    
    /**
     * Метод поиска студента в моделях
     * 
     * @apiNote Метод поиска студента в моделях
     * @param model Модель списка студентов
     * @param name  Имя (ФИО) искомого студента
     */
    private void find(iGetModel model, String name){
        if (model.findStudent(name)) {
            if (model.getAllStudents() != null) {
                for (Student student : model.getAllStudents()) {
                    if (student.getName().contains(name))
                        System.out.println(student);

                }
            }
            // if (model.getAllHashMapStudents() != null) {
            //     for (Map.Entry<Integer, Student> student : model.getAllHashMapStudents().entrySet()) {
            //         if (student.getValue().getName().contains(name))
            //             System.out.println(student.getValue());
            //     }
            // }
        }
    }
    
    /**
     * Метод визуализаии списков студентов
     * 
     * @apiNote Метод визуализаии списков студентов
     */
    private void list(){
        if (modelsList.size()<=0){
            view.printAllStudents(model.getAllStudents());
        } else {
            for (int i=0; i<modelsList.size(); i++) {
                System.out.println(i);
                view.printAllStudents(modelsList.get(i).getAllStudents());
            }
        }
    }
    
    /**
     * Метод удаления студента из списков
     * 
     * @apiNote Метод удаления студента из списков
     * @param id Идентификатор (уникальный номер)
     * @return Успех в случае, если студент был найден и удалён из списка
     */
    private boolean del(int id){
        boolean flag=false;
        if (modelsList.size() <= 0) {
            flag=model.deleteStudent(id);
        } else {
            for (int i = 0; i < modelsList.size(); i++) {
                if (modelsList.get(i).deleteStudent(id))
                {
                    System.out.println(i);
                    view.printAllStudents(modelsList.get(i).getAllStudents());
                    flag=true;
                }
            }
        }
        return flag;
    }

    /**
     * Метод контроллера запускающий обработку консоли терминала командной строки
     * 
     * @apiNote Метод контроллера запускающий обработку консоли терминала командной
     *          строки
     */
    public void run() {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt(view.getMsgPrompt());
            try {
                com = Command.valueOf(command.toUpperCase());
            } catch (Exception e) {
                com = Command.HELP;
            }
            
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println(view.getMsgExit());
                    break;
                case LIST:
                    list();
                    break;
                case DELETE:
                    String id = view.prompt(view.getMsgDeleteInputId());
                    if (!del(Integer.parseInt(id))) 
                        System.out.println(view.getMsgIdNotFound());
                    break;
                case FIND:
                    String name = view.prompt(view.getMsgFindStudent());
                    if (modelsList.size()<=0) {
                        find(this.model, name);
                    }
                    else{
                        for (iGetModel modell : modelsList) {
                            find(modell, name);
                        }
                    }
                    break;
                case HELP:
                default:
                System.out.println(view.getMsgHelpCommands());
            }
        }
    }

    public LinkedList<iGetModel> getModelsList() {
        return modelsList;
    }

    public void setModelsList(LinkedList<iGetModel> modelsList) {
        this.modelsList = modelsList;
    }
    public void addModel(iGetModel model){
        modelsList.add(model);
    }

    public void removeModel(iGetModel model) {
        modelsList.remove(model);
    }
}
