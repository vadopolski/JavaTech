package com.yyy;

import com.xxx.B;
import com.xxx.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    private B bbb;
    private C ccc;

    public A(){
        System.out.println("Creating Bean A:" + this);
    }

    @Autowired
    public void setBbb(B bbb) {
        System.out.println("Setting A.bbb with " + bbb);
        this.bbb = bbb;
    }

    @Autowired
    public void setCcc(C ccc) {
        System.out.println("Setting A.ccc " + ccc);
        this.ccc = ccc;
    }
}