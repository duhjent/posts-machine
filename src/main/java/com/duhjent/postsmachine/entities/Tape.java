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
	
	private String vals;

	int currentpos;

	public Tape(String vals){
		this.vals = vals;
		this.currentpos = 0;
	}

	public void moveLeft(){
		if(currentpos == 0){
			StringBuilder builder = new StringBuilder();
			builder.append("0");
			builder.append(this.vals);
			this.vals = builder.toString();
		}
		else{
			currentpos--;
		}
	}

	public void moveRight(){
		if(currentpos == (this.vals.length() - 1)){
			StringBuilder builder = new StringBuilder(this.vals);
			builder.append("0");
			this.vals = builder.toString();
		}
		currentpos++;
	}

	public boolean getState(){
		return this.vals.charAt(currentpos) == '1';
	}

	public void setState(boolean state){
		StringBuilder builder = new StringBuilder(this.vals);
		builder.setCharAt(currentpos, state ? '1' : '0');
	}

	@Override
	public String toString(){
		return vals;
	}
}