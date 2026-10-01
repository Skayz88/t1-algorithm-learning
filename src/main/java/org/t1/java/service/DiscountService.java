package org.t1.java.service;

import org.t1.java.dto.Item;
import org.t1.java.service.discount.DiscountByNumberPurchases;
import org.t1.java.service.discount.DiscountBySumPurchases;
import org.t1.java.service.discount.DiscountByUserTypeService;
import org.t1.java.service.discount.DiscountRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author DRakovskiy
 */
public class DiscountService {

    private final List<DiscountRule> discounts;

    /**
     * Прогружаем наши скидки и сортируем в порядке возрастания
     */
    public DiscountService() {
        List<DiscountRule> discountsInService = new ArrayList<>();
        discountsInService.add(new DiscountByUserTypeService(1));
        discountsInService.add(new DiscountByNumberPurchases(2));
        discountsInService.add(new DiscountBySumPurchases(3));
        Collections.sort(discountsInService);
        this.discounts = discountsInService;
    }

    /**
     *
     * @param items - корзина с покупками
     * @return сумма после всех скидок которые применимы для пользователя
     */
    public double getSumAfterAllAvailableDiscounts(List<Item> items, String type) {
        double sum = getMyPriceMyGoods(items);
        int count = getMyCountMyGoods(items);
        for(DiscountRule discountRule : discounts) {
            sum = discountRule.calculateDiscount(items, type, sum, count);
        }
        return sum;
    }

    /**
     * Счетаем общую сумму корзины
     * @param items - список покупок
     * @return цену всей корзины
     */
    private double getMyPriceMyGoods(List<Item> items) {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    /**
     * Счетаем количество товаров в корзине
     * @param items - список покупок
     * @return всего товаров в карзине
     */
    private int getMyCountMyGoods(List<Item> items) {
        return items.stream()
                .mapToInt(Item::getQuantity)
                .sum();
    }


}
