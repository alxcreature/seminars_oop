
package ISPLSP;

/***
 * @apiNote Класс квадрата расширяемый от базового класса прямоугольника
 */
public class Square extends Rectangle {
    //У квадрата все стороны равны
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }

    @Override
    public String toString() {
        return "Square [height=" + super.getHeight() + " width=" + super.getHeight() + " area=" + super.area() + "]";
    }
}