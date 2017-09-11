package com.teste.custom.linkedlist;

public class Node<E> {

	private Node<E> next;

	private E data;

	public Node(Node<E> next, E data) {
		super();
		this.next = next;
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

}