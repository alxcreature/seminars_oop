package domen;

public class Employee extends Person {
    String special;

    public Employee(String name, int age) {
        super(name, age);
    }
    public String getSpecial() {
        return special;
    }
    public void setSpecial(String special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "Employee [special=" + special + " name=" + this.getName() + " age=" + this.getAge() + "]";
    }

}
