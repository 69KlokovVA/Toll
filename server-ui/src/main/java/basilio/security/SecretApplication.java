package basilio.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("basilio.config")
public class SecretApplication {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(SecretApplication.class, args);
    }

}
