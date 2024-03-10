package Classes;
import Interfaces.iCalculableComplex;
/***
 * @apiNote Класс калькулятора вычислений комплексых чисел
 */
public class ComplexCalculator implements iCalculableComplex{
    private Complex primaryArg = new Complex(0, 0);
    public ComplexCalculator(Complex primaryArg) {
        this.primaryArg.setReal(primaryArg.getReal());
        this.primaryArg.setImaginary(primaryArg.getImaginary());
    }
    public ComplexCalculator(double real, double imaginary) {
        this.primaryArg.setReal(real);
        this.primaryArg.setImaginary(imaginary);
    }
    @Override
    public Complex getResult() {
        return primaryArg;
    }
    @Override
    public iCalculableComplex div(Complex arg) {
        double sca = (this.primaryArg.getReal() + arg.getReal()) + (this.primaryArg.getReal() * arg.getImaginary());
        Complex ret = new Complex(
                (this.primaryArg.getReal() / sca),
                (-arg.getImaginary() / sca));
        this.primaryArg.setReal(ret.getReal());
        this.primaryArg.setImaginary(ret.getImaginary());
        return this;
    }
    @Override
    public iCalculableComplex multi(Complex arg) {
        Complex ret = new Complex(
                (this.primaryArg.getReal() * arg.getReal()) - (this.primaryArg.getImaginary() * arg.getImaginary()), 
                (this.primaryArg.getReal() * arg.getImaginary()) + (this.primaryArg.getImaginary() * arg.getReal()));
        this.primaryArg.setReal(ret.getReal());
        this.primaryArg.setImaginary(ret.getImaginary());
        return this;
    }
    @Override
    public iCalculableComplex sum(Complex arg) {
        Complex ret = new Complex(
                this.primaryArg.getReal() + arg.getReal(),
                this.primaryArg.getReal() + arg.getImaginary());
        this.primaryArg.setReal(ret.getReal());
        this.primaryArg.setImaginary(ret.getImaginary());
        return this;
    }
    @Override
    public iCalculableComplex sub(Complex arg) {
        Complex ret = new Complex(
                this.primaryArg.getReal() - arg.getReal(),
                this.primaryArg.getReal() - arg.getImaginary());
        this.primaryArg.setReal(ret.getReal());
        this.primaryArg.setImaginary(ret.getImaginary());
        return this;
    }

    
    
}
