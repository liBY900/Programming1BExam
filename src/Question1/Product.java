package Question1;

public class Product implements IProduct {
    private String[] productNames;
    private int[][] salesData;

    public Product(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int sale = 0; sale < salesData.length; sale++) {
            for (int salex = 0; salex < salesData[sale].length; salex++) {
                total += salesData[sale][salex];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int totalProducts = GetTotalProductsSold();
        int totalEntries = 0;
        for (int sale = 0; sale < salesData.length; sale++) {
            totalEntries += salesData[sale].length;
        }
        return totalEntries == 0 ? 0.0 : (double) totalProducts / totalEntries;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxSales = -1;
        int bestIndex = 0;
        for (int sale = 0; sale < salesData.length; sale++) {
            int productTotal = 0;
            for (int salex = 0; salex < salesData[sale].length; salex++) {
                productTotal += salesData[sale][salex];
            }
            if (productTotal > maxSales) {
                maxSales = productTotal;
                bestIndex = sale;
            }
        }
        return productNames[bestIndex] + " (" + maxSales + ")";
    }
}