package Question1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {

    @Test
    public void GetTotalProductsSold_WithValidData_ReturnsCorrectValue() {
        // Arrange
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
                {25, 18, 20}, // Total: 63
                {15, 10, 12}, // Total: 37
                {16, 15, 20}  // Total: 51
        };
        Product product = new Product(products, sales);

        // Act
        int total = product.GetTotalProductsSold();


        assertEquals(151, total);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // Arrange
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
                {25, 18, 20},
                {15, 10, 12},
                {16, 15, 20}
        };
        Product product = new Product(products, sales);


        double average = product.GetAverageProductSold();


        assertEquals(151.0 / 9.0, average, 0.001);
    }
}