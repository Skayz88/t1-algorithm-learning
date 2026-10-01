package org.t1.java.service.discount;

import org.t1.java.dto.Item;
import org.t1.java.service.discount.enums.FixedSumDiscountTier;

import java.util.List;

/**
 *
 * @author DRakovskiy
 */
public class DiscountBySumPurchases extends DiscountRule{
    /**
     *
     * @param order порядок в карусели, если он больше нуля то ставим, нет по умолчанию
     */
    public DiscountBySumPurchases(Integer order) {
        super(order);
    }

    @Override
    public double calculateDiscount(List<Item> items, String type, double sum, int count) {
        double discount = FixedSumDiscountTier.findFor(sum);
        return sum - discount;
    }
}
