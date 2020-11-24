package jdev.tracker;


import dao.repo.CoordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import services.GPSServise;
import services.SendingService;

/**
 * Created by jdev on 26.03.2017.
 */
@Configuration
@EnableScheduling
@PropertySource("classpath:/application.properties")
public class SchedulingContext {

    @Bean
    public GPSServise gpsServise() {
        return new GPSServise();
    }

    @Bean
    public SendingService sendingService() {
         return new SendingService();
    }


    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(10);
        return scheduler;
    }


}
