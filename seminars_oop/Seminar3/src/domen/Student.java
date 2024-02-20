package domen;

public class Student extends Person implements Comparable<Student> {
    private int id;
    private static int idGenerator;

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

    @Override
    public int compareTo(Student o) {
        if (this.getAge()>o.getAge()) {
            return 1;
        }
        if (this.getAge()<o.getAge()) {
            return -1;
        }
        if (this.getId()<o.getId()) {
            return -1;
        }
        if (this.getId()>o.getId()) {
            return 1;
        }
        return 0;
    }
}
