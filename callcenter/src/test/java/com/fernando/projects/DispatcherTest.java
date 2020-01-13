/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.projects;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Fernando
 */
public class DispatcherTest extends TestCase {
    final int MAXCALLTIME = 10000; // 10 seconds

    public static Test suite() {
	return new TestSuite(DispatcherTest.class);
    }
    
    public void testWhenFourCallsCome() throws InterruptedException {
	Dispatcher dispatcher = new Dispatcher();
	dispatcher.start();
	dispatcher.addAvailableEmployee(new Operator("Operador 1", dispatcher));
	Call call1 = new Call("1");
	call1.setDuration(5);
	Call call2 = new Call("2");
	call2.setDuration(5);
	Call call3 = new Call("3");
	call3.setDuration(5);
	Call call4 = new Call("4");
	call4.setDuration(5);
	dispatcher.dispatchCall(call1);
	dispatcher.dispatchCall(call2);
	dispatcher.dispatchCall(call3);
	dispatcher.dispatchCall(call4);
	Thread.sleep(15000);
	assertTrue(dispatcher.getCalls().isEmpty());
    }
     public void testWhenTenCallsCome() throws InterruptedException {
	Dispatcher dispatcher = new Dispatcher();
	dispatcher.start();
	dispatcher.addAvailableEmployee(new Operator("Operador 1", dispatcher));
	dispatcher.addAvailableEmployee(new Supervisor("Supervisor 1", dispatcher));
	dispatcher.addAvailableEmployee(new Director("Director 1", dispatcher));
	dispatcher.dispatchCall(new Call("1"));
	dispatcher.dispatchCall(new Call("2"));
	dispatcher.dispatchCall(new Call("3"));
	dispatcher.dispatchCall(new Call("4"));
	dispatcher.dispatchCall(new Call("5"));
	dispatcher.dispatchCall(new Call("6"));
	dispatcher.dispatchCall(new Call("7"));
	dispatcher.dispatchCall(new Call("8"));
	dispatcher.dispatchCall(new Call("9"));
	dispatcher.dispatchCall(new Call("10"));
	Thread.sleep((MAXCALLTIME * 10) / 3);
	assertTrue(dispatcher.getCalls().isEmpty());
    }
     
    public void testWhenFiveteenCallsCome() throws InterruptedException {
	Dispatcher dispatcher = new Dispatcher();
	dispatcher.start();
	dispatcher.dispatchCall(new Call("1"));
	dispatcher.dispatchCall(new Call("2"));
	dispatcher.dispatchCall(new Call("3"));
	dispatcher.dispatchCall(new Call("4"));
	dispatcher.dispatchCall(new Call("5"));
	dispatcher.addAvailableEmployee(new Operator("Operador 1", dispatcher));
	dispatcher.addAvailableEmployee(new Operator("Operador 2", dispatcher));
	dispatcher.addAvailableEmployee(new Operator("Operador 3", dispatcher));
        dispatcher.addAvailableEmployee(new Supervisor("Supervisor 1", dispatcher));
	dispatcher.addAvailableEmployee(new Operator("Operador 4", dispatcher));
	dispatcher.dispatchCall(new Call("6"));
	dispatcher.addAvailableEmployee(new Director("Director 1", dispatcher));
	dispatcher.dispatchCall(new Call("7"));
	dispatcher.dispatchCall(new Call("8"));
	dispatcher.addAvailableEmployee(new Supervisor("Supervisor 2", dispatcher));
	dispatcher.dispatchCall(new Call("9"));
	dispatcher.dispatchCall(new Call("10"));
	dispatcher.dispatchCall(new Call("11"));
	dispatcher.dispatchCall(new Call("12"));
	dispatcher.addAvailableEmployee(new Director("Director 2", dispatcher));
	dispatcher.dispatchCall(new Call("13"));
	dispatcher.dispatchCall(new Call("14"));
	dispatcher.dispatchCall(new Call("15"));
	Thread.sleep((MAXCALLTIME * 15) / 8);
	assertTrue(dispatcher.getCalls().isEmpty());
    }
    
}
