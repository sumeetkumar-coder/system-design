package com.sumeet.design2;

public class LinkedListCustom {

	Node head = null;
	int size = 0;

	class Node {

		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	private void addElementAtFirst(int value) {

		Node node = new Node(value);
		node.next = head;
		head = node;

		size++;

	}

	public void addElementAtPosition(int index, int value) {

		if (index > size) {
			throw new RuntimeException("IllegalOperation: Invalid Index:" + index);
		}

		if (index == 0) {
			addElementAtFirst(value);

		} else {
			Node node = new Node(value);
			Node temp = head;
			int count = 1;
			while (count < index) {

				temp = temp.next;
				count++;
			}
			node.next = temp.next;
			temp.next = node;
			
			size++;

		}
		
	}
	
	public void addElement (int value) {
		
		if (head == null) {
			addElementAtFirst(value);
			
		} else {
			Node node = new Node(value);
			Node temp = head;
			
			while (temp.next != null) {
				temp = temp.next;
			}
			
			temp.next = node;
			size++;
		}
		
	}
	
	public void removeFirst() {
		
		Node temp = head;
		
		if (temp.next != null) {
			head = temp.next;
			size--;
		}
		temp = null;
	}
	
	public void removeAtLast() {
		Node temp = head;
		Node prev = null;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		if (prev != null) {
			prev.next = null;
		}
		temp = null;
	}
	
	public int size() {
		return this.size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node temp = head;
		while (temp != null) {
			sb.append(temp.data);
			sb.append(",");
			temp = temp.next;
		}
		
		String s = sb.length() > 1 ? sb.substring(0,sb.length()-1) : sb.toString();
		s = s + "]";
		return s;
		
	}

}
