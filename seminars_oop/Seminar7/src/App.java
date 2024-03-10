import java.util.Scanner;

import Classes.Calculator;
import Classes.ComplexCalculator;
import Classes.Logger;
import Decorators.ComplexDecorator;
import Decorators.Decorator;
import Interfaces.iCalculable;
import Interfaces.iCalculableComplex;
import Views.ViewCalculator;
import Views.ViewCalculatorComplex;

public class App {
    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    public static void main(String[] args) throws Exception {

      //Инициализация Экземпляров калькуляторов (декораторов) для возможности выборного использования 
      iCalculable decorator = new Decorator(new Calculator(0), new Logger());
      ViewCalculator view = new ViewCalculator(decorator);
      iCalculableComplex complexDecorator = new ComplexDecorator(new ComplexCalculator(0,0), new Logger());
      ViewCalculatorComplex viewComplex = new ViewCalculatorComplex(complexDecorator);
      //Переменная результата выбора пользователем режима работы программы через ввод в консоли указанного числа
      int choice = -1;
      while (choice != 0){
        choice = Integer.parseInt(prompt(
            "Пожалуйста выберите тип калькулятора \"1\" - целочисленный, \"2\" - косплексные числа, \"0\" - выход: "));
       switch (choice) {
          case 1:
            view.run();
            break;
          case 2:
              viewComplex.run();
              break;
          case 0:
          default:
            break;
       }
      }
    }
}
