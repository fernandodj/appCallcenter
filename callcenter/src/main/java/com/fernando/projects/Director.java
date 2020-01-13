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
public class Director extends Employee{
    Director(String type, Dispatcher disp) {
	super(type, disp);
        super.ePriority = EmployeePriority.DIRECTOR;
    }
    
    void addAvailableEmployee(Dispatcher dispatcher) {
	dispatcher.addAvailableEmployee(new Director(type, dispatcher));
    }
}
