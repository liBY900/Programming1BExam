package Question2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;

    public ProductApp() {
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Components
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 30, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(150, 30, 180, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 80, 120, 25);
        add(lblProduct);

        String[] products = { "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket" };
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(150, 80, 180, 25);
        add(cmbProduct);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 130, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(150, 130, 180, 25);
        add(txtPrice);

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(150, 180, 180, 30);
        add(btnProcess);

        // Menu Bar Setup
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);

        JMenu menuTools = new JMenu("Tools");
        JMenuItem itemProcess = new JMenuItem("Process");
        JMenuItem itemClear = new JMenuItem("Clear");
        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // Button and Menu Event Listeners
        btnProcess.addActionListener(e -> processSales());
        itemProcess.addActionListener(e -> processSales());

        itemClear.addActionListener(e -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        });

        itemExit.addActionListener(e -> System.exit(0));
    }

    private void processSales() {
        try {
            String customerName = txtCustomerName.getText().trim();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText().trim());

            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a customer name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calculating using ProductCalculations class
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Displaying message dialog
            String message = String.format("Customer Name: %s\nProduct: %s\nVAT: R %.1f\nCOMMISSION: R %.1f\nTOTAL: R %.1f",
                    customerName, productName, vat, commission, total);
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save data to data.txt
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println("DATA LOG");
                writer.println("**************************************************");
                writer.println("Customer Name: " + customerName);
                writer.println("Product: " + productName);
                writer.println("VAT: R " + vat);
                writer.println("COMMISSION: R " + commission);
                writer.println("TOTAL: R " + total);
                writer.println("**************************************************\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}