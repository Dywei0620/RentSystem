package cn.dywei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqReceiveApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqReceiveApplication.class,args);
    }
}
