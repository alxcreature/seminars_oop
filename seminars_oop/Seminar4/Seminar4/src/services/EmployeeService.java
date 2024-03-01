package services;

import java.util.ArrayList;
import java.util.List;

import domen.Employee;
import domen.PersonComporator;

/***
 * @apiNote Класс сервисов для класса наёмного рабочего
 * @deprecated Класс не используется, вместо данного класса используйте класс-дженерик PersonService
 */
public class EmployeeService implements iPersonService<Employee>{
    //Счётчик наёмных рабочих
    private int count=0;
    //Список наёмных рабочих
    private List<Employee> listEmployee;
    
    /**
     * @apiNote Конструктор класса списка наёмных рабочих
     */
    public EmployeeService() {
        this.listEmployee = new ArrayList<Employee>();
        count = 0;
    }
    /***
     * @apiNote Перегрузка метода интерфейса возврата списка наёмных рабочих
     * @return List<Employee> Список наёмных рабочих
     */
    @Override
    public List<Employee> getAll() {
        return this.listEmployee;
    }
    
    /***
     * @apiNote Перегрузка метода создания наёмного рабочего и добавление его в
     *          список класса
     * @param name имя (ФИО)
     * @param age  возраст
     */
    @Override
    public void create(String name, int age) {
        Employee newEmployee = new Employee(name, age, "Anyworker");
        this.listEmployee.add(newEmployee);
        this.count++;
    }
    /***
     * @apiNote Метод сортировки списка наёмных рабочих по ФИО (имени)
     */
    public void sortByFIO(){
        this.listEmployee.sort(new PersonComporator<Employee>());
    }
    
}
