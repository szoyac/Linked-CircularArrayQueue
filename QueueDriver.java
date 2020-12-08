
package jsjf;

import java.util.Scanner;
/**
 *@author Stephen Zoyac
 * @Date: 10/4/20
 * Fall 2020
 * Linked Queue Project
 * This program runs a menu for a Linked Queue, which implements the QueueADT
 *  The menu has 5 options, 1 to enqueue an element on the queue, 2 to dequeue 
 * an element on the queue,  3 to see the head of the queue,
 * 4 to list all the elements of the queue, and 5 to close the program. 
 * If the queue is empty, and if the user tries to enqueue, dequeue, or list
 * an empty queue, the exception will be caught, and the program will continue.
 */

public class QueueDriver {
    
     public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        LinkedQueue<String> lqs = new LinkedQueue<>();
        int menu = 0;
        System.out.println("Queue Menu Selections 1.enqueue | 2.dequeue |"
                + " 3.peek | 4.list | 5.Exit");
        System.out.println();
        
        
        do {

            System.out.print("Enter your choice: ");
            menu = Integer.parseInt(input.next());
            switch (menu) {
                case 1:
                    System.out.print("Enter element: ");
                    String element = input.next();
                    lqs.enqueue(element);
                    break;
                case 2:

                    System.out.println("Dequeued element is " + lqs.first());
                    if(lqs.isEmpty())
                        break;
                    lqs.dequeue();
                    break;
                case 3:

                    System.out.println("Current head is " + lqs.first());       
                    break;
                case 4:
                    lqs.list();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (menu <= 5);

    }
    
}
