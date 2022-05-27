package zw.co.rubiem.netone.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@EnableEurekaClient
@SpringBootApplication
@EnableJpaRepositories("zw.co.rubiem.netone.portal")
@EntityScan({"zw.co.rubiem.netone.portal"})
public class NetOnePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetOnePortalApplication.class, args);
    }

}

