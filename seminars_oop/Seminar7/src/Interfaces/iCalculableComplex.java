package Interfaces;
import Classes.Complex;
/***
 * @apiNote Интерфейс экземпляра класса калькулятора для комплексных чисел
 */
public interface iCalculableComplex{
    /**
     * Метод деления комплексных чисел
     * 
     * @param arg Второе число
     * @return ссылку на экземпляр класса калькулятора
     */
    iCalculableComplex div(Complex arg);

    /**
     * Метод умножения комплексных чисел
     * 
     * @param arg Второе число
     * @return ссылку на экземпляр класса калькулятора
     */
    iCalculableComplex multi(Complex arg);

    /**
     * Метод сложения комплексных чисел
     * 
     * @param arg Второе число
     * @return ссылку на экземпляр класса калькулятора
     */
    iCalculableComplex sum(Complex arg);

    /**
     * Метод вычетания комплексного числа
     * 
     * @param arg Второе число
     * @return ссылку на экземпляр класса калькулятора
     */
    iCalculableComplex sub(Complex arg);

    /**
     * Метод возвращает текущее значение результата
     */
    Complex getResult();
}
