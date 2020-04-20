package cn.dywei;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDistributedTransaction
public class UserLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserLoginApplication.class,args);
    }
}
