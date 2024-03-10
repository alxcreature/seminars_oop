package Classes;
/***
 * @apiNote Класс экземпляра комплексного числа
 */
public class Complex {
    private double real;
    private double imaginary;
    
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return real + ", " + imaginary + "i";
    }
}
