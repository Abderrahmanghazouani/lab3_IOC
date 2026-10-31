package org.example.config;

import org.example.dao.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.example.metier")
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Value("${dao.target}")
    private String daoTarget;

    @Bean
    public IDao dynamicDao() {
        System.out.println("DAO choisi : " + daoTarget);
        switch (daoTarget) {
            case "dao":     return new DaoImpl();
            case "dao2":    return new DaoImpl2();
            case "daoFile": return new DaoFile();
            case "daoApi":  return new DaoApi();
            default: throw new IllegalArgumentException("Cible DAO inconnue: " + daoTarget);
        }
    }
}