package edu.mum.cs.cs525.labs.exercises.lab02;

import java.util.Observable;

public class Counter extends Observable
{
   
    private int count;

   
	public Counter (){
       
        count = 0;
    }
    
    public void increment(){
        count++;
        setChanged();
        notifyObservers(new Integer(count));
    }
    
    public void decrement(){
        if (count >0){
            count--;
            setChanged();
            notifyObservers(new Integer(count));
        }
    }
}