package classes;

/***
 * @apiNote Класс важного клиента
 */
public class SpecialClient extends Actor{
    private int idVIP;

    public int getIdVIP() {
        return idVIP;
    }

    public SpecialClient(String name, int idVIP) {
        super(name);
        this.idVIP = idVIP;
    }

    public boolean isReturnOrder() {
        return super.isReturnOrder;
    }

    public void setReturnOrder(boolean val) {
        super.isMakeOrder = val;
    }

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

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public void returnOrder() {
        //super.isTakeOrder = false;
        //super.isMakeOrder = false;
        //super.isReturnOrder = true;
    }
    
}
