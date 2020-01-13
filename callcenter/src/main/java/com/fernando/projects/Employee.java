/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.projects;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 *
 * @author Fernando
 */
public abstract class Employee extends Thread implements Comparable<Employee>{
    protected String type;
    protected EmployeePriority ePriority;
    
    private Call callEmployee;
    private Dispatcher dispatcher;
    
    public Employee(String type, Dispatcher dispatcher) 
    { 
        this.type = type;  
        this.dispatcher = dispatcher;
    } 
    
    public String getType() 
    { 
        return type; 
    }
    
    public int getPriorities() {
	return this.ePriority.getPriority();
    }
       
    //Al usar una PriorityBlockingQueue es necesario implementar esta funcion, la cual utiliza para evaluar las prioridades
    public int compareTo(Employee emp) {
	if (this.getPriority() < emp.getPriority()) {
	    return -1;
	}
	if (this.getPriority() > emp.getPriority()) {
	    return 1;
	}
	return 0;
    }
    
    public void setType(String eType)
    {
        this.type = eType;
    }

    abstract void addAvailableEmployee(Dispatcher disp);
    
    public void asignCall(Call call) throws InterruptedException {
	this.callEmployee = call;
	this.start();
    }
    
    // Hilo de atencion de llamada.
    public void run() {
	try {
	    Thread.sleep(1000 * callEmployee.getDuration());
	    System.out.println(
		    "Llamada " + callEmployee.getDescription() + " terminada. Duracion:" + callEmployee.getDuration() + " milisegundos");
	    this.addAvailableEmployee(dispatcher);
	    System.out.println("Empleado " + this.getType() + " disponible");
	} catch (InterruptedException e) {
	    System.out.println("Error al responder la llamada " + callEmployee.getDescription());
	    e.printStackTrace();
	}
    }
}
