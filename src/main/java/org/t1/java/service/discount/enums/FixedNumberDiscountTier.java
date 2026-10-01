package org.t1.java.service.discount.enums;

/**
 * Скидка по кол-ву товаров
 * @author DRakovskiy
 */
public enum FixedNumberDiscountTier {
    NONE(0, 1.0),
    TIER_1(10, 0.9),
    TIER_2(20, 0.8),
    TIER_3(30, 0.7);

    private final int minCount;  // минимальное кол-во для применения скидки
    private final double discount;   // фиксированная скидка

    FixedNumberDiscountTier(int minCount, double discount) {
        this.minCount = minCount;
        this.discount = discount;
    }

    /**
     * Найти подходящую скидку относительно суммы
     * @param count кол-во товаров
     * @return скидка
     */
    public static double findFor(int count) {
        FixedNumberDiscountTier discountTier = NONE;
        for (FixedNumberDiscountTier tier : values()) {
            if (count >= tier.minCount) {
                discountTier = tier;
            }
        }
        return discountTier.getDiscount();
    }

    public double getDiscount() {
        return discount;
    }

    public double getMinAmount() {
        return minCount;
    }

}
