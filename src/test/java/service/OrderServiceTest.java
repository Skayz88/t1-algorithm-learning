package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.t1.java.dto.Item;
import org.t1.java.service.OrderService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author DRakovskiy
 */
class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    @Test
    @DisplayName("Тест: обычный заказ без скидок")
    void calc_shouldReturnSumWithoutDiscounts() {
        List<Item> items = Arrays.asList(
                new Item("Apple", 100.0, 2),   // 200
                new Item("Banana", 50.0, 3)    // 150
        );
        double result = orderService.calc(items, "REGULAR");
        assertEquals(350.0, result, 0.001); // 200 + 150 = 350
    }


    /**
     * TDD
     * 2000 + 150 = 2150
     * - (VIP 10%) = 1935
     * - (кол-во более 20 - 20%) = 1548
     * - (по сумме более 1000 - 50) = 1498
     */
    @Test
    @DisplayName("Тест: обычный заказ со скидкой по кол-ву")
    void calc_shouldReturnSumWithoutDiscountsByCount() {
        List<Item> items = Arrays.asList(
                new Item("Apple", 100.0, 20),   // 2000
                new Item("Banana", 50.0, 3)    // 150
        );
        double result = orderService.calc(items, "VIP");
        assertEquals(1498.0, result, 0.001); // 200 + 150 = 350
    }

    @Test
    @DisplayName("Тест: VIP скидка 10%")
    void calc_shouldApplyVIPDiscount() {
        List<Item> items = Arrays.asList(
                new Item("Laptop", 100.0, 5)   // 500
        );
        double result = orderService.calc(items, "VIP");
        assertEquals(450.0, result, 0.001); // 500 * 0.9 = 450
    }

    @Test
    @DisplayName("Тест: NEW скидка 5%")
    void calc_shouldApplyNEWDiscount() {
        List<Item> items = Arrays.asList(
                new Item("Phone", 200.0, 3)    // 600
        );
        double result = orderService.calc(items, "NEW");
        assertEquals(570.0, result, 0.001); // 600 * 0.95 = 570
    }

    @Test
    @DisplayName("Тест: VIP скидка + фиксированная скидка -50 (сумма > 1000)")
    void calc_shouldApplyVIPAndThenFixedDiscount() {
        List<Item> items = Arrays.asList(
                new Item("TV", 1000.0, 2)      // 2000
        );
        double result = orderService.calc(items, "VIP");
        assertEquals(1750.0, result, 0.001); // 2000 * 0.9 = 1800 → 1800 - 50 = 1750
    }

    @Test
    @DisplayName("Тест: NEW скидка + фиксированная скидка -50 (сумма > 1000)")
    void calc_shouldApplyNEWAndThenFixedDiscount() {
        List<Item> items = Arrays.asList(
                new Item("Tablet", 1100.0, 1)  // 1100
        );
        double result = orderService.calc(items, "NEW");
        assertEquals(995.0, result, 0.001); // 1100 * 0.95 = 1045 → 1045 - 50 = 995
    }

    @Test
    @DisplayName("Тест: сумма > 1000 без скидки типа — только -50")
    void calc_shouldApplyFixedDiscountOnly() {
        List<Item> items = Arrays.asList(
                new Item("Book", 600.0, 2)     // 1200
        );
        double result = orderService.calc(items, "REGULAR");
        assertEquals(1150.0, result, 0.001); // 1200 - 50 = 1150
    }

    @Test
    @DisplayName("Тест: пустой список товаров")
    void calc_shouldReturnZeroForEmptyList() {
        List<Item> items = List.of();
        double result = orderService.calc(items, "REGULAR");
        assertEquals(0.0, result, 0.001);
    }

    @Test
    @DisplayName("Тест: сумма ровно 1000 — не применяется -50")
    void calc_shouldNotApplyFixedDiscountWhenExactly1000() {
        List<Item> items = Arrays.asList(
                new Item("Monitor", 500.0, 2)  // 1000
        );
        double result = orderService.calc(items, "VIP");
        assertEquals(900.0, result, 0.001); // 1000 * 0.9 = 900 → 900 <= 1000 → no -50
    }

    @Test
    @DisplayName("Тест: несколько скидок — VIP и NEW не должны применяться одновременно")
    void calc_shouldApplyOnlyOneTypeDiscount() {
        List<Item> items = Arrays.asList(
                new Item("Headphones", 1000.0, 1) // 1000
        );
        double vipResult = orderService.calc(items, "VIP");
        double newResult = orderService.calc(items, "NEW");

        assertEquals(900.0, vipResult, 0.001); // 1000 * 0.9
        assertEquals(950.0, newResult, 0.001); // 1000 * 0.95
    }

    @Test
    @DisplayName("Тест: неизвестный тип — игнорируется, только базовая сумма + -50 если >1000")
    void calc_shouldIgnoreUnknownType() {
        List<Item> items = Arrays.asList(
                new Item("Chair", 800.0, 2)    // 1600
        );
        double result = orderService.calc(items, "UNKNOWN");
        assertEquals(1550.0, result, 0.001); // 1600 - 50 = 1550
    }

    @Test
    @DisplayName("Тест: отрицательная цена — не должно ломаться (логика не проверяет валидность)")
    void calc_shouldHandleNegativePrice() {
        List<Item> items = Arrays.asList(
                new Item("Defective", -50.0, 2) // -100
        );
        double result = orderService.calc(items, "VIP");
        assertEquals(-90.0, result, 0.001); // -100 * 0.9 = -90
    }

    @Test
    @DisplayName("Тест: нулевое количество — не влияет на сумму")
    void calc_shouldHandleZeroQuantity() {
        List<Item> items = Arrays.asList(
                new Item("FreeSample", 100.0, 0), // 0
                new Item("ActualItem", 200.0, 1)  // 200
        );
        double result = orderService.calc(items, "NEW");
        assertEquals(190.0, result, 0.001); // 200 * 0.95 = 190
    }
}
