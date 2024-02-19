package classes;
/***
 * @apiNote Класс обычного покупателя
 */
public class OrdinaryClient extends Actor{
    // Конструктор класса
    public OrdinaryClient(String name) {
        super(name);
    }

    // Метод получения значения флага возврата/отказа покупателем заказа
    public boolean isReturnOrder() {
        return super.isReturnOrder;
    }
    // Метод установки флага возврата/отказа от заказа
    public void setReturnOrder(boolean val) {
        super.isMakeOrder = val;
    }
    // 
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    public void setTakeOrder(boolean val) {
        super.isTakeOrder = val;
    }

    public void setMakeOrder(boolean val) {
        super.isMakeOrder = val;
    }

    public Actor getActor() {
        return this;
    }

    public String getName() {
        return super.name;
    }

    // 
    @Override
    public void setName(String name) {
        super.name = name;
    }

    // Метод возврата/отказа покупателем заказа
    @Override
    public void returnOrder() {
        //super.isTakeOrder = false;
        //super.isMakeOrder = false;
        //super.isReturnOrder = true;
    }

}
