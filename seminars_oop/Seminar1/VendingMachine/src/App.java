import java.util.ArrayList;
import java.util.List;

import domen.Bottle;
import domen.HotDrinks;
import domen.Product;
import services.CoinDispencer;
import services.Display;
import services.Holder;
import services.VendingMachine;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> assort = new ArrayList<>();
        Product item1 = new Product(100, 1, "Lays");
        Product item2 = new Product(50, 2, "Cola");
        Product item3 = new Bottle(150, 3, "Mineral Water", 101, 1.5);
        Product item6 = new Bottle(100, 6, "Drink Water", 102, 0.6);
        Product item4 = new HotDrinks(200, 4, "Black Cofee", 201, 0.5,  60);
        Product item5 = new HotDrinks(100, 5, "Green Tea", 202, 0.5, 60);
        
        
        assort.add(item1);
        assort.add(item2);
        assort.add(item3);
        assort.add(item4);
        assort.add(item5);
        assort.add(item6);

        Holder hold1 = new Holder(4, 4);
        CoinDispencer coinDesp = new CoinDispencer(0);
        Display disp = new Display();

        VendingMachine venMachine = new VendingMachine(hold1, coinDesp, assort, disp);

        for(Product prod: venMachine.getProducts())
        {
            System.out.println(prod);
        }

        MainFrame myFrame = new MainFrame();
        myFrame.initialize(venMachine);
    }
}
