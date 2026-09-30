package org.t1.java.service;

import org.t1.java.dto.Item;

import java.util.List;

/**
 *
 * @author DRakovskiy
 */
public class OrderService {

    /**
     *
     * Раасчет стоимости товаров в корзине
     * Проходим по корзине в любом случае, берем товары, даже с отрицательными суммами и ценами
     * Рассчитываем скидку - для типа VIP 90%, для NEW 95, а для товаров на сумму более 1000 скидка 50
     * @param items - Список товаров в корзине
     * @param type - Тип покупателя
     * @return сколько денежек надо заплатить за всю красоту
     */
    public double calc(List<Item> items, String type) {
        double s = 0;
        for (Item i : items) {
            s += i.getPrice() * i.getQuantity();
        }

        if (type.equals("VIP")) {
            s = s * 0.9;
        }

        if (type.equals("NEW")) {
            s = s * 0.95;
        }

        if (s > 1000) {
            s = s - 50;
        }

        return s;
    }
}
