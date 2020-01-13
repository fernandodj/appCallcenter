/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.projects;

/**
 *
 * @author Fernando
 */
public class Supervisor extends Employee{
    Supervisor(String type, Dispatcher disp) {
	super(type, disp);
        super.ePriority = EmployeePriority.SUPERVISOR;
    }
    
    void addAvailableEmployee(Dispatcher dispatcher) {
	dispatcher.addAvailableEmployee(new Supervisor(type, dispatcher));
    }
}
