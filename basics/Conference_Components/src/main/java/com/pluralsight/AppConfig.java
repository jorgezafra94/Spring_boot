package com.pluralsight;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.pluralsight"}) // va a buscar todos los componentes(repository, service, component, controller) para autowired
public class AppConfig {

}
