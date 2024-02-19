package classes;

import interfaces.iActorBehaviour;
import interfaces.iReturnOrder;
/***
 * @apiNote Класса участника процесса посещения магазина
 */
public abstract class Actor implements iActorBehaviour, iReturnOrder{
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;
    protected boolean isReturnOrder;

    public Actor(String name) {
        this.name = name;
    }

    public abstract String getName();
    public abstract void setName(String name);
}
