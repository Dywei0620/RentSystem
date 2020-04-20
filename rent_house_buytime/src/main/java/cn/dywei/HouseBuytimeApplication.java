package cn.dywei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HouseBuytimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(HouseBuytimeApplication.class,args);
    }
}
