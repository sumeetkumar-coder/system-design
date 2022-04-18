package com.sumeet.design1;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockedList<T> {

	public static final int INITIAL_CAPACITY = 10;

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();

	private Object[] arr;

	private int size = 0;

	public LockedList() {
		arr = new Object[INITIAL_CAPACITY];
	}

	public LockedList(int size) {
		arr = new Object[size];
	}

	private void setCapacity() {
		if (size > arr.length/2) {
			arr = Arrays.copyOf(arr, (arr.length * 2));
		}
	}

	public void addElement(T value) throws InterruptedException {

		writeLock.lock();
			
			try {
				setCapacity();
				arr[size++] = value;

			} catch (Exception e) {
				throw new RuntimeException("Error while adding element");
			} finally {
				writeLock.unlock();
			}
		
	}

	@SuppressWarnings("unchecked")
	public T getElement(int index) throws InterruptedException {

		T t = null;
		
		if (index >= size) {
			throw new RuntimeException("IllegalOperationException: Array index out of bound:" + index);
		} else if (index < 0) {
			throw new RuntimeException("IllegalOperationException: Negative index supplied:" + index);
		}

		readLock.lock();
			
			try {
				t = (T) arr[index];
			} catch (Exception e) {
				throw new RuntimeException("Error while reading element");
			} finally {
				readLock.unlock();
			}
		

		return t;
	}

	public int size() {
		return size;
	}


}
