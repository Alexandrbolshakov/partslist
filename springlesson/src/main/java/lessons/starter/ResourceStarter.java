package lessons.starter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class ResourceStarter  {

    public static final Logger LOGGER = LogManager.getLogger(ResourceStarter.class);

    public static void main(String[] args) throws IOException {
        LOGGER.info("Starting resources...");
        ResourceStarter starter = new ResourceStarter();
        starter.printClassResourcesByContextNoPrefix();
        starter.printClassResourcesByContextWithPrefix();
    }

    public void printClassResourcesByContextNoPrefix() {
        LOGGER.info("*******printClassResourcesByContextNoPrefix**********");
        ApplicationContext context = new AnnotationConfigApplicationContext();
        Resource resource = context.getResource("resources/log4j.properties");
        LOGGER.info("AnnotationConfigApplicationContext: " + resource.getClass().getSimpleName());

        context = new ClassPathXmlApplicationContext();
        resource = context.getResource("resources/log4j.properties");
        LOGGER.info("ClassPathXmlApplicationContext: " + resource.getClass().getSimpleName());

        context = new FileSystemXmlApplicationContext();
        resource = context.getResource("resources/log4j.properties");
        LOGGER.info("FileSystemXmlApplicationContext: " + resource.getClass().getSimpleName());
        LOGGER.info("****************************************************");
    }

    public void printClassResourcesByContextWithPrefix() {
        LOGGER.info("*******printClassResourcesByContextWithPrefix*******");
        ApplicationContext context = new AnnotationConfigApplicationContext();
        Resource resource = context.getResource("file:resources/log4j.properties");
        LOGGER.info("file: " + resource.getClass().getSimpleName());
        resource = context.getResource("http://spring.io/img/favicon.png");
        LOGGER.info("http: " + resource.getClass().getSimpleName());
        resource = context.getResource("classpath:resources/log4j.properties");
        LOGGER.info("classpath: " + resource.getClass().getSimpleName());
        LOGGER.info("****************************************************");
    }
}

