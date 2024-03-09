import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DIP.Bus;
import DIP.Car;
import DIP.DieselEngine;
import DIP.PetrolEngine;
import ISPLSP.Circle;
import ISPLSP.Cube;
import ISPLSP.Square;
import OCP.SpeedCalculation;
import SRP.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        //Не тронутый блок кода со студентами----------------------------------------------------
        Student<String,Integer> s1 = new Student<String,Integer>("Сергей", 25, 1);
        System.out.println(s1);


        Student<String, Integer> s2 = new Student<String, Integer>("Андрей", 26,2);
        Student<String, Integer> s3 = new Student<String, Integer>("Даша", 23,3);

        List<Student<String, Integer>> listStud = new ArrayList<>();
        listStud.add(s1);
        listStud.add(s2);
        listStud.add(s3);

        StudentGroup<String,Integer> group = new StudentGroup<String,Integer>(listStud, 5555);
        for(Student<String,Integer> stud : group)
        {
            System.out.println(stud);
        }
        //-------------------------------------------------------------------------------------------------

        //1е задание SRP
        Employee employee1 = new Employee("Viktor", new Date(), 1000);
        Employee employee2 = new Employee("Alyona", new Date(), 900);
        System.out.println("Выплата ЗП: " + employee1.calculateNetSalary(1000) + ", " + employee1.getEmpInfo());
        System.out.println("Выплата ЗП: " + employee2.calculateNetSalary(900) + ", " + employee2.getEmpInfo());

        //2е задание OSP
        SpeedCalculation spc = new SpeedCalculation();
        Car car = new Car(new PetrolEngine(),200);
        Bus bus = new Bus(new DieselEngine(), 180);
        System.out.println("Предельно-допустимая скорость: " + bus.getType() + " - " + spc.calculateAllowedSpeed(car));
        System.out.println("Предельно-допустимая скорость: " + bus.getType() + " - " + spc.calculateAllowedSpeed(bus));

        //3е задание ISP
        Cube cube = new Cube(10);
        Circle circle = new Circle(45);
        System.out.println(cube.toString());
        System.out.println(circle.toString());

        //4е задание LSP
        Square square = new Square();
        square.setHeight(10);
        System.out.println(square.toString());

        //5е задание DIP
        car.start();
        bus.start();

    }
}
