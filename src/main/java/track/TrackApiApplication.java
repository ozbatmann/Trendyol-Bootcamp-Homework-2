package track;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class TrackApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackApiApplication.class, args);
    }


}
