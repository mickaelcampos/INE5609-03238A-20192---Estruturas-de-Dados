/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author m1k4
 */
public class LinkedList {
    
    private int numElements;
    private Node first, last;

    public LinkedList() {
        this.numElements = 0; // -1 ?
        this.first = null;
        this.last = null;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
    
    private void incrementNumElements() {
        this.numElements++;
    }
    
    private void decrementNumElements() {
        this.numElements--;
    }
    
    private boolean isEmpty() {
        return (getNumElements() == 0); // -1 ?/
    }
    
    private void insertEmptyList(Node node) {
        this.setFirst(node);
        this.setLast(node);
        this.incrementNumElements();
    }
    
    public void insertFirst(Object element) {
        Node node = new Node(null, element);
        if (isEmpty()) 
           this.insertEmptyList(node);
         else {
            node.setNext(this.getFirst());
            this.setFirst(node);
            this.incrementNumElements();
        }
    }
    
    public void insertLast(Object element) {
        Node node = new Node(null, element);
        if (isEmpty()) 
           this.insertEmptyList(node);
         else {
            this.getLast().setNext(node);
            this.setLast(node);
            this.incrementNumElements();
        }
    }
    
    public void remove(Object element) {
        if (!isEmpty()) {
            
            Node cursor = this.getFirst();
            for (int i = 0; i < this.getNumElements(); i++) {
                if (cursor.equals(element)) {
                    
                    if (cursor.equals(this.getFirst()) && cursor.equals(this.getLast())) { //is first and last and decrementNumElements
                        this.setFirst(null);
                        this.setLast(null);
                        this.decrementNumElements();
                    }
                    
                    if (cursor.equals(this.getFirst())) { //is first and decrementNumElements
                        this.setFirst(this.getFirst().getNext());
                        this.decrementNumElements();
                    }
                    
                    if (cursor.equals(this.getLast())) { //is last and decrementNumElements
                        Node newLast = this.getFirst();
                        for (int j = 0; j < this.getNumElements()-1; j++) { // -2 ?
                            newLast = newLast.getNext();
                        }
                        newLast.setNext(null);
                        this.setLast(newLast);
                        
                    } 
                
                
                
                } else {
                    cursor = cursor.getNext();
                }
            }
        }
    }
    
}
