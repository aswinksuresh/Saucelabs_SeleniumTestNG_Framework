package com.automation.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
    @Before
    public void setUp(){
        System.out.println("Before");
    }

    @After
    public void cleanUp(){
        System.out.println("After");
    }

}
