package domen;

public class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }

    String degree;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Teacher [degree=" + degree + " name=" + this.getName() + " age=" + this.getAge() + "]";
    }
}
