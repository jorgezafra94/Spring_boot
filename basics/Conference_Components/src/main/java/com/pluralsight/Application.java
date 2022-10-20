package com.pluralsight;

import com.pluralsight.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        //SpeakerService service = new SpeakerServiceImpl();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpeakerService service = context.getBean("speakerService", SpeakerService.class);
        System.out.println(service);
        System.out.println(service.findAll().get(0).getFirstName());
        SpeakerService service2 = context.getBean("speakerService", SpeakerService.class);
        System.out.println(service2); // tiene que ser la misma direccion porque es un singleton
    }
}
