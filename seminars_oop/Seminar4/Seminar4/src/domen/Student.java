package domen;

/***
 * @apiNote Класс студента
 */
public class Student extends Person implements Comparable<Student> {
    //Внутренний уникальный идентификатор студента
    private int id;
    //Статический счётчик студентов
    private static int idGenerator;

    /**
     * @apiNote Конструктор класса студента
     * @param name
     * @param age
     */
    public Student(String name, int age) {
        super(name, age);
        idGenerator++;
        this.id = idGenerator;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + " name=" + getName() + " age=" + getAge()+"]";
    }

    /***
     * @apiNote Перегружаемый метод сравнения для сортировки класса студентов
     */
    @Override
    public int compareTo(Student o) {
        if (this.getAge()>o.getAge()) {
            return 1;
        }
        if (this.getAge()<o.getAge()) {
            return -1;
        }
        if (this.getAge() == o.getAge()){

            if (this.getId()<o.getId()) {
                return -1;
            }
            if (this.getId()>o.getId()) {
                return 1;
            }
        }
        return 0;
    }
}
