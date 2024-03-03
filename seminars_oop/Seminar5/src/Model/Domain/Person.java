package Model.Domain;

/***
 * @apiNote Класс экземпляра персоны
 */
public abstract class Person {
    private String name;
    private int age;

    /**
     * Конструктор экземпляра персоны
     * 
     * @apiNote Конструктор экземпляра персоны
     * @param name Имя (ФИО)
     * @param age  Возраст
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
