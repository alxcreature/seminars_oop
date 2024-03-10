package Views;
import java.util.Scanner;

import Interfaces.iCalculable;
/***
 * @apiNote Класс визуализации механики работы калькулятора целочисленных чисел
 */
public class ViewCalculator {
    private iCalculable calculator;

    public ViewCalculator(iCalculable calculator) {
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            int primaryArg = promptInt("Введите первый аргумент: ");
            calculator.sum(primaryArg);

            while (true) {
                String cmd = prompt("Введите команду (*, +, /, -, =) : ");
                if (cmd.equals("*")) {
                    int arg = promptInt("Введите второй аргумент: ");
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals("+")) {
                    int arg = promptInt("Введите второй аргумент: ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    int result = calculator.getResult();
                    System.out.printf("Результат %d\n", result);
                    break;
                }
                if (cmd.equals("/")) {
                    int arg = promptInt("Введите второй аргумент: ");
                    calculator.div(arg);
                    continue;
                }
                if (cmd.equals("-")) {
                    int arg = promptInt("Введите второй аргумент: ");
                    calculator.sub(arg);
                    continue;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?").toUpperCase();
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

/***
 * Метод вывода сообщения в консоль терминала с запросом ввода
 * 
 * @param message Выводимое сообщение
 * @return Возврат результата ввода с консоли
 */    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

/***
 * Метод вывода сообщения в консоль терминала с запросом ввода целого числа
 * 
 * @param message Выводимое сообщение
 * @return Возврат результата ввода с консоли целого числа
 */
    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}
