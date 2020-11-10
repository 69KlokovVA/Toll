package jdev.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Schedman {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchedulingContext.class);
        SpringApplication.run(Schedman.class, args);

    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

