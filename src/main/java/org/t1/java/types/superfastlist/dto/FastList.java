package org.t1.java.types.superfastlist.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author DRakovskiy
 */
public class FastList<T> {
    private Node<T> head;
    private Node<T> tail;
    private final Map<T, Node<T>> valueToNode;
    private int size;

    public FastList() {
        this.head = null;
        this.tail = null;
        this.valueToNode = new HashMap<>();
        this.size = 0;
    }

    public Node<T> addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (Objects.isNull(head)) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        valueToNode.put(value, newNode);
        size++;
        return newNode;
    }

    public Node<T> addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (Objects.isNull(tail)) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        valueToNode.put(value, newNode);
        size++;
        return newNode;
    }

    public Node<T> addBefore(Node<T> target, T value) {
        if (Objects.isNull(target)) throw new IllegalArgumentException("Target is null");
        Node<T> newNode = new Node<>(value);
        newNode.prev = target.prev;
        newNode.next = target;
        if (Objects.nonNull(target.prev)) {
            target.prev.next = newNode;
        } else {
            head = newNode;
        }
        target.prev = newNode;
        valueToNode.put(value, newNode);
        size++;
        return newNode;
    }

    public Node<T> addAfter(Node<T> target, T value) {
        if (target == null) throw new IllegalArgumentException("Target is null");
        Node<T> newNode = new Node<>(value);
        newNode.prev = target;
        newNode.next = target.next;
        if (Objects.nonNull(target.next)) {
            target.next.prev = newNode;
        } else {
            tail = newNode;
        }
        target.next = newNode;
        valueToNode.put(value, newNode);
        size++;
        return newNode;
    }

    public void remove(Node<T> node) {
        if (Objects.isNull(node)) return;
        if (Objects.nonNull(node.prev)) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (Objects.nonNull(node.next)) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        valueToNode.remove(node.value);
        size--;
    }

    public T get(Node<T> node) {
        return Objects.nonNull(node) ? node.value : null;
    }

    public void set(Node<T> node, T newValue) {
        if (Objects.isNull(node)) return;
        valueToNode.remove(node.value);
        node.value = newValue;
        valueToNode.put(newValue, node);
    }

    public boolean contains(T value) {
        return valueToNode.containsKey(value);
    }

    public int indexOf(T value) {
        Node<T> current = head;
        int index = 0;
        while (Objects.nonNull(current )) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }



}
