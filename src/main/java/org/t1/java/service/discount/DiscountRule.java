package org.t1.java.service.discount;

import org.t1.java.dto.Item;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author DRakovskiy
 */
public abstract class DiscountRule implements Comparable<DiscountRule> {

    /**
     * Порядок с скидочной карусели
     */
    private Integer order = Integer.MAX_VALUE;

    /**
     *
     * @param items - корзина с товарами
     * @param type  - тип пользователя
     * @param sum   - сумма заказа без скидок
     * @param count - кол-во товаров в карзине
     * @return - новая сумма товаров с учетом скидки
     */
   public abstract double calculateDiscount(List<Item> items, String type, double sum, int count);

    /**
     *
     * @param order порядок в карусели, если он больше нуля то ставим, нет по умолчанию
     */
    DiscountRule(Integer order) {
        if (Objects.nonNull(order)
                && order >= 0) {
            this.order = order;
        }
    }

    public Integer getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DiscountRule that = (DiscountRule) o;
        return Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(order);
    }

    @Override
    public int compareTo(DiscountRule other) {
        return Integer.compare(this.order, other.order); // по возрастанию
    }
}
