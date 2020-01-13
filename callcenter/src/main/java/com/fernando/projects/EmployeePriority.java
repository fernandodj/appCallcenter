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
public enum EmployeePriority {
    OPERATOR(1), SUPERVISOR(2), DIRECTOR(3);
    private int priority;

    EmployeePriority(int priority) {
	this.priority = priority;
    }

    public int getPriority() {
	return priority;
    }
}
