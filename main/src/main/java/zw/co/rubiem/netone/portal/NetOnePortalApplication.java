package zw.co.rubiem.netone.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class NetOnePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetOnePortalApplication.class, args);
    }

}

