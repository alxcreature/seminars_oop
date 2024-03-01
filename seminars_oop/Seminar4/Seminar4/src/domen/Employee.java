package domen;

/***
 * @apiNote Класс наёмного сотрудника
 */
public class Employee extends WorkingPerson{
    String special;

    /**
     * @apiNote Конструктор класса
     * @param name Имя
     * @param age Возраст
     * @param special Специализация
     */
    public Employee(String name, int age, String special) {
        super(name, age);
        this.special = special;
    }

    public String getSpecial() {
        return special;
    }
    public void setSpecial(String special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "Employee [name=" + this.getName() + " age=" + this.getAge() + " special=" + this.getSpecial() + "]";
    }


}
