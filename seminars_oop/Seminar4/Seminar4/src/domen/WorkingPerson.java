package domen;

/***
 * @apiNote Класс рабочего персонала
 */
public class WorkingPerson extends Person implements Comparable<WorkingPerson> {

    /**
     * @apiNote Конструктор рабочего персонала
     * @param name Имя (ФИО)
     * @param age Возраст
     */
    public WorkingPerson(String name, int age) {
        super(name, age);
    }
    /***
     * @apiNote Перегружаемый метод сравнения рабочего персонала для сортировки
     */
    @Override
    public int compareTo(WorkingPerson o) {
        if (this.getAge()>o.getAge()) {
            return 1;
        }
        if (this.getAge()<o.getAge()) {
            return -1;
        }
        return 0;
    }
    
}
