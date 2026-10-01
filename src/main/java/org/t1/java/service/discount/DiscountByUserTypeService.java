package org.t1.java.service.discount;

import org.t1.java.dto.Item;
import org.t1.java.service.discount.enums.DiscountByUserType;

import java.util.List;

/**
 *
 * @author DRakovskiy
 */
public class DiscountByUserTypeService extends DiscountRule {

    public DiscountByUserTypeService(Integer order) {
        super(order);
    }

    /**
     * Вычисление скидки от типа пользователя
     * @return вернет новую сумму с учетом примененной скидки
     */
    @Override
    public double calculateDiscount(List<Item> items, String type, double sum, int count) {
        DiscountByUserType discount = DiscountByUserType.fromString(type);
        return sum*discount.getMultiplier();
    }
}
