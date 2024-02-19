package interfaces;

/***
 * @apiNote Интерфейс методов класса реализации поведения в очереди магазина
 */
public interface iQueueBehaviour {
    public void takeInQueue(iActorBehaviour actor);
    public void releaseFromQueue();
    public void takeOrder();
    public void giveOrder();
}