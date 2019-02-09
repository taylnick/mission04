package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Deque;
import edu.isu.cs.cs3308.structures.Queue;

public class LinkedDeque<E> implements Deque<E> {

    private DoublyLinkedList<E> dll = new DoublyLinkedList<>();

    /**
     * @return The value of the last element of the deque (without removing it),
     * or null if the deque is empty.
     */
    public E peekLast() {
        return dll.get(dll.size-1);
    }

    /**
     * Inserts the given element into the front of the deque, unless the
     * provided value is null.
     *
     * @param element Element to be inserted to the front of the deque, nothing
     *                happens if the value is null.
     */
    public void offerFirst(E element) {
        dll.addFirst(element);
    }

    /**
     * @return The value of the last item in the Deque and removes that value
     * from the deque, if the deque was empty null is returned.
     */
    public E pollLast() {
        return dll.removeLast();
    }

    /**
     * @return The number of elements in the queue
     */
    @Override
    public int size() {
        return dll.size();
    }

    /**
     * @return tests whether the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return dll.isEmpty();
    }

    /**
     * Inserts an element at the end of the queue.
     *
     * @param element Element to be inserted.
     */
    @Override
    public void offer(E element) {
        dll.addLast(element);
    }

    /**
     * @return The value first element of the queue (with out removing it), or
     * null if empty.
     */
    @Override
    public E peek() {
        return dll.get(0);
    }

    /**
     * @return The value of the first element of the queue (and removes it), or
     * null if empty.
     */
    @Override
    public E poll() {
        return dll.removeFirst();
    }

    /**
     * Prints the contents of the queue starting at top, one item per line. Note
     * this method should not empty the contents of the queue.
     */
    @Override
    public void printQueue() {
        dll.printList();
    }

    /**
     * Tranfers the contents of this queue into the provided queue. The contents
     * of this queue are to found in reverse order at the top of the provided
     * queue. This queue should be empty once the transfer is completed. Note
     * that if the provided queue is null, nothing is to happen.
     *
     * @param into The new queue onto which the reversed order of contents from
     *             this queue are to be transferred to the top of, unless the provided queue
     *             is null.
     */
    @Override
    public void transfer(Queue<E> into) {
        if(this.isEmpty()) return;
        if(into == null) return;
        while(this.size() > 0){
            into.offer(this.pollLast());
        }
    }

    /**
     * Reverses the contents of this queue.
     */
    @Override
    public void reverse() {
        LinkedDeque<E> tempDeque = new LinkedDeque<>();
        this.transfer(tempDeque);

        while(!tempDeque.isEmpty()){
            this.offer(tempDeque.poll());
        }
    }

    /**
     * Merges the contents of the provided queue onto the bottom of this queue.
     * The order of both queues must be preserved in the order of this queue
     * after the method call. Furthermore, the provided queue must still contain
     * its original contents in their original order after the method is
     * complete. If the provided queue is null, no changes should occur.
     *
     * @param from Queue whose contents are to be merged onto the bottom of
     *             this queue.
     */
    @Override
    public void merge(Queue<E> from) {
        if(from == null) return;
        LinkedDeque<E> tempDeque = new LinkedDeque<>();
        DoublyLinkedList<E> copydll = new DoublyLinkedList<>();
        from.transfer(tempDeque);
        for(int i = 0; i < tempDeque.size(); i++){
            copydll.addLast(tempDeque.dll.get(i));
        }
        tempDeque.transfer(from);

        while(!copydll.isEmpty()){
            this.offer(copydll.removeLast());
        }
    }
}
