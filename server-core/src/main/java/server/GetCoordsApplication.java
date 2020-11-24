package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import server.repo.CoordsRepository;

@SpringBootApplication
@EnableJpaRepositories("server.repo")

public class GetCoordsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetCoordsApplication.class, args);
    }

}
