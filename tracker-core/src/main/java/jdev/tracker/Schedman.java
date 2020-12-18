package jdev.tracker;

import dao.Coords;
import dao.repo.CoordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


/*
@SpringBootApplication
*/
/*@EnableJpaRepositories("dao")
@EntityScan(basePackageClasses = dao.Coords.class)*//*


@ComponentScan(basePackages = {"dao.repo"})
@EntityScan(basePackages = {"dao"})
@EnableJpaRepositories(basePackages = {"dao.repo"})
*/

@SpringBootApplication


@EnableJpaRepositories("dao.repo")
@EntityScan(basePackageClasses = dao.Coords.class)
@ComponentScan({"services", "jdev.tracker"})
public class Schedman {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(SchedulingContext.class);
        SpringApplication.run(Schedman.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}



