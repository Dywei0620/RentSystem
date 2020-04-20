package cn.dywei;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDistributedTransaction
public class UserSelectbyuserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserSelectbyuserApplication.class,args);
    }
}
