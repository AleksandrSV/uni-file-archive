package tech.rowi.corp.unifilearchive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootMinioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMinioApplication.class, args);
    }

}
