package mypackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hello {
    private static final Logger logger = LogManager.getLogger(Hello.class);

    public static void main(String[] args) {
        logger.info("Hello");
    }
}