package org.t1.java.service.discount.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Enum для типов скидок и получения дисконта
 * @author DRakovskiy
 */

public enum DiscountByUserType {

    VIP(0.9),     // 10% скидка
    NEW(0.95),    // 5% скидка
    NONE(1.0);    // нет скидки (по умолчанию)

    private final double multiplier;

    DiscountByUserType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    /**
     *  Метод для безопасного преобразования строки в Enum
     * @param type - пытаемся найти тип скидки
     * @return если нашли то возвращаем дисконт или NONE если не наши или пустой тип
     */
    public static DiscountByUserType fromString(String type) {
        if (StringUtils.isBlank(type)) {
            return NONE;
        }
        for (DiscountByUserType dt : values()) {
            if (dt.name().equalsIgnoreCase(type)) {
                return dt;
            }
        }
        return NONE;
    }
}
