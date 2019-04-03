package com.dparttern.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Observable {
	
	private Set<Observer> observers = new HashSet<Observer>();
	
	public void  addObserver(Observer observer){
		this.observers.add(observer);
	}
	
	public void deleteObserver(Observer observer){
		this.observers.remove(observer);
	}
	
	public void notifyObservers(String context){
		for(Observer observer: observers){
			observer.update(context);
		}
	}
}
