package org.t1.java.model;

import org.t1.java.dto.Data;

public interface Operation<T> {
    T perform(Data<T> data);
}
