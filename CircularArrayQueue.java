package jsjf;

import jsjf.exceptions.*;

/**
 * CircularArrayQueue represents an array implementation of a queue in which the
 * indexes for the front and rear of the queue circle back to 0 when they reach
 * the end of the array.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    private static int DEFAULT_CAPACITY = 4;
    private int front, rear, count;
    private T[] queue;
    private int totalCount;

    /**
     * Creates an empty queue using the specified capacity.
     *
     * @param initialCapacity the initial size of the circular array queue
     */
    public CircularArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Adds the specified element to the rear of this queue, expanding the
     * capacity of the queue array if necessary.
     *
     * @param element the element to add to the rear of the queue
     */
    public void enqueue(T element) {

        if (size() == qlength()) {
            System.out.println("The array is full!");
            System.out.println("Expanding array...");
            expandCapacity();
            System.out.println("DONE!");
        }

        queue[rear] = element;
        rear = (rear + 1) % queue.length;

        count++;
        totalCount++;
    }

    /**
     * Creates a new array to store the contents of this queue with twice the
     * capacity of the old one.
     */
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);

        for (int scan = 0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }

        front = 0;
        rear = count;
        queue = larger;
    }

    /**
     * Removes the element at the front of this queue and returns a reference to
     * it.
     *
     * @return the element removed from the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;

        count--;

        return result;
    }

    /**
     * Returns a reference to the element at the front of this queue. The
     * element is not removed from the queue.
     *
     * @return the first element in the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            try {
                throw new EmptyCollectionException("queue");
            } catch (EmptyCollectionException e) {
                System.out.println(e);
                return null;
            }
        }

        return queue[front];
    }

    /**
     * Returns true if this queue is empty and false otherwise.
     *
     * @return true if this queue is empty
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }

        return false;
    }

    /**
     * Returns the current capacity in the queue.
     *
     * @return the size of the queue
     */
    public int size() {

        if (qlength() > DEFAULT_CAPACITY) {
            DEFAULT_CAPACITY = DEFAULT_CAPACITY * 2;
        }

        return DEFAULT_CAPACITY;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of the queue
     */
    public String toString() {
        if (isEmpty()) {
            try {
                throw new EmptyCollectionException("queue");
            } catch (EmptyCollectionException e) {
                return e.toString() + "\n";
            }
        }

        String strlqs = "";

        if (front == 0) {
            for (int i = front; i < count; i++) {

                strlqs += (String) queue[i] + "\n";

            }
        }
        if (front > 0) {

            for (int i = 0; i < count; i++) {
                if (queue[i] != null) {
                    strlqs += (String) queue[i] + "\n";
                }

            }
        }
        return strlqs;
    }

    /**
     * Returns the number of elements currently in this queue.
     *
     * @return the size of the queue
     */
    public int qlength() {

        return count;
    }

    /**
     * Displays the string representation of this queue
     */
    public void list() {
        System.out.println("Elements on the Queue:");
        System.out.print(toString());
    }

}
/*for (int i = front; i < count ; i++){
           
            strlqs += (String)queue[i] + "\n";
           totalCount++;
        }
        } else if(front > 0 && countchecker2 != countchecker){
        for(int j = front; j <= count; j++){
        if (queue[j] != null){
          strlqs += (String)queue[j] + "\n";
        }
        
        }
        for(int g = 0; g < front; g++)
        {
             if (queue[g] != null){
          strlqs += (String)queue[g] + "\n";
        }
            
        }
                
                
        } else {
            for (int f = 0; f < totalCount ; f++){
          if (queue[f] != null){
          strlqs += (String)queue[f] + "\n";
        }
        }
}*/