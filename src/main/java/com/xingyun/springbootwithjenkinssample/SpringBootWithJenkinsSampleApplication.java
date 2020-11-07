package com.xingyun.springbootwithjenkinssample;

import com.xingyun.springbootwithjenkinssample.dao.jpa.ThemeParkRideRepository;
import com.xingyun.springbootwithjenkinssample.entity.ThemeParkRide;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @sees https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/gradle-plugin/api/org/springframework/boot/gradle/tasks/bundling/BootJar.html
 */
@SpringBootApplication
public class SpringBootWithJenkinsSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithJenkinsSampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner sampleData(ThemeParkRideRepository repository) {
        return (args) -> {
            repository.save(new ThemeParkRide("Rollercoaster", "Train ride that speeds you along.", 5, 3));
            repository.save(new ThemeParkRide("Log flume", "Boat ride with plenty of splashes.", 3, 2));
            repository.save(new ThemeParkRide("Teacups", "Spinning ride in a giant tea-cup.", 2, 4));
        };
    }
}
