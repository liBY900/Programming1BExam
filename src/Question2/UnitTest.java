package Question2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Arrange
        double price = 3500.0;
        ProductCalculations calculations = new ProductCalculations(price);

        double actualVat = calculations.GetVat();

        // Assert (15% of 3500 = 525.0)
        assertEquals(525.0, actualVat, 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // Arrange
        double price = 3500.0;
        ProductCalculations calculations = new ProductCalculations(price);

        // Act
        double actualTotal = calculations.GetTotal();

        // Assert (3500 + 525 [VAT] + 175 [Commission (5%)] = 4200.0)
        assertEquals(4200.0, actualTotal, 0.001);
    }
}