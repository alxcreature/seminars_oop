import classes.Actor;
import classes.Market;
import classes.OrdinaryClient;
import classes.SpecialClient;
import classes.StockClient;
import classes.TaxInspector;


public class App {
    /**
     * Точка входа программы
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Market magnit = new Market(); //Создание экземпляра магазина

        Actor client1 = new OrdinaryClient("Boris"); //Создание обычного покупателя
        Actor client2 = new OrdinaryClient("Masha");
        Actor client3 = new SpecialClient("Prezident", 1); //Создание специального персонализированного покупателя
        TaxInspector client4 = new TaxInspector(); //Создание псевдопокупателя "Налоговый инспектор"
        // Создание персонализированных покупателей участвующих в акциях
        StockClient client5 = new StockClient("Misha", 351, "15% on all stock sale");
        StockClient client6 = new StockClient("Vitaly", 77, "10% stock on all fruits sale");
        StockClient client7 = new StockClient("Alex", 778, "20% stock on sale Coffee Pelle 200g");
        StockClient client8 = new StockClient("Katya", 666, "12% stock on season wears");
        StockClient client9 = new StockClient("Vasily", 1024, "15% on all stock sale");

        //Добавление созданных клиентов в магазин
        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);
        
        //Покупатель решил отказаться от покупки
        client5.setReturnOrder(true);

        magnit.acceptToMarket(client5);
        magnit.acceptToMarket(client6);
        magnit.acceptToMarket(client7);
        magnit.acceptToMarket(client8);
        magnit.acceptToMarket(client9);

        //Устанавливаем ограничение на количество участников по акциям
        magnit.setStockMaxClients(3);

        //Запускаем имитацию процесса посещения покупателей магазина
        magnit.update();
    }
}
