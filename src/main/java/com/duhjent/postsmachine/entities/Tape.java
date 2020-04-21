package com.duhjent.postsmachine.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tape {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private List<Boolean> list = new ArrayList<Boolean>();

	int currentpos = 0;

	public Tape(String string){
		list.add(false);
		int len = string.length();
		for(int i = 0; i < len; i++){
			list.add(string.charAt(i) == '1');
		}
	}

	public void moveLeft(){
		if(currentpos == 0){
			this.list.add(0, false);
		}
		else{
			currentpos--;
		}
	}

	public void moveRight(){
		if(currentpos == (this.list.size() - 1)){
			this.list.add(false);
		}
		currentpos++;
	}

	public boolean getState(){
		return this.list.get(currentpos);
	}

	public void setState(boolean state){
		this.list.set(currentpos, state);
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(boolean b: this.list){
			builder.append(b ? "1" : "0");
		}
		return builder.toString();
	}
}