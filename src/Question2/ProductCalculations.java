package Question2;

public class ProductCalculations implements IProductCalculations {
    private double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        return price * 0.15; // 15% of the product price[cite: 4]
    }

    @Override
    public double GetCommission() {
        return price * 0.05; // 5% of the product price[cite: 4]
    }

    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission(); // Price + VAT + Commission[cite: 4]
    }
}