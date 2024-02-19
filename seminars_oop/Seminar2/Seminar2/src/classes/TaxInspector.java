package classes;

import interfaces.iActorBehaviour;
import interfaces.iReturnOrder;

/***
 * @apiNote Класс нестандартного клиента "Налоговый инспектор"
 */
public class TaxInspector implements iActorBehaviour,iReturnOrder{
    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;
    private boolean isReturnOrder;

    public boolean isReturnOrder() {
        return isReturnOrder;
    }

    public TaxInspector() {
        this.name = "Tax Audit";
        this.isTakeOrder = false;
        this.isMakeOrder = false;
        this.isReturnOrder = false;
    }

    public String getName() {
        return name;
    }

    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public void setTakeOrder(boolean val) {
        isTakeOrder = val;
    }

    public void setMakeOrder(boolean val) {
        isMakeOrder = val;
    }

    public void setReturnOrder(boolean isReturnOrder) {
        this.isReturnOrder = isReturnOrder;
    }

    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }

    @Override
    public void returnOrder() {
        //this.isTakeOrder = false;
        //this.isMakeOrder = false;
        //this.isReturnOrder = true;
    }
    
}
