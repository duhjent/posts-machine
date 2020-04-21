package com.duhjent.postsmachine.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tape {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Node head;
	
	private Node current;

	private class Node{
		private boolean state;
		private Node next;
		private Node prev;
		
		public Node(boolean state) {
			this.state = state;
			this.next = null;
			this.prev = null;
		}
		
		public boolean getState() {
			return this.state;
		}
		
		@Override
		public String toString() {
			if(this.state) return "1";
			else return "0";
		}
	}
	
	public Tape(String s) {
		this.head = this.current = new Node(false);
		for(int i = 0; i < s.length(); i++) {
			this.append(s.charAt(i) == '1');
		}
	}
	
	private void append(boolean state) {
		Node temp = this.head;
		while(temp.next != null)
			temp = temp.next;
		Node newNode = new Node(state);
		temp.next = newNode;
		newNode.next = null;
		newNode.prev = temp;
	}
	
	private void insertToStart(boolean state) {
		Node newNode = new Node(state);
		this.head.prev = newNode;
		newNode.next = head;
		newNode.prev = null;
		this.head = newNode;
	}
	
	public void moveLeft() {
		if(current.prev == null) this.insertToStart(false);
		current = current.prev;
	}
	
	public void moveRight() {
		if(current.next == null) this.append(false);
		current = current.next;
	}
	
	public boolean getState() {
		return current.getState();
	}
	
	public void setState(boolean state) {
		this.current.state = state;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node temp = head;
		while(temp != null) {
			result.append(temp.toString());
			temp = temp.next;
		}
		return result.toString();
	}
}