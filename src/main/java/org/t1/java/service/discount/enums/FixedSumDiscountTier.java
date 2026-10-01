package org.t1.java.service.discount.enums;

/**
 *
 * @author DRakovskiy
 */
public enum FixedSumDiscountTier {
    NONE(0, 0.0),
    TIER_1(1000, 50),
    TIER_2(2000, 100),
    TIER_3(5000, 200);

    private final double minAmount;  // минимальная сумма для применения скидки
    private final double discount;   // фиксированная скидка

    FixedSumDiscountTier(double minAmount, double discount) {
        this.minAmount = minAmount;
        this.discount = discount;
    }

    /**
     * Найти подходящую скидку относительно суммы
     * @param amount сумма покупки
     * @return скидка
     */
    public static double findFor(double amount) {
        FixedSumDiscountTier discountTier = NONE;
        for (FixedSumDiscountTier tier : values()) {
            if (amount >= tier.minAmount) {
                discountTier = tier;
            }
        }
        return discountTier.getDiscount();
    }

    public double getDiscount() {
        return discount;
    }

    public double getMinAmount() {
        return minAmount;
    }
}
