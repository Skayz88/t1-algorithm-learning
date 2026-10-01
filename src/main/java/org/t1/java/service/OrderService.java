package org.t1.java.service;

import org.t1.java.dto.Item;
import org.t1.java.service.discount.enums.DiscountByUserType;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author DRakovskiy
 */
public class OrderService {

    private final DiscountService discountService = new DiscountService();

    /**
     *
     * Раасчет стоимости товаров в корзине
     * Проходим по корзине, берем товары, вычисляем стоимость
     * Рассчитываем скидку - для типа VIP 90%, для NEW 95, а для товаров на сумму более 1000 скидка 50 и добавляем 10% по кол-ву
     *
     * @param items - Список товаров в корзине
     * @param type  - Тип покупателя
     * @return сколько денежек надо заплатить за всю красоту
     */
    public double calc(List<Item> items, String type) {

        if (Objects.isNull(items) || items.isEmpty()) return 0;

        return discountService.getSumAfterAllAvailableDiscounts(items, type);
    }

}

