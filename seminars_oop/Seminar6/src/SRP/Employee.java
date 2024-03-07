package SRP;
import java.util.Date;
/***
 * @apiNote Класс наёмного рабочего с расширением класса сервисов функцииионала бухгалтерии
 */
public class Employee extends Account{
    private String name;
    private Date dob;
    private int baseSalary;

    /**
     * Конструктор класса
     * @param name Имя (ФИО) сотрудника
     * @param dob Дата
     * @param baseSalary базовая ставка ЗП
     */
    public Employee(String name, Date dob, int baseSalary) {
        this.name = name;
        this.dob = dob;
        this.baseSalary = baseSalary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public String getEmpInfo() {
        return "Имя - " + name + ", Дата - " + dob.toString();
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

}