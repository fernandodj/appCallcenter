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
public class Operator extends Employee{
    Operator(String type, Dispatcher disp) {
	super(type, disp);
        super.ePriority = EmployeePriority.OPERATOR;
    }
    
    void addAvailableEmployee(Dispatcher dispatcher) {
	dispatcher.addAvailableEmployee(new Operator(type, dispatcher));
    }
}
