package controls;

import java.util.List;

import domen.Person;
import domen.WorkingPerson;

/***
 * @apiNote Обообщённый класс контроллёра расширенный от класса рабоющего персонала
 */
public class AccountControler {

    /**
     * @apiNote Метод печатает в консоль выплачиваемую ЗП работающему сотруднику
     * @param <T>    Потомок класса WorkingPerson
     * @param <V>    Числовое
     * @param person Персона
     * @param salary ЗП
     */
    public static <T extends WorkingPerson,V extends Number> void paySalary(T person, V salary ){
        System.out.println(person.getName() + " выплаченная зарплата: " + salary);

    }
    /**
     * @apiNote Метод подсчитывает средний возраст персонала
     * @param <T> Потомок класса WorkinPerson
     * @param persons Список сотрудников (группа)
     */
    public static <T extends Person> void averageAge(List<T> persons){
        int sum = 0;
        for (T person : persons) sum+=person.getAge();
        int avgAge = sum / persons.size();
        System.out.println("Средний возраст группы: " + avgAge);
    }
}
