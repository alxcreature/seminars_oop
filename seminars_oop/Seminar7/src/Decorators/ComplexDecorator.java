package Decorators;
import Classes.Complex;
import Classes.ComplexCalculator;
import Classes.Logger;
import Interfaces.iCalculableComplex;
/***
 * @apiNote Класс декоратора каькулятора комплексных чисел расширяющий независимый функционал родительского класса
 * Класс расширеный функционалом логирования
 */
public class ComplexDecorator implements iCalculableComplex {
    private ComplexCalculator primaryArg;
    private Logger loger;
    
    public ComplexDecorator(ComplexCalculator primaryArg, Logger loger) {
        this.primaryArg = primaryArg;
        this.loger = loger;
    }

    public iCalculableComplex sum(Complex arg) {
        Complex firstArg = primaryArg.getResult();
        loger.log(String.format("Первое значение калькулятора %f, %fi. Начало вызова метода sum с параметром %f, %fi", firstArg.getReal(), firstArg.getImaginary(),
                arg.getReal(), arg.getImaginary()));
        iCalculableComplex result = primaryArg.sum(arg);
        loger.log(String.format("Вызова метода sum произошел"));
        return result;
    }

    @Override
    public iCalculableComplex multi(Complex arg) {
        Complex firstArg = primaryArg.getResult();
        loger.log(String.format("Первое значение калькулятора %f, %fi. Начало вызова метода multi с параметром %f, %fi",
                firstArg.getReal(), firstArg.getImaginary(),
                arg.getReal(), arg.getImaginary()));
        iCalculableComplex result = primaryArg.multi(arg);
        loger.log(String.format("Вызова метода multi произошел"));
        return result;
    }

    @Override
    public Complex getResult() {
        Complex result = primaryArg.getResult();
        loger.log(String.format("Получение результата %f, %fi", result.getReal(), result.getReal()));
        return result;
    }

    @Override
    public iCalculableComplex sub(Complex arg) {
        Complex firstArg = primaryArg.getResult();
        loger.log(String.format("Первое значение калькулятора %f, %fi. Начало вызова метода sub с параметром %f, %fi",
                firstArg.getReal(), firstArg.getImaginary(),
                arg.getReal(), arg.getImaginary()));
        iCalculableComplex result = primaryArg.sub(arg);
        loger.log(String.format("Вызова метода sub произошел"));
        return result;
    }

    @Override
    public iCalculableComplex div(Complex arg) {
        Complex firstArg = primaryArg.getResult();
        loger.log(String.format("Первое значе-ние калькулятора %f, %fi. Начало вызова метода div с параметром %f, %fi",
                firstArg.getReal(), firstArg.getImaginary(),
                arg.getReal(), arg.getImaginary()));
        iCalculableComplex result = primaryArg.div(arg);
        loger.log(String.format("Вызова метода div произошел"));
        return result;
    }
}
