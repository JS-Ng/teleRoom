package videoroom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BootApplication {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("current directory: " + System.getProperty("user.dir"));
        SpringApplication.run(BootApplication.class, args);
    }
}
