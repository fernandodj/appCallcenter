/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.projects;

import java.util.Random;

/**
 *
 * @author Fernando
 */
class Call {
    public static final int MIN = 5;
    public static final int MAX = 10;
    private int duration;
    private String description;

    public Call(String description) {
	duration = new Random().nextInt(MAX - MIN + 1) + MIN;
	this.description = description;
    }

    public int getDuration() {
	return duration;
    }

    public void setDuration(int duration) {
	this.duration = duration;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }
    
}
