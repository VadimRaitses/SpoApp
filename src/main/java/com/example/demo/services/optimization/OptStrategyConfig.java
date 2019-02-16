package com.example.demo.services.optimization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OptStrategyConfig {

    @Bean
    public IOptStrategy recursiveStrategy() {
        return new RecursiveOptStrategy();
    }

    @Bean
    public IOptStrategy iterativeStrategy() {
        return new IterativeOptStrategy();
    }

}
