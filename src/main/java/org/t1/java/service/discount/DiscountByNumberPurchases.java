package org.t1.java.service.discount;

import org.t1.java.dto.Item;
import org.t1.java.service.discount.enums.FixedNumberDiscountTier;

import java.util.List;

/**
 *
 * @author DRakovskiy
 */
public class DiscountByNumberPurchases extends DiscountRule {

    /**
     *
     * @param order порядок в карусели, если он больше нуля то ставим, нет по умолчанию
     */
    public DiscountByNumberPurchases(Integer order) {
        super(order);
    }

    @Override
    public double calculateDiscount(List<Item> items, String type, double sum, int count) {
        double fixedNumberDiscountTier = FixedNumberDiscountTier.findFor(count);
        return sum * fixedNumberDiscountTier;
    }
}
