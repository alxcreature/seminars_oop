package domen;

/***
 * @apiNote Класс преподавателя
 */
public class Teacher extends WorkingPerson{
    //Учёная степень
    String degree;

    /**
     * @apiNote Конструктор класса преподавателя
     * @param name Имя (ФИО)
     * @param age Возраст
     * @param degree Учёная (педагогическая) степень
     */
    public Teacher(String name, int age, String degree) {
        super(name, age);
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Teacher [name=" + this.getName() + " age=" + this.getAge() + " degree=" + this.getDegree() + "]";
    }

}
