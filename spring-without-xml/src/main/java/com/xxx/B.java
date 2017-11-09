package com.xxx;

import org.springframework.stereotype.Component;

@Component
public class B {
    public B(){
        System.out.println("Creating Bean B: " + this);
    }
}
