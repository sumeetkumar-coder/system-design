package com.sumeet.design2;

public class LinkedListCustomImpl {

	public static void main(String[] args) {

		LinkedListCustom obj = new LinkedListCustom();

		System.out.println(obj.toString());
		
		obj.addElement(21);
		obj.addElement(22);

		System.out.println(obj.toString());
	
		obj.addElementAtPosition(2, 10);

		System.out.println(obj.toString());

		obj.addElementAtPosition(1, 7);

		System.out.println(obj.toString());

		System.out.println(obj.size);

		obj.addElementAtPosition(0, 2);

		System.out.println(obj.toString());
		
		obj.addElement(20);
		
		System.out.println(obj.toString());
		
		obj.removeFirst();
		
		System.out.println(obj.toString());
		
		//obj.removeAtLast();
		
		System.out.println(obj.toString());

	}

}
