package Classes;
import Interfaces.iCalculable;
/***
 * @apiNote Класс экземпляра целочисленного калькулятора
 */
public final class Calculator implements iCalculable {

    private int primaryArg;

    public Calculator(int primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public iCalculable sum(int arg) {
        primaryArg += arg;
        return this;
    }

    @Override
    public iCalculable multi(int arg) {
        primaryArg *= arg;
        return this;
    }

    @Override
    public int getResult() {
        return primaryArg;
    }

    @Override
    public iCalculable sub(int arg) {
        primaryArg -= arg;
        return this;
    }

    @Override
    public iCalculable div(int arg) {
        primaryArg /= arg;
        return this;
    }
}
