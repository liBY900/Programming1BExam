package Question1;

public class PrintProduct {
    private IProduct productData;

    public PrintProduct(IProduct productData) {
        this.productData = productData;
    }

    public void printReport() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("**************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + productData.GetTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int) Math.round(productData.GetAverageProductSold()));
        System.out.println("MOST POPULAR PRODUCT: " + productData.GetMostPopularProduct());

    }
}
