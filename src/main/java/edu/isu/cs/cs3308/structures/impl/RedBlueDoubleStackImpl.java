package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Deque;
import edu.isu.cs.cs3308.structures.RedBlueDoubleStack;

public class RedBlueDoubleStackImpl<E> implements RedBlueDoubleStack<E> {

    private DoublyLinkedList<E> dll;

    /**
     * Adds the element to the top of the Red Stack, unless the element is null.
     *
     * @param element Element to add.
     */
    @Override
    public void pushRed(E element) {
        dll.addFirst(element);
    }

    /**
     * Adds the element to the top of the Blue Stack, unless the element is
     * null.
     *
     * @param element Element to add.
     */
    @Override
    public void pushBlue(E element) {
        dll.addLast(element);
    }

    /**
     * Removes the element at the top of the Red Stack and returns its value,
     * unless the Red Stack is empty.
     *
     * @return Element at the top of the Red Stack, or null if the Red Stack is
     * empty
     */
    @Override
    public E popRed() {
        return dll.removeFirst();
    }

    /**
     * Removes the element at the top of the Blue Stack and returns its value,
     * unless the Blue Stack is empty.
     *
     * @return Element at the top of the Red Stack, or null if the Blue Stack is
     * empty
     */
    @Override
    public E popBlue() {
        return dll.removeLast();
    }

    /**
     * Returns the value at the top of the Red Stack.
     *
     * @return The value at the top of the Red Stack, or null if the Red Stack
     * is emtpy
     */
    @Override
    public E peekRed() {
        return dll.get(0);
    }

    /**
     * Returns the value at the top of the Blue Stack.
     *
     * @return The value at the top of the Blue Stack, or null if the Blue Stack
     * is emtpy
     */
    @Override
    public E peekBlue() {
        return dll.get(dll.size());
    }

    /**
     * @return Current size of the Blue Stack
     */
    @Override
    public int sizeBlue() {
        return dll.size();
    }

    /**
     * @return Current size of the Red Stack
     */
    @Override
    public int sizeRed() {
        return dll.size();
    }

    /**
     * @return True if the Blue Stack is empty, false otherwise
     */
    @Override
    public boolean isBlueEmpty() {
        return dll.isEmpty();
    }

    /**
     * @return True if the Red Stack is empty, false otherwise
     */
    @Override
    public boolean isRedEmpty() {
        return dll.isEmpty();
    }
}
