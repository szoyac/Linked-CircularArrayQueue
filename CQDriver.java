/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsjf;

import java.util.Scanner;
/**
 *@author Stephen Zoyac
 * @Date: 10/4/20
 * Fall 2020
 * Linked Queue Project
 * This program runs a menu for a Circular Array Queue, which implements the QueueADT
 *  The menu has 6 options, 1 to enqueue an element on the queue, 2 to dequeue 
 * an element on the queue,  3 to see the head of the queue,
 * 4 to list all the elements of the queue, 5 to display the
 * size of the array, and how many values are on it and 6 to close the program. 
 * If the queue is empty, and if the user tries to enqueue, dequeue, or list
 * an empty queue, the exception will be caught, and the program will continue.
 */
public class CQDriver {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        CircularArrayQueue<String> cqs = new CircularArrayQueue<>();
        int menu = 0;
        System.out.println("Stack Menu Selections 1.enqueue | 2.dequeue |"
                + " 3.first | 4.list | 5.size | 6.exit");
        System.out.println();

        do {

            System.out.print("Enter your choice: ");
            menu = Integer.parseInt(input.next());
            switch (menu) {
                case 1:
                
                    System.out.print("Enter element: ");
                    String element = input.next();
                    cqs.enqueue(element);
                    break;
                case 2:

                    System.out.println("dequeued element is " + cqs.first());
                    cqs.dequeue();
                    break;
                case 3:

                    System.out.println("first element is " + cqs.first());
                    break;
                case 4:
                    cqs.list();
                    break;
                case 5:
                    System.out.println("Current Queue holds " + cqs.qlength());
                    System.out.println("Current Queue size is "
                            + cqs.size());
                    break;
                case 6:
                    System.exit(0);
            }
        } while (menu <= 6);

    }

}


