package com.teste.custom.linkedlist;

public class CustomLinkedList<T> {

	private Node<T> root;

	private int size;

	public CustomLinkedList() {
		this.root = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void add(T o) {
		Node<T> tmp = new Node<T>(null, o);
		if (isEmpty()) {
			root = tmp;
		} else {
			Node<T> current = root;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(tmp);
		}
		size++;
	}

	public void remove(Object o) {
		Node<T> current = root;
		Node<T> previous = null;
		while (current != null) {
			if (current.getData().equals(o)) {
				if (previous == null) {
					root = current.getNext();
				} else {
					previous.setNext(current.getNext());
				}
				size--;
			}
			previous = current;
			current = current.getNext();
		}
	}

	public void addFirst(T o) {
		if (root != null) {
			Node<T> current = root;
			root = new Node<T>(null, o);
			root.setNext(current);
		} else {
			root = new Node<T>(null, o);
		}
		size++;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> current = root;
		while (current != null) {
			sb.append(current.getData()).append(", ");
			current = current.getNext();
		}
		return sb.toString().substring(0, sb.length() - 2);
	}

	public static void main(String[] args) {
		CustomLinkedList<String> list = new CustomLinkedList<String>();
		list.add("teste");
		list.add("teste2");
		list.add("teste3");
		list.add("teste4");
		System.out.println(list.toString());
		System.out.println(list.size());
		list.remove("teste2");
		list.remove("teste");
		System.out.println(list.toString());
		System.out.println(list.size());
		list.add("teste5");
		list.addFirst("teste50");
		System.out.println(list.toString());
		System.out.println(list.size());
	}
}
