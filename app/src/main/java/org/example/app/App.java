package org.example.app;

import org.example.lib.Library;
import org.example.lib.Property.Domain.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"org.example.lib", "org.example.app"})
@SpringBootApplication
public class App {
    public static void main(String[] args) {

        /* Running as a stand alone app example
        // Consumer Example
        new SpringApplicationBuilder()
                .web(WebApplicationType.NONE)
                .run(args);
         */

        // Webapp Example
        SpringApplication.run(App.class, args);
    }
}

