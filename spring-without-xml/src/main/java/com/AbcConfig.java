package com;

import com.xxx.B;
import com.xxx.C;
import com.yyy.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AbcConfig {

    @Bean
    public A a(){
        A a = new A();
//        B b = new B();
//        C c = new C();
//        a.setBbb(b);
//        a.setCcc(c);
        return a;
    }

    @Bean
    public B b(){
        B b = new B();
        return b;
    }

    @Bean
    public C c(){
        C c = new C();
        return c;
    }
}
