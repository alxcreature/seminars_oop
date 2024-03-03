import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.FileModelClass;
import Model.ModelClass;
import Model.ModelClassHash;
import Model.Domain.Student;
import View.ViewClass;
import View.ViewClassEng;

public class App {
    public static void main(String[] args) throws Exception {
       // Создание студентов
        Student student1 = new Student("Ivan", 21);
        Student student2 = new Student("Anna", 25);
        Student student3 = new Student("Vasya", 22);
        Student student4 = new Student("Nastya", 27);
        Student student5 = new Student("Vasilisa", 26);
        Student student6 = new Student("Karina", 25);
        Student student7 = new Student("Andrey", 22);
        Student student8 = new Student("Masha", 27);
        Student student9 = new Student("Irina", 28);
        Student student10 = new Student("Nikolay", 30);
        Student student11 = new Student("Pyotr", 32);
        Student student12 = new Student("Ruslan", 25);
        Student student13 = new Student("Anatoly", 33);
        Student student14 = new Student("Lubov", 28);
        Student student15 = new Student("Ekaterina", 35);
        // Добавление студентов в список 1 (для файловой модели)
        List<Student> studList1 = new ArrayList<>();
        studList1.add(student1);
        studList1.add(student2);
        studList1.add(student3);
        studList1.add(student4);
        studList1.add(student5);
        // Добавление студентов в список 2
        List<Student> studList2 = new ArrayList<>();
        studList2.add(student6);
        studList2.add(student7);
        studList2.add(student8);
        studList2.add(student9);
        studList2.add(student10);
        // Добавление студентов в список 3 (отображаемый)
        HashMap<Integer,Student> studList3 = new HashMap<>();
        studList3.put(1, student11);
        studList3.put(2, student12);
        studList3.put(3, student13);
        studList3.put(4, student14);
        studList3.put(5, student15);

        // Создание экземпляра класса файловой модели
        FileModelClass fmClass = new FileModelClass("StudentDB.csv");
        fmClass.saveAllStudentToFile(studList1);
        // Создания экземпляров класса моделей
        iGetModel mdClass = new ModelClass(studList2);
        iGetModel hmClass = new ModelClassHash(studList3);
        // Создание и заполнение списка моделей
        LinkedList<iGetModel> modelsClass = new LinkedList<>();
        modelsClass.add(fmClass);
        modelsClass.add(mdClass);
        modelsClass.add(hmClass);

        // Создание экземпляра класса визуализацтт
        iGetView view;

        // Запрос в консоли терминала и выбор регионального язык интерфейса визуализации
        Scanner in = new Scanner(System.in);
        System.out.print("\nВыберите язык интерфейса для дальнейшей работы (EN, RU): ");
        
        if (in.nextLine().toUpperCase().equals("EN")){
            view = new ViewClassEng();
        } else {
            view = new ViewClass();
        }

        //ControllerClass controller = new ControllerClass(fmClass, view);
        //Инициализация класса контроллера. В качестве первого параметра - список моделей
        ControllerClass controller = new ControllerClass(modelsClass, view);

        //controller.update();
        //Запуск механики поведения контроллера
        controller.run();
        in.close();

    }
}
