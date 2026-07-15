package org.t1.java.types.superfastlist.dto;

/**
 *
 * @author DRakovskiy
 */
public class Node<T> {
    T value;
    Node<T> prev;
    Node<T> next;

    Node(T value) {
        this.value = value;
    }

}
