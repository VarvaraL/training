package trnng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import trnng.model.entities.Activity;
import trnng.model.repository.ActivityRepository;
import trnng.service.ActivityService;

@SpringBootApplication
public class TrnngApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrnngApplication.class, args);
    }



}
