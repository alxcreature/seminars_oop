package Decorators;
import Classes.Calculator;
import Classes.Logger;
import Interfaces.iCalculable;

/***
 * @apiNote Класс декоратора каькулятора целочисленных чисел расширяющий
 *          независимый функционал родительского класса
 *          Класс расширеный функционалом логирования
 */
public class Decorator implements iCalculable {
    private Calculator a;
    private Logger b;
    public Decorator(Calculator a, Logger b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public iCalculable sum(int arg) {
        int firstArg = a.getResult();
        b.log(String.format("Первое значение калькулятора %d. Начало вызова метода sum с параметром %d", firstArg, arg));
        iCalculable result = a.sum(arg);
        b.log(String.format("Вызова метода sum произошел"));
        return result;
    }
    @Override
    public iCalculable multi(int arg) {
        int firstArg = a.getResult();
        b.log(String.format("Первое значение калькулятора %d. Начало вызова метода multi с параметром %d", firstArg, arg));
        iCalculable result = a.multi(arg);
        b.log(String.format("Вызова метода multi произошел"));
        return result;
    }
    @Override
    public int getResult() {
        int result = a.getResult();
        b.log(String.format("Получение результата %d", result));
        return result;
    }
    @Override
    public iCalculable sub(int arg) {
        int firstArg = a.getResult();
        b.log(String.format("Первое значение калькулятора %d. Начало вызова метода sub с параметром %d", firstArg, arg));
        iCalculable result = a.multi(arg);
        b.log(String.format("Вызова метода sub произошел"));
        return result;
    }
    @Override
    public iCalculable div(int arg) {
        int firstArg = a.getResult();
        b.log(String.format("Первое значение калькулятора %d. Начало вызова метода div с параметром %d", firstArg, arg));
        iCalculable result = a.multi(arg);
        b.log(String.format("Вызова метода div произошел"));
        return result;
    }
}
