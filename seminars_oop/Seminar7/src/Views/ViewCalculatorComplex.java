package Views;
import java.util.Scanner;

import Classes.Complex;
import Interfaces.iCalculableComplex;

/***
 * @apiNote Класс визуализации механики работы калькулятора комплексных чисел
 */
public class ViewCalculatorComplex {
    private iCalculableComplex calculator;

    public ViewCalculatorComplex(iCalculableComplex calculator) {
        this.calculator = calculator;
    }

    /**
     * Метод запуска и обработки команд ввода консоли терминалов
     */
    public void run() {
        while (true) {
            Complex primaryArg = promptComplex("Введите первый аргумент комплексного числа (сначала певое число, затем второе число): ");
            calculator.sum(primaryArg);

            while (true) {
                String cmd = prompt("Введите команду (*, +, /, -, =) : ");
                if (cmd.equals("*")) {
                    Complex arg = promptComplex("Введите второй аргумент комплексного числа: ");
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals("+")) {
                    Complex arg = promptComplex("Введите второй аргумент комплексного числа: ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("/")) {
                    Complex arg = promptComplex(
                            "Введите второй аргумент комплексного числа: ");
                    calculator.div(arg);
                    continue;
                }
                if (cmd.equals("-")) {
                    Complex arg = promptComplex(
                            "Введите второй аргумент комплексного числа: ");
                    calculator.sub(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    Complex result = calculator.getResult();
                    System.out.printf("Результат %f, %fi\n", result.getReal(),result.getImaginary());
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?").toUpperCase();
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    /**
     * Метод вывода сообщения в консоль терминала с запросом ввода
     * @param message Выводимое сообщение
     * @return Возврат результата ввода с консоли
     */
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    /**
     * Метод вывода сообщения в консоль терминала с запросом ввода комплексного числа
     * @param message Выводимое сообщение
     * @return Возврат результата ввода с консоли комплексного числа
     */
    private Complex promptComplex(String message) {
        Complex complex = new Complex(0, 0);
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        complex.setReal(Double.parseDouble(in.nextLine()));
        complex.setImaginary(Double.parseDouble(in.nextLine()));
        return complex;
    }
}
    
