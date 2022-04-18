package com.sumeet.design3;

public class CustomStack {
	
	 int size = -1;
	    
	    Node head = null;

	    class Node {
	        int data;
	        Node next;

	        Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }



	    public void push(int x) {

	        Node n = new Node(x);

	        if (head == null) {
	            head = n;
	        } else {
	            n.next = head;
	            head = n;
	        }
	       
	        size++;
	    }

	    public void pop() {

	        Node temp = head;
	        if (temp != null) {
	            
	            head = temp.next;
	            size--;
	        }
	       
	        temp = null;
	        
	    }

	    public int top() {
	        if(size == -1) {
	            return -1;
	        }
	        return head.data;
	    }

	    public int getMin() {

	        if(size == -1) {
	            return -1;
	        }

	       Node temp = head;

	       int min = Integer.MAX_VALUE;

	       while (temp != null) {

	           if (temp.data < min) {
	               min = temp.data;
	           }

	           temp = temp.next;

	       }

	        return min;
	    }

}
