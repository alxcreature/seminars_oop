import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domen.Bottle;
import domen.HotDrinks;
import domen.Product;
import services.VendingMachine;

public class MainFrame extends JFrame {

    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    private DefaultListModel<String> productsModel;
    private VendingMachine vendingMachine;
    JTextField tfBuy;
    JLabel lbWelcome;
    JList<String> jlProducts;

    public void initialize(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        initialize();
    }
    /**
     * 
     */
    public void initialize() {

        JLabel lbProductsList = new JLabel("Products list:");
        lbProductsList.setFont(mainFont);

        productsModel = new DefaultListModel<>();
        jlProducts = new JList<>(productsModel);
        jlProducts.setFont(mainFont);
        jlProducts.setLayout(new GridLayout(5,5));
        jlProducts.setAutoscrolls(true);
        if (vendingMachine == null) {
            try {
                throw new Exception("No VenDingMachine Initialized!");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            setProductsList(vendingMachine.getProducts());
        }

        JLabel lbBuy = new JLabel("Product:");
        lbBuy.setFont(mainFont);
        JLabel lbPay = new JLabel("Please insert the money");
        lbPay.setFont(mainFont);
        tfBuy = new JTextField("0.0");

        JPanel formPanel = new JPanel();
        //formPanel.
        formPanel.setLayout(new GridLayout(10, 2, 2, 2));
        formPanel.add(lbProductsList);
        formPanel.add(jlProducts);
        formPanel.add(lbBuy);
        formPanel.add(lbPay);
        formPanel.add(tfBuy);

        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        JButton btnBuy = new JButton("Buy");
        btnBuy.setFont(mainFont);
        btnBuy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //jlProducts.setLis
                //String firstName = tfFirstName.getText();
                //String lastName = tfFirstName.getText();
                //lbWelcome.setText("Hello " + firstName + " " + lastName);
                lbBuy.setText(jlProducts.getSelectedValue()+" -> Bout!");
                //jlProducts.remove(jlProducts.getSelectedIndex());
                //System.out.println(jlProducts.getSelectedIndex());
                if (jlProducts.getSelectedIndex() >=0) {
                    vendingMachine.getAssort().remove(jlProducts.getSelectedIndex());
                    System.out.println("vendingMachine.getAssort() = " + vendingMachine.getAssort());
                    productsModel.remove(jlProducts.getSelectedIndex());
                }

            }

        });

        JButton btnClear = new JButton("Nothing");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

//                tfFirstName.setText("");
//                tfFirstName.setText("");
                lbWelcome.setText("Ничего");

            }

        });

        jlProducts.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                // TODO Auto-generated method stub
                lbBuy.setText(jlProducts.getSelectedValue());
            }

        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(btnBuy);
        buttonPanel.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));

        mainPanel.add(formPanel, BorderLayout.NORTH);

        mainPanel.add(lbWelcome, BorderLayout.CENTER);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        setTitle("VendingMachines");
        setSize(500, 600);
        setMaximumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setProductsList(List<Product> assort){
        //List<Product> assort = new ArrayList<>();
        int i = 0;
        String sb = "";
        for(Product product : assort){
            sb = product.getPlace() +": " + product.getName() + ", price: " + product.getPrice();
            if (product instanceof Bottle) {
                sb += ": " + ((Bottle) product).getVolume() +"l";
             
            }
            if (product instanceof HotDrinks) {
                sb += ", t=" + ((HotDrinks) product).getTemperature()+"*C";

            }
            productsModel.add(i, sb);
            i++;
            sb = "";
        }
        //jlProducts.updateUI();
    }

    public DefaultListModel<String> getProductsList() {
        // List<Product> assort = new ArrayList<>();
        
        //for (int i=0; i<productsModel.size(); i++) {
            return productsModel;
        //    i++;
        //}
    }

    public static void main(String[] arg) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }

}
