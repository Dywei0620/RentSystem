package cn.dywei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CommentShowApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentShowApplication.class,args);
    }
}
