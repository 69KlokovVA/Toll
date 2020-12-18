package jdev.tracker;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import services.GPSServise;
import services.SendingService;
import services.StorageService;

/**
 * Created by jdev on 26.03.2017.
 */
@Configuration
@EnableScheduling
@EnableJpaRepositories("dao.repo")
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
    public StorageService getStorage() {
        return new StorageService();
    }

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(10);
        return scheduler;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
