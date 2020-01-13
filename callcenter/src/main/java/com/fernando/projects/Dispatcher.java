/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.projects;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * @author Fernando
 */
public class Dispatcher extends Thread { 
    BlockingQueue<Employee> empList;
    BlockingQueue<Call> callList;
    
    public Dispatcher() {
	empList = new PriorityBlockingQueue<Employee>();
	callList = new LinkedBlockingQueue<Call>();
    }
    
    @Override
    public void run(){
        Call call;
	Employee employee;
	try {
	    while (true) {
		call = callList.take();
		System.out.println("Llamada en espera " + call.getDescription());
		employee = empList.take();
		System.out.println("El empleado " + employee.getType() + " atendera la llamada " + call.getDescription());
		employee.asignCall(call);
	    }
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
    
    
    public void dispatchCall(Call call) throws InterruptedException {
	System.out.println("Llamada entrante " + call.getDescription());
	this.callList.put(call);
    }
    
    
    public void addAvailableEmployee(Employee employee) {
	this.empList.add(employee);
    }

    public Queue<Call> getCalls() {
	return callList;

    }

    public Queue<Employee> getAvailableEmployees() {
	return empList;
    }
}
