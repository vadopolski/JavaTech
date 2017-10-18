package com.baeldung.dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.baeldung.dependency"})
public class ApplicationContextTestAutowiredType {

    @Bean
    public ArbitraryDependency autowiredFieldDependency(){
        ArbitraryDependency autowiredFieldDependency =
            new ArbitraryDependency();
        return autowiredFieldDependency;
    }

    @Bean
    public ArbitraryDependency anotherAutowiredFieldDependency() {
        ArbitraryDependency anotherAutowiredFieldDependency =
            new AnotherArbitraryDependency();
        return anotherAutowiredFieldDependency;
    }
}
