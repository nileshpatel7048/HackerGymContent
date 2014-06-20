package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Fathalian on 6/5/14.
 * HackerGym.com
 */
public class Reverse<T> {

    public LinkedListNode<T> reverseWithStack(LinkedListNode<T> head) {

        //using java class Deque for stack.
        Deque<LinkedListNode<T>> stack = new ArrayDeque<>();

        LinkedListNode<T> temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        if (stack.isEmpty()) return null;

        //pop the new head first and the pop one by one from stack
        //and append to the new head
        LinkedListNode<T> newHead = stack.pop();
        LinkedListNode<T> currentNode = newHead;
        while (!stack.isEmpty()) {
            currentNode.next = stack.pop();
            currentNode = currentNode.next;
        }

        //since we are reusing linkedlist elements, make sure that the
        //last node points to null
        currentNode.next = null;

        return newHead;
    }

    public LinkedListNode<T> reverseRecursively(LinkedListNode<T> linkedList) {
        if (linkedList == null) return null;

        // To solve this problem recursively, we need to select element i and then
        // reverse the list pointed by i.next. Then we are going to append i to the end
        // of the newly reverse list. To do that efficiently, we always need a pointer to the
        // end of the reversed list. So we need to references: one two point to the end of each
        // reversed sub list and one two point to head of the overall reversed list.
        // Because we can't return two values in a method in java, we will use a container object.
        // When we reach the end of the initial list in our recursive method, we will push the last
        // element into this container object. This element will be head of the reversed list.
        // when the method is done reversing the list, we get the new head and return it
        // Why do we use a ArrayList container object ? Why can't we just pass a reference of
        // type LinkedListNode and when we see the last element just point the reference to that ?
        // We can't do this because:
        // "Java manipulates objects 'by reference,' but it passes object references to methods 'by value."
        // This is one of those common mistakes that people make.
        // If this surprise you, take a look at:
        // http://www.javaworld.com/article/2077424/learn-java/does-java-pass-by-reference-or-pass-by-value.html

        List<LinkedListNode<T>> newHeadContainer = new ArrayList<>();
        solveRecursively(linkedList, newHeadContainer);

        //If there is at least a single element in the linkedlist, the newHeadContainer
        //cannot be empty. We have made sure that we only get to this part of the code
        //if the list is not empty. So no need to check to see if the container is empty.
        return newHeadContainer.get(0);
    }

    //
    private LinkedListNode<T> solveRecursively(LinkedListNode<T> head,
                                               List<LinkedListNode<T>> newHeadContainer) {

        //terminating condition for the recursive algorithm
        if (head.next == null) {
            newHeadContainer.add(head);
            return head;
        }

        LinkedListNode<T> reversedOfRest = solveRecursively(head.next, newHeadContainer);
        reversedOfRest.next = head;
        //here is another common mistake. If you do not set the head.next to null, you will most likely
        // create a circular linked list and cause the recursion to go indefinitely. .
        head.next = null;
        return head;
    }


    public LinkedListNode<T> reverseWithPointers(LinkedListNode<T> linkedList) {

        //first take care of edge cases
        if (linkedList == null) return null;
        //one element in linked list
        if (linkedList.next == null) return linkedList;
        //two elements in linked list
        if (linkedList.next.next == null) {
            LinkedListNode<T> newHead = linkedList.next;
            newHead.next = linkedList;
            linkedList.next = null;
            return newHead;
        }

        LinkedListNode<T> first = null;
        LinkedListNode<T> second = linkedList;
        LinkedListNode<T> third = second.next;


        while (second != null) {
            second.next = first;

            //now move everything ahead one node, starting from first
            first = second;
            second = third;
            if (third != null) {
                third = third.next;
            }
        }
        return first;
    }
}
