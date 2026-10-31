package org.example;

import org.example.config.AppConfig;
import org.example.metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println("Résultat : " + metier.calcul());
        ctx.close();

    }
}