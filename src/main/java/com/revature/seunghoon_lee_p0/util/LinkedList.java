package com.revature.seunghoon_lee_p0.util;

public class LinkedList<T> implements List<T>, Queue<T> {

    private int size;

    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        T data;
        Node<T> prevNode;
        Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> prevNode, Node<T> nextNode) {
            this.data = data;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T data) {
        if(data == null) {
            throw new IllegalArgumentException("Null is not allowed as an argument!");
        }
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            tail = head = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean contains(T data) {
        if(data == null) {
            throw new IllegalArgumentException("Null is not allowed as an argument!");
        }
        Node<T> currentNode = head;
        for (int i = 0 ; i < size ; i++) {
            if (currentNode.data == data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(T data) {
        if(data == null) {
            throw new IllegalArgumentException("Null is not allowed as an argument!");
        }
        Node<T> currentNode = head;
        for ( int i = 0 ; i < size ; i++) {
            if (currentNode.data == data) {
                if(currentNode.prevNode != null) {
                    currentNode.prevNode.nextNode = currentNode.nextNode;
                } else {

                }
                if(currentNode.nextNode != null) {
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                }
                size--;
                return data;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is out of bounds!");
        }
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return currentNode.data;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    @Override
    public T peek() {
        if(head != null) {
            return head.data;
        }
        return null;
    }

    @Override
    public T poll() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.nextNode;
        if (head == null) {
            tail = null;
        } else {
            head.prevNode = null;
        }
        size--;
        return data;
    }

}
